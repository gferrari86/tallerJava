package uy.com.antel;

public class TicketSCAC extends SolicitudIMM {

    private String idTerminalAgencia;

    public String getIdTerminalAgencia() {
        return idTerminalAgencia;
    }

    public void setIdTerminalAgencia(String idTerminalAgencia) {
        this.idTerminalAgencia = idTerminalAgencia;
    }


    @Override
    public String toString() {
        return "TicketSCAC{" +
                "idTerminalAgencia='" + idTerminalAgencia + '\'' +
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
