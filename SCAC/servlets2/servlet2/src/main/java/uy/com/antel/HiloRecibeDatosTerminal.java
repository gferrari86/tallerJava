package uy.com.antel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloRecibeDatosTerminal implements Runnable {

    public void run() {

        try {
            System.out.println("Comienza lectura Servidor");
            ServerSocket socket = new ServerSocket(65000);
            Socket socketRecepcion = socket.accept();

            ObjectInputStream objectSerial = new ObjectInputStream(socketRecepcion.getInputStream());
            SolicitudTerminal s = (SolicitudTerminal) objectSerial.readObject();



            ControladorSCAC controladorSCAC = ControladorSCAC.getInstancia();
            SolicitudTerminal respuestaSolicitudTerminal = controladorSCAC.procesarSolicitudTerminal(s);

            System.out.println("ENVIANDO RESPUESTA A TERMINAL");
            System.out.println(respuestaSolicitudTerminal.toString());

            ObjectOutputStream objetoSerial2 = new ObjectOutputStream(socketRecepcion.getOutputStream());
            objetoSerial2.writeObject(respuestaSolicitudTerminal);


            objectSerial.close();
            objetoSerial2.flush();
            objetoSerial2.close();
            socketRecepcion.close();
            socket.close();

            System.out.println(s.getMatriculaVehiculo());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
