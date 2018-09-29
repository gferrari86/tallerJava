package uy.com.antel;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public class ControladorSCAC {


    private ControladorSCAC() {

    }

    private static final ControladorSCAC instancia = new ControladorSCAC();


    public static ControladorSCAC getInstancia(){

        return instancia;

    }


    public void procesarSolicitudTerminal(SolicitudTerminal sT){


        if (sT.getTipoSolicitud() == TipoSolicitud.VENTA) {

            procesarSolicitudVenta(sT);

        } else if (sT.getTipoSolicitud() == TipoSolicitud.ANULACION){

            procesarSolicitudAnulacion(sT);
        }


    }

    private void procesarSolicitudVenta(SolicitudTerminal sT){

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

            // Generar Hora actual
            // Guardar Agencia

            // Enviar por WS Solicitud IMM (polimorfismo)



        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }



    }

    private void procesarSolicitudAnulacion(SolicitudTerminal sT){

        System.out.println("Procesar Solicitud Anulacion");


    }


}
