package uy.com.antel;

import java.io.IOException;
import java.io.ObjectInputStream;
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
            controladorSCAC.procesarSolicitudTerminal(s);

            System.out.println(s.getMatriculaVehiculo());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
