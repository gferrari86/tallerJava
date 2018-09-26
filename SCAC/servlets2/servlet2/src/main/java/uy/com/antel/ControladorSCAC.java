package uy.com.antel;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public class ControladorSCAC {

    public void crearTicket(SolicitudTerminal sT){

        try {
            TicketSCAC tscac = new TicketSCAC();
            tscac.setCantidadMinutos(sT.getCantidadMinutos());
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(sT.getFechaInicioEstacionamiento());
            XMLGregorianCalendar calendar2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            tscac.setFechaInicioEstacionamiento(calendar2);
            tscac.setMatriculaVehiculo(sT.getMatriculaVehiculo());


        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }


}
