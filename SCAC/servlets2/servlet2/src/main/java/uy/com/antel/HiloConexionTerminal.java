package uy.com.antel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class HiloConexionTerminal implements Runnable {

    public void run() {

            try {
                System.out.println("Comienza lectura Servidor");
                ServerSocket socket = new ServerSocket(65000);

                while(true) {

                    Socket socketRecepcion = socket.accept();
                    Thread t = new Thread(new HiloRecibeDatosTerminal(socketRecepcion));
                    t.start();

                }


            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
