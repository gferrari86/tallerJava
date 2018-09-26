package uy.com.antel;

import java.util.Date;

public class SolicitudIMM {

    private TipoSolicitud tipoSolicitud;
    private String matriculaVehiculo;
    private Date fechaInicioEstacionamiento;
    private Date fechaHoraVenta;
    private int cantidadMinutos;
    private String numeroTicketAnulacion;
    private final String Agencia = "Agencia 1";
    private float importeTotal = 0;
    private String numeroTicket;
    private EstadoTicket estadoTicket = EstadoTicket.ACTIVO;

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

    public int getCantidadMinutos() {
        return cantidadMinutos;
    }

    public void setCantidadMinutos(int cantidadMinutos) {
        this.cantidadMinutos = cantidadMinutos;
    }

    public String getNumeroTicketAnulacion() {
        return numeroTicketAnulacion;
    }

    public void setNumeroTicketAnulacion(String numeroTicketAnulacion) {
        this.numeroTicketAnulacion = numeroTicketAnulacion;
    }

    public String getAgencia() {
        return Agencia;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public EstadoTicket getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(EstadoTicket estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    @Override
    public String toString() {
        return "SolicitudIMM{" +
                "tipoSolicitud=" + tipoSolicitud +
                ", matriculaVehiculo='" + matriculaVehiculo + '\'' +
                ", fechaInicioEstacionamiento=" + fechaInicioEstacionamiento +
                ", cantidadMinutos=" + cantidadMinutos +
                ", numeroTicketAnulacion='" + numeroTicketAnulacion + '\'' +
                ", Agencia='" + Agencia + '\'' +
                '}';
    }
}
