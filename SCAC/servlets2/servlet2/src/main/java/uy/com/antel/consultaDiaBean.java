package uy.com.antel;

import uy.com.antel.pojo.TicketSCAC;
import uy.com.antel.pojo.TicketValueObject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@SessionScoped
public class consultaDiaBean implements Serializable {

    public Date date;
    private List<TicketSCAC> ticketsDia;

    public List<TicketSCAC> getTicketsDia() {
        return ticketsDia;
    }

    public void setTicketsDia(List<TicketSCAC> ticketsDia) {
        this.ticketsDia = ticketsDia;
    }

    /*
    private List<TicketValueObject> ticketsDia;

    public List<TicketValueObject> getTicketsDia() {
        return ticketsDia;
    }

    public void setTicketsDia(List<TicketValueObject> ticketsDia) {
        this.ticketsDia = ticketsDia;
    }

*/
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Date dateFIE=xmlGregorianCalendarToDate(a.getFechaInicioEstacionamiento(), TimeZone.getTimeZone("GMT-3:00"));

    public Date getXmlGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3:00"));
        System.out.println("xmlGregorianCalendarToDate");
        System.out.println(xmlGregorianCalendar);
        System.out.println(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
        return new Date(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
    }

    // Lo hice para prueba, hay que cambiarlo para ir contra la dB
    /*public List devuelveVoList(Date fecha){

        System.out.println(fecha);
        List<TicketValueObject>  ticketList = new ArrayList();

        TicketValueObject ticket1 = new TicketValueObject();
        ticket1.setNumeroTicketSCAC(1);
        ticket1.setFechaHoraVenta(fecha);
        ticket1.setMonto(100);
        ticketList.add(ticket1);

        TicketValueObject ticket2 = new TicketValueObject();
        ticket2.setNumeroTicketSCAC(2);
        ticket2.setFechaHoraVenta(fecha);
        ticket2.setMonto(101);
        ticketList.add(ticket2);

        return ticketList;
    }*/

    public String consultaFecha(){

        int offset = this.getDate().getTimezoneOffset();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getDate());
        cal.add(Calendar.MINUTE, offset);


        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date nuevaFecha = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date nuevaFechaFin = cal.getTime();

        System.out.println("Fechas de la consulta");
        System.out.println(nuevaFecha);
        System.out.println(nuevaFechaFin);

        //ticketsDia = devuelveVoList(nuevaFecha);

        //AdminEditoriales interfazAdminEditoriales = new AdminEditorialesBase();
        //List<ListadoValueObject> publicaciones = interfazAdminEditoriales.obtenerPublicaciones();
        ControladorSCAC controladorSCAC = ControladorSCAC.getInstancia();



        List<TicketSCAC> ticketList = new ArrayList<TicketSCAC>();
        ticketList = controladorSCAC.consultaFecha(nuevaFecha, nuevaFechaFin);

        System.out.println("Imprimo tickets");
        System.out.println(ticketList.size());
        for (TicketSCAC ticket : ticketList){
            System.out.println(ticket);
            TicketValueObject ticketVO = new TicketValueObject();
            //ticketVO.setNumeroTicketSCAC(ticket.getNumeroTicketSCAC());
            //ticketVO.setTipoSolicitud(ticket.getTipoSolicitud());

        }


        //ticketsDia = devuelveVoList(nuevaFecha);
        ticketsDia = ticketList;
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego con exito la fecha"
                , "se capturo la fecha" + nuevaFecha);


        return null;
    }


}
