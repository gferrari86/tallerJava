package uy.com.antel.pojo;

import uy.com.antel.SolicitudIMM;

public class TicketSCAC extends SolicitudIMM {

    private String idTerminalAgencia;

    private Integer UserIdVenta;

    private Integer UserIdAnulacion;

    private String numeroTicketSCAC;

    public String getIdTerminalAgencia() {
        return idTerminalAgencia;
    }

    public void setIdTerminalAgencia(String idTerminalAgencia) {
        this.idTerminalAgencia = idTerminalAgencia;
    }

    public Integer getUserIdVenta() {
        return UserIdVenta;
    }

    public void setUserIdVenta(Integer userIdVenta) {
        UserIdVenta = userIdVenta;
    }

    public Integer getUserIdAnulacion() {
        return UserIdAnulacion;
    }

    public void setUserIdAnulacion(Integer userIdAnulacion) {
        UserIdAnulacion = userIdAnulacion;
    }

    public String getNumeroTicketSCAC() {
        return numeroTicketSCAC;
    }

    public void setNumeroTicketSCAC(String numeroTicketSCAC) {
        this.numeroTicketSCAC = numeroTicketSCAC;
    }


    @Override
    public String toString() {
        return "TicketSCAC{" +
                "idTerminalAgencia='" + idTerminalAgencia + '\'' +
                ", UserIdVenta=" + UserIdVenta +
                ", UserIdAnulacion=" + UserIdAnulacion +
                ", numeroTicketSCAC='" + numeroTicketSCAC + '\'' +
                ", agencia='" + agencia + '\'' +
                ", cantidadMinutos=" + cantidadMinutos +
                ", codigoAnulacion='" + codigoAnulacion + '\'' +
                ", estadoTicket=" + estadoTicket +
                ", fechaHoraAnulacion=" + fechaHoraAnulacion +
                ", fechaHoraVenta=" + fechaHoraVenta +
                ", fechaInicioEstacionamiento=" + fechaInicioEstacionamiento +
                ", importeTotal=" + importeTotal +
                ", matriculaVehiculo='" + matriculaVehiculo + '\'' +
                ", numeroTicket='" + numeroTicket + '\'' +
                ", tipoSolicitud=" + tipoSolicitud +
                '}';
    }
}
