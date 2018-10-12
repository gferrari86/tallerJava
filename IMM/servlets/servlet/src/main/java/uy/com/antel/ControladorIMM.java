package uy.com.antel;

import uy.com.antel.mysql.DAOException;
import uy.com.antel.mysql.DAOManager;
import uy.com.antel.pojo.EstadoTicket;
import uy.com.antel.pojo.SolicitudIMM;
import uy.com.antel.pojo.TipoSolicitud;

import javax.naming.NamingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ControladorIMM {

    private ControladorIMM() {

    }

    private static final ControladorIMM instancia = new ControladorIMM();

    public static ControladorIMM getInstancia(){

        return instancia;

    }
    public static String GeneroTicketIMM (String m) {

        SecureRandom random = new SecureRandom();
        String text = new BigInteger(64, random).toString(16);
        //System.out.println("imm" + text);
        return m+text;
    }
    public SolicitudIMM procesarSolicitudSCAC(SolicitudIMM sScac) throws NamingException, DAOException {

        if (sScac.getTipoSolicitud() == TipoSolicitud.VENTA) {

            System.out.println("Procesando en IMM venta de Ticket");

            sScac.setImporteTotal(calcularImporteTicket(sScac.getCantidadMinutos()));
            sScac.setEstadoTicket(EstadoTicket.VENDIDO);

            sScac.setNumeroTicket(GeneroTicketIMM("imm"));

            //Guarda en BASE
            DAOManager guardoTicket = new DAOManager();
            guardoTicket.getTicketMysqlDAO().insertar(sScac);

            System.out.println("Ticket IMM guardado en Base");


        } else if (sScac.getTipoSolicitud() == TipoSolicitud.ANULACION) {

            DAOManager obtenerTicket = new DAOManager();
            SolicitudIMM TicketImm = obtenerTicket.getTicketMysqlDAO().obtener(sScac.getNumeroTicket());

            if (TicketImm == null) {

                System.out.println("IMM: No obtengo Ticket. Puntero Nulo");
                sScac.setEstadoTicket(EstadoTicket.ERROR);
            } else {

                System.out.println("IMM: Ticket Obtenido en IMM para Anular");
                System.out.println(TicketImm.toString());

                if (TicketImm.getEstadoTicket() != EstadoTicket.VENDIDO) {

                    System.out.println("IMM: No se puede anular: Estado del Ticket no es vendido");
                    sScac.setEstadoTicket(EstadoTicket.ERROR);

                } else {

                    Calendar fechaActual = Calendar.getInstance();

                    Calendar fechaInicioEstacionamiento = Calendar.getInstance();
                    fechaInicioEstacionamiento.setTime(TicketImm.getFechaInicioEstacionamiento());

                    System.out.println("IMM: fechaActual");
                    System.out.println(fechaActual);

                    System.out.println("IMM: fechaInicioEstacionamiento");
                    System.out.println(fechaInicioEstacionamiento);

                    if (fechaActual.compareTo(fechaInicioEstacionamiento) > 0) {

                        System.out.println("IMM: No se puede anular: fecha ya paso");
                        sScac.setEstadoTicket(EstadoTicket.ERROR);


                    } else {

                        //Le indico a IMM que lo quiero anular
                        sScac.setEstadoTicket(EstadoTicket.ANULADO);
                        sScac.setCodigoAnulacion(GeneroTicketIMM("Ximm"));
                        sScac.setFechaHoraAnulacion(new Date());

                        //Se actualiza base de datos con Estado, codigo de anlacion y fecha de anulación
                        DAOManager actualizoTicket = new DAOManager();
                        actualizoTicket.getTicketMysqlDAO().modificar(sScac);


                    }
                }


            }


        }

        return sScac;
    }

    private float calcularImporteTicket( int cantidadMinutos){

        return cantidadMinutos * 2;

    }


}
