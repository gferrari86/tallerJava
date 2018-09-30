package uy.com.antel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class IAdminSolicitudImp implements IAdminSolicitud{

    private static final IAdminSolicitudImp instancia = new IAdminSolicitudImp();
    private Socket socket;

    private IAdminSolicitudImp() {

    }

    public static IAdminSolicitudImp getInstancia(){

        return instancia;

    }


    @Override
    public void abrirConexion() {

        System.out.println("Abre Conexión Cliente");
        try {
            socket = new Socket("127.0.0.1",65000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*

    @Override
    public void enviarSolicitud(Solicitud solicitud) {

        System.out.println(solicitud.toString());

    }

    @Override
    public void enviarString() {

        System.out.println("Envia String Cliente");

        try {
            PrintWriter prueba = new PrintWriter(socket.getOutputStream(), true);
            prueba.println("Mensaje de Prueba");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    */

    @Override
    public void enviarSolicitud(SolicitudTerminal s) {

        System.out.println("Envia Solicitud Cliente");
        System.out.println(s.toString());

        try {
            ObjectOutputStream objetoSerial = new ObjectOutputStream(socket.getOutputStream());
            objetoSerial.writeObject(s);
            objetoSerial.flush();
            objetoSerial.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
