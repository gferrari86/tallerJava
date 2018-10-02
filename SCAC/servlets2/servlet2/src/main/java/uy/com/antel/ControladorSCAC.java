package uy.com.antel;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

public class ControladorSCAC {


    private ControladorSCAC() {

    }

    private static final ControladorSCAC instancia = new ControladorSCAC();


    public static ControladorSCAC getInstancia(){

        return instancia;

    }


    public SolicitudTerminal procesarSolicitudTerminal(SolicitudTerminal sT){

        SolicitudTerminal respuestaSolicitudTerminal = null;

        if (sT.getTipoSolicitud() == TipoSolicitud.VENTA) {

            respuestaSolicitudTerminal = procesarSolicitudVenta(sT);

        } else if (sT.getTipoSolicitud() == TipoSolicitud.ANULACION){

            respuestaSolicitudTerminal = procesarSolicitudAnulacion(sT);
        }

        return respuestaSolicitudTerminal;


    }

    private SolicitudTerminal procesarSolicitudVenta(SolicitudTerminal sT){

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

            GregorianCalendar fechaActual = (GregorianCalendar) GregorianCalendar.getInstance();
            XMLGregorianCalendar fechaActual2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaActual);
            tscac.setFechaHoraVenta(fechaActual2);

            System.out.println("SCAC Recibido TICKET de Terminal");
            System.out.println(tscac.toString());

            //Polimorfismo TicketSCAC hereda de Solicitud IMM
            SolicitudIMM respuestaSolicitudIMM = enviarSolicitudImmWS(tscac);

            // TODO: Guardar en base de datos
            // Enviar a Terminal respuesta

            sT.setImporteTotal(respuestaSolicitudIMM.getImporteTotal());
            sT.setNumeroTicket(respuestaSolicitudIMM.getNumeroTicket());
            sT.setFechaVenta(respuestaSolicitudIMM.getFechaHoraVenta().toGregorianCalendar().getTime());
            sT.setEstadoTicket(respuestaSolicitudIMM.getEstadoTicket());


            return sT;


        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }



    }

    private SolicitudTerminal procesarSolicitudAnulacion(SolicitudTerminal sT){

        System.out.println("Procesar Solicitud Anulacion");


        //TODO:Buscar ticket en base de datos
        //TODO:Chequear que exista y que estado sea vendido
        //TODO:Chequear Hora Anulacion < Hora Inicio

        //Recupero ticket a Anular y se lo paso a IMM
        TicketSCAC tscac = new TicketSCAC();
        tscac.setNumeroTicket(sT.getNumeroTicket());
        //Le indico a IMM que lo quiero anular
        tscac.setEstadoTicket(EstadoTicket.ANULADO);
        SolicitudIMM respuestaSolicitudIMM = enviarSolicitudImmWS(tscac);

        //TODO: Actualizar base de datos con nuevos datos codigo de anulacion, fecha anulacion y estado

        sT.setCodigoAnulacion(respuestaSolicitudIMM.getCodigoAnulacion());
        //El estado puede ser Anulado o Error
        sT.setEstadoTicket(respuestaSolicitudIMM.getEstadoTicket());

        return sT;



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
