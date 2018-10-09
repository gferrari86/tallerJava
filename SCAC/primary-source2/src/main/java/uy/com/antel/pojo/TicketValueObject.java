package uy.com.antel.pojo;

import java.util.Date;

public class TicketValueObject {
    private int numeroTicketSCAC;
    private String tipoSolicitud;
    private String matricula;
    private Date fechaInicioEstacionamiento;
    private Date fechaHoraVenta;
    private int cantidadMinutos;
    private int idTerminal;
    private String estadoTicket;
    private int monto;
    private int codigoAnulacion;
    private int userIdVenta;
    private int userIdAnulacio;

    public int getNumeroTicketSCAC() {
        return numeroTicketSCAC;
    }

    public void setNumeroTicketSCAC(int numeroTicketSCAC) {
        this.numeroTicketSCAC = numeroTicketSCAC;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFechaInicioEstacionamiento() {
        return fechaInicioEstacionamiento;
    }

    public void setFechaInicioEstacionamiento(Date fechaInicioEstacionamiento) {
        this.fechaInicioEstacionamiento = fechaInicioEstacionamiento;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public int getCantidadMinutos() {
        return cantidadMinutos;
    }

    public void setCantidadMinutos(int cantidadMinutos) {
        this.cantidadMinutos = cantidadMinutos;
    }

    public int getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(int idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCodigoAnulacion() {
        return codigoAnulacion;
    }

    public void setCodigoAnulacion(int codigoAnulacion) {
        this.codigoAnulacion = codigoAnulacion;
    }

    public int getUserIdVenta() {
        return userIdVenta;
    }

    public void setUserIdVenta(int userIdVenta) {
        this.userIdVenta = userIdVenta;
    }

    public int getUserIdAnulacio() {
        return userIdAnulacio;
    }

    public void setUserIdAnulacio(int userIdAnulacio) {
        this.userIdAnulacio = userIdAnulacio;
    }

    @Override
    public String toString() {
        return "TicketValueObject{" +
                "numeroTicketSCAC=" + numeroTicketSCAC +
                ", tipoSolicitud='" + tipoSolicitud + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fechaInicioEstacionamiento=" + fechaInicioEstacionamiento +
                ", fechaHoraVenta=" + fechaHoraVenta +
                ", cantidadMinutos=" + cantidadMinutos +
                ", idTerminal=" + idTerminal +
                ", estadoTicket='" + estadoTicket + '\'' +
                ", monto=" + monto +
                ", codigoAnulacion=" + codigoAnulacion +
                ", userIdVenta=" + userIdVenta +
                ", userIdAnulacio=" + userIdAnulacio +
                '}';
    }
}
