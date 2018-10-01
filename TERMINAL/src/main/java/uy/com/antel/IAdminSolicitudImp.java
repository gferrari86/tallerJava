package uy.com.antel;

import java.io.*;
import java.net.Socket;

public class IAdminSolicitudImp implements IAdminSolicitud{

    private static final IAdminSolicitudImp instancia = new IAdminSolicitudImp();

    private IAdminSolicitudImp() {

    }

    public static IAdminSolicitudImp getInstancia(){

        return instancia;

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
            System.out.println("Abre Conexión Cliente");
            Socket socket = new Socket("127.0.0.1",65000);

            ObjectOutputStream objetoSerial = new ObjectOutputStream(socket.getOutputStream());
            objetoSerial.writeObject(s);
            objetoSerial.flush();
            objetoSerial.close();

            ObjectInputStream objectSerial2 = new ObjectInputStream(socket.getInputStream());
            SolicitudTerminal respuestaSolicitud = (SolicitudTerminal) objectSerial2.readObject();

            System.out.println(respuestaSolicitud.toString());

            socket.close();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
