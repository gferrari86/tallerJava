package uy.com.antel;

import uy.com.antel.mysql.DAOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name="reporteBean")
@SessionScoped

public class ReporteBean {

    private Date fechaini;
    private Date fechafin;
    private ArrayList<String> meses=new ArrayList<String>();


    public List<String> getMeses(){
        return meses;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String CalculaVentas() throws NamingException, DAOException {
        if ((getFechafin() == null) || (getFechaini()==null)) {
            return "0";}

            else if (fechaini.compareTo(fechafin) <= 0) {

                System.out.println("fechaini " + getFechaini() + "  fechafin: " + getFechafin());
                ControladorVistaIMM controllerweb = new ControladorVistaIMM();
                float montoVendido = 0;
                montoVendido = controllerweb.calculaMontoVendido(getFechaini(), getFechafin());
                System.out.println("calculo "+ montoVendido);
                return Float.toString(montoVendido);

            }
            else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Las fecha de inicio no puede ser mayor a la fecha de fin",
                        "");
                FacesContext.getCurrentInstance().addMessage(null, message);
                }

    fechafin=null;
    fechaini=null;
    return "0";
    }

    public String CalculaxMeses(){

        return null;

    }

}
