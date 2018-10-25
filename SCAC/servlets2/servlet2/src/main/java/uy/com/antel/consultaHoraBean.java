package uy.com.antel;

import uy.com.antel.pojo.TicketSCAC;
import uy.com.antel.pojo.TicketValueObject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@SessionScoped
public class consultaHoraBean implements Serializable {

    public Date dateStart;
    public Date dateStop;
    private List<TicketSCAC> ticketsHora;


    public List<TicketSCAC> getTicketsHora() {
        return ticketsHora;
    }

    public void setTicketsHora(List<TicketSCAC> ticketsHora) {
        this.ticketsHora = ticketsHora;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateStop() {
        return dateStop;
    }

    public void setDateStop(Date dateStop) {
        this.dateStop = dateStop;
    }



    // Lo hice para prueba, hay que cambiarlo para ir contra la dB
    public List devuelveVoList(Date fecha){

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
    }

    private Date corrijeFecha(Date fecha){


        // corregir la zona horaria y no usar el offset
        int offsetStart = fecha.getTimezoneOffset();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        //cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.add(Calendar.MINUTE, offsetStart);
        Date nuevaFecha = cal.getTime();
        System.out.println("Fecha antes de corregir" + fecha);
        System.out.println("fecha corregida" + nuevaFecha);
        return nuevaFecha;
    }
    private Date corrijeTz(Date date){
        String TZ = "GMT-3:00";
        TimeZone timezone = TimeZone.getTimeZone(TZ);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.getDateStart());
        gregorianCalendar.setTimeZone(timezone);
        Date nuevaFecha = gregorianCalendar.getTime();

        System.out.println("Fecha antes de corregir" + date);
        System.out.println("fecha corregida" + nuevaFecha);

        return nuevaFecha;
    }

    public String consultaFechaHoras(){

        //Date fechaComienzo = corrijeFecha(this.getDateStart());
        //Date fechaFinal = corrijeFecha(this.getDateStop());


        Date fechaComienzo = this.getDateStart();
        Date fechaFinal = this.getDateStop();

        System.out.println(fechaComienzo);
        System.out.println(fechaFinal);

        //List<TicketSCAC> ticketList = new ArrayList<TicketSCAC>();
        ControladorSCAC controladorSCAC = ControladorSCAC.getInstancia();
        ticketsHora = controladorSCAC.consultaFecha(fechaComienzo, fechaFinal);


        //ticketsHora = devuelveVoList(fechaFinal);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego con exito la fecha"
                , "se capturo la fecha" + fechaFinal);

        return null;
    }

}
