package uy.com.antel.pojo;

import java.util.Date;

public class SolicitudIMM {

    private String numeroTicket;
    private TipoSolicitud tipoSolicitud;
    private String matriculaVehiculo;
    private Date fechaInicioEstacionamiento;
    private Date fechaHoraVenta;
    private int cantidadMinutos;
    private String codigoAnulacion;
    private Date fechaHoraAnulacion;
    private String Agencia;
    private float importeTotal = 0;
    private EstadoTicket estadoTicket = EstadoTicket.VENDIDO;

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

    public String getCodigoAnulacion() {
        return codigoAnulacion;
    }

    public void setCodigoAnulacion(String codigoAnulacion) {
        this.codigoAnulacion = codigoAnulacion;
    }

    public Date getFechaHoraAnulacion() {
        return fechaHoraAnulacion;
    }

    public void setFechaHoraAnulacion(Date fechaHoraAnulacion) {
        this.fechaHoraAnulacion = fechaHoraAnulacion;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String Agencia){
        this.Agencia=Agencia;
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

    public EstadoTicket getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(EstadoTicket eTicket) {
        this.estadoTicket = eTicket;
    }

    @Override
    public String toString() {
        return "SolicitudIMM{" +
                "tipoSolicitud=" + tipoSolicitud +
                ", matriculaVehiculo='" + matriculaVehiculo + '\'' +
                ", fechaInicioEstacionamiento=" + fechaInicioEstacionamiento +
                ", fechaHoraVenta=" + fechaHoraVenta +
                ", cantidadMinutos=" + cantidadMinutos +
                ", codigoAnulacion='" + codigoAnulacion + '\'' +
                ", fechaHoraAnulacion=" + fechaHoraAnulacion +
                ", Agencia='" + Agencia + '\'' +
                ", importeTotal=" + importeTotal +
                ", numeroTicket='" + numeroTicket + '\'' +
                ", estadoTicket=" + estadoTicket +
                '}';
    }
}
