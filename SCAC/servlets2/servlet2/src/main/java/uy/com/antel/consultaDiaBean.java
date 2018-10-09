package uy.com.antel;

import uy.com.antel.pojo.TicketValueObject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class consultaDiaBean implements Serializable {

    public Date date;
    private List<TicketValueObject> ticketsDia;

    public List<TicketValueObject> getTicketsDia() {
        return ticketsDia;
    }

    public void setTicketsDia(List<TicketValueObject> ticketsDia) {
        this.ticketsDia = ticketsDia;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String consultaFecha(){


        ticketsDia = devuelveVoList(this.getDate());


        System.out.println("llegue aca");
        System.out.println(this.getDate());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego con exito la fecha"
                , "se capturo la fecha" + this.getDate());

        /*
        AdminEditoriales interfazAdminEditoriales = new AdminEditorialesBase();
        try {
            interfazAdminEditoriales.agregarEditoriales(editorial);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego con exito la editorial"
                    , "fue ingresada con exito");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (EditorialExisteException existeException){
            String mensaje = existeException.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje
                    , mensaje);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        return null;
        */
        return null;
    }


}
