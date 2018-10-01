/*
package uy.com.antel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String args[]){

        /*
        try {
            System.out.println("Comienza lectura Servidor");
            ServerSocket socket = new ServerSocket(65000);
            Socket socketRecepcion = socket.accept();
            BufferedReader lectura =
                    new BufferedReader(new InputStreamReader(socketRecepcion.getInputStream()));
            System.out.println("Recepcion:");
            System.out.println(lectura.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            System.out.println("Comienza lectura Servidor");
            ServerSocket socket = new ServerSocket(65000);
            Socket socketRecepcion = socket.accept();

            ObjectInputStream objectSerial = new ObjectInputStream(socketRecepcion.getInputStream());
            Solicitud s = (Solicitud)objectSerial.readObject();
            System.out.println(s.getMatriculaVehiculo());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
*/