package uy.com.antel;

import java.io.Serializable;
import java.util.Date;

public class SolicitudTerminal implements Serializable{

    private TipoSolicitud tipoSolicitud;
    private String matriculaVehiculo;
    private Date fechaInicioEstacionamiento;
    private Date fechaVenta;
    private int cantidadMinutos;
    private float importeTotal;
    private String numeroTicket;
    private String codigoAnulacion;
    private Date fechaAnulacion;
    private final String idTerminalAgencia = "Sucursal 1 - Agencia 1";


    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public Date getFechaInicioEstacionamiento() {
        return fechaInicioEstacionamiento;
    }

    public void setFechaInicioEstacionamiento(Date fechaInicioEstacionamiento) {
        this.fechaInicioEstacionamiento = fechaInicioEstacionamiento;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidadMinutos() {
        return cantidadMinutos;
    }

    public void setCantidadMinutos(int cantidadMinutos) {
        this.cantidadMinutos = cantidadMinutos;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getCodigoAnulacion() {
        return codigoAnulacion;
    }

    public void setCodigoAnulacion(String codigoAnulacion) {
        this.codigoAnulacion = codigoAnulacion;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getIdTerminalAgencia() {
        return idTerminalAgencia;
    }

    @Override
    public String toString() {
        return "SolicitudTerminal{" +
                "tipoSolicitud=" + tipoSolicitud +
                ", matriculaVehiculo='" + matriculaVehiculo + '\'' +
                ", fechaInicioEstacionamiento=" + fechaInicioEstacionamiento +
                ", fechaVenta=" + fechaVenta +
                ", cantidadMinutos=" + cantidadMinutos +
                ", importeTotal=" + importeTotal +
                ", numeroTicket='" + numeroTicket + '\'' +
                ", codigoAnulacion='" + codigoAnulacion + '\'' +
                ", fechaAnulacion=" + fechaAnulacion +
                ", idTerminalAgencia='" + idTerminalAgencia + '\'' +
                '}';
    }
}
