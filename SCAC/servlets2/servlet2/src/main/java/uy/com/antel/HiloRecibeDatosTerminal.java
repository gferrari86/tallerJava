package uy.com.antel;

import uy.com.antel.mysql.DAOException;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class HiloRecibeDatosTerminal implements Runnable {

    protected Socket socketRecepcion;

    public HiloRecibeDatosTerminal(Socket clientSocket) throws NamingException {

        this.socketRecepcion = clientSocket;

    }

    public void run() {

        try {

            ObjectInputStream objectSerial = new ObjectInputStream(socketRecepcion.getInputStream());

            //Recibo s objeto desde la terminal
            SolicitudTerminal s = (SolicitudTerminal) objectSerial.readObject();

            //Codigo que agrega delay para probar sesiones concurrentes de Terminal
            TimeUnit.SECONDS.sleep(1);

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

            System.out.println(s.getMatriculaVehiculo());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }catch (DAOException e){

        }


    }

}
