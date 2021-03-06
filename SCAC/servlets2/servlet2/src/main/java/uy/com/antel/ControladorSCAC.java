package uy.com.antel;


import uy.com.antel.mysql.DAOException;
import uy.com.antel.mysql.DAOManagerScac;
import uy.com.antel.pojo.TicketSCAC;
import uy.com.antel.pojo.UsuarioTerminal;

import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

import static uy.com.antel.mysql.TicketDaoMysqlScac.xmlGregorianCalendarToDate;

public class ControladorSCAC {


    private ControladorSCAC() {

    }

    private static final ControladorSCAC instancia = new ControladorSCAC();


    public static ControladorSCAC getInstancia() {

        return instancia;

    }

    public static String GeneroTicketSCAC () {

        SecureRandom random = new SecureRandom();
        String text = new BigInteger(64, random).toString(16);
        //System.out.println("imm" + text);
        return "scac"+text;
    }

    public SolicitudTerminal procesarSolicitudTerminal(SolicitudTerminal sT) throws NamingException, DAOException {

        SolicitudTerminal respuestaSolicitudTerminal = null;

        //obtengo pass user
        DAOManagerScac consultaDB= new DAOManagerScac();
        String user = sT.getUser();
        UsuarioTerminal userDB= consultaDB.getUsuarioTMysqlDAO().obtener(user);

        //String pass = "Pass1";

        try {
            String myHash = CreaHash(user, userDB.getPass());

            if (myHash.equals(sT.getHash())) {
                if (sT.getTipoSolicitud() == TipoSolicitud.VENTA) {

                    respuestaSolicitudTerminal = procesarSolicitudVenta(sT);

                } else if (sT.getTipoSolicitud() == TipoSolicitud.ANULACION) {

                    respuestaSolicitudTerminal = procesarSolicitudAnulacion(sT);
                }
                return respuestaSolicitudTerminal;
            } else {
                sT.setTipoRespuesta(TipoRespuesta.ERROR_AUTENTICACION_TERMINAL);
                return sT;
            }



        } catch (Exception e) {
            System.out.println(e.toString());
            sT.setTipoRespuesta(TipoRespuesta.ERROR_AUTENTICACION_TERMINAL);
            return respuestaSolicitudTerminal;
        }

    }

    private SolicitudTerminal procesarSolicitudVenta(SolicitudTerminal sT) {

        System.out.println("Procesar Solicitud Venta");

        try {

            TicketSCAC tscac = new TicketSCAC();
            tscac.setTipoSolicitud(sT.getTipoSolicitud());
            tscac.setMatriculaVehiculo(sT.getMatriculaVehiculo());
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(sT.getFechaInicioEstacionamiento());
            XMLGregorianCalendar calendar2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            tscac.setFechaInicioEstacionamiento(calendar2);
            tscac.setCantidadMinutos(sT.getCantidadMinutos());
            tscac.setIdTerminalAgencia(sT.getIdTerminalAgencia());

            //paso fecha2XMLGregorianCalendar
            GregorianCalendar fechaActual = (GregorianCalendar) GregorianCalendar.getInstance();
            XMLGregorianCalendar fechaActual2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaActual);
            tscac.setFechaHoraVenta(fechaActual2);
            tscac.setEstadoTicket(sT.getEstadoTicket());

            //Inicializo variables
            tscac.setCodigoAnulacion("NC");

            //Debe venir desde la terminal el usuario
            tscac.setUserIdVenta(1);
            tscac.setUserIdAnulacion(1);

            //Crear metodo generador de ticketSCAC
            tscac.setNumeroTicketSCAC(GeneroTicketSCAC());

            //Identifico la Agencia
            tscac.setAgencia("Abitab");



            System.out.println("SCAC Recibido TICKET de Terminal");
            System.out.println(tscac.toString());

            //Polimorfismo TicketSCAC hereda de Solicitud IMM
            SolicitudIMM respuestaSolicitudIMM = enviarSolicitudImmWS(tscac);

            tscac.setNumeroTicket(respuestaSolicitudIMM.getNumeroTicket());
            tscac.setImporteTotal(respuestaSolicitudIMM.getImporteTotal());
            tscac.setEstadoTicket(respuestaSolicitudIMM.getEstadoTicket());

            //Guarda en base de datos ticket

            DAOManagerScac guardo = new DAOManagerScac();
            guardo.getTicketMysqlDAO().insertar(tscac);
            // Enviar a Terminal respuesta

            sT.setImporteTotal(respuestaSolicitudIMM.getImporteTotal());
            sT.setNumeroTicket(respuestaSolicitudIMM.getNumeroTicket());
            sT.setFechaVenta(respuestaSolicitudIMM.getFechaHoraVenta().toGregorianCalendar().getTime());
            sT.setEstadoTicket(respuestaSolicitudIMM.getEstadoTicket());
            sT.setTipoRespuesta(TipoRespuesta.VENTA_EXITOSA);

            return sT;

        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }


    }
    private static String CreaHash(String u, String p) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((u+p).getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return myHash;
    }

    private SolicitudTerminal procesarSolicitudAnulacion(SolicitudTerminal sT){

        try {
            System.out.println("Procesar Solicitud Anulacion");

            DAOManagerScac obtengo = new DAOManagerScac();

            // Si no se encuentra ticket DAOException DAOException "No se ha encontrado registro: "
            TicketSCAC tscac2 = obtengo.getTicketMysqlDAO().obtener(sT.getNumeroTicket());

            if(tscac2 == null){

                System.out.println("No obtengo Ticket. Puntero Nulo");
                sT.setTipoRespuesta(TipoRespuesta.ERROR_ANULACION_NO_EXISTE);
            } else {

                System.out.println("Ticket Obtenido en SCAC para Anular");
                System.out.println(tscac2.toString());

                if (tscac2.getEstadoTicket() != EstadoTicket.VENDIDO){

                    System.out.println("No se puede anular: Estado del Ticket no es vendido");
                    sT.setTipoRespuesta(TipoRespuesta.ERROR_ANULACION_YA_ANULADO);

                } else {

                    Calendar fechaActual = Calendar.getInstance();

                    Date dateInicioEstacionamiento=xmlGregorianCalendarToDate(tscac2.getFechaInicioEstacionamiento(), TimeZone.getTimeZone("GMT-3:00"));

                    Calendar fechaInicioEstacionamiento = Calendar.getInstance();
                    fechaInicioEstacionamiento.setTime(dateInicioEstacionamiento);

                    System.out.println("fechaActual");
                    System.out.println(fechaActual);

                    System.out.println("fechaInicioEstacionamiento");
                    System.out.println(fechaInicioEstacionamiento);

                    if ( fechaActual.compareTo(fechaInicioEstacionamiento) > 0 ){

                        System.out.println("No se puede anular: fecha ya paso");
                        sT.setTipoRespuesta(TipoRespuesta.ERROR_ANULACION_FECHA);


                    } else {

                        //Le indico a IMM que lo quiero anular
                        tscac2.setTipoSolicitud(TipoSolicitud.ANULACION);
                        SolicitudIMM respuestaSolicitudIMM = enviarSolicitudImmWS(tscac2);

                        if(respuestaSolicitudIMM.getEstadoTicket() == EstadoTicket.ERROR){
                            sT.setTipoRespuesta(TipoRespuesta.ERROR_ANULACION_GRAL);
                        } else {

                            tscac2.setCodigoAnulacion(respuestaSolicitudIMM.getCodigoAnulacion());
                            tscac2.setEstadoTicket(respuestaSolicitudIMM.getEstadoTicket());

                            DAOManagerScac actualizoTicket = new DAOManagerScac();
                            actualizoTicket.getTicketMysqlDAO().modificar(tscac2);

                            sT.setCodigoAnulacion(respuestaSolicitudIMM.getCodigoAnulacion());
                            //El estado puede ser Anulado o Error
                            sT.setEstadoTicket(respuestaSolicitudIMM.getEstadoTicket());
                            sT.setTipoRespuesta(TipoRespuesta.ANULACION_EXITOSA);
                        }


                    }

                }

            }


        } catch (NamingException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return sT;



    }

    public List<TicketSCAC> consultaFecha(Date fechaInicio, Date fechaFinal){
        try {
            System.out.println("Consulta por fecha inicio " + fechaInicio + " fecha final " + fechaFinal);

            DAOManagerScac obtengo = new DAOManagerScac();
            List<TicketSCAC> ticketList = new ArrayList<TicketSCAC>();
            ticketList = obtengo.getTicketMysqlDAO().obtenerEntreFechas(fechaInicio, fechaFinal);

            /*
            System.out.println("Imprimo tickets");
            System.out.println(ticketList.size());
            for (TicketSCAC ticket: ticketList){
                System.out.println(ticket);
            }
            */
            return ticketList;

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private SolicitudIMM enviarSolicitudImmWS (SolicitudIMM sImm){


        try {
            URL url = new URL("http://localhost:8080/servlet/sv?wsdl");
            QName qname = new QName("http://antel.com.uy/", "ImmWsImpService");

            Service service = Service.create(url, qname);
            ImmWsImp converter = service.getPort(ImmWsImp.class);

            SolicitudIMM sImmCompleta = converter.getSolicitud(sImm);

            System.out.println("SCAC Recibido TICKET de IMM");

            System.out.println(sImmCompleta.getNumeroTicket());

            return sImmCompleta;


        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }





    }


}
