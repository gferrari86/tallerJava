package uy.com.antel;

public interface IAdminSolicitud {

    void abrirConexion();
    void enviarSolicitud(Solicitud solicitud);
    void enviarString();
    void enviarObjeto(Solicitud s);

}
