package uy.com.antel;

public class IAdminSolicitudImp implements IAdminSolicitud{

    private static final IAdminSolicitudImp instancia = new IAdminSolicitudImp();

    private IAdminSolicitudImp() {

    }

    public static IAdminSolicitudImp getInstancia(){

        return instancia;

    }


    @Override
    public void enviarSolicitud(Solicitud solicitud) {

        System.out.println(solicitud.getTipoSolicitud());
        System.out.println(solicitud.getMatriculaVehiculo());
        System.out.println(solicitud.getFechaInicioEstacionamiento());
        System.out.println(solicitud.getCantidadMinutos());
        System.out.println(solicitud.getNumeroTicketAnulacion());
        System.out.println(solicitud.getIdTerminalAgencia());

    }
}
