package uy.com.antel;

import java.util.Date;

public class Solicitud {

    private TipoSolicitud tipoSolicitud;
    private String matriculaVehiculo;
    private Date fechaInicioEstacionamiento;
    private int cantidadMinutos;
    private String numeroTicketAnulacion;
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

    public String getIdTerminalAgencia() {
        return idTerminalAgencia;
    }
}
