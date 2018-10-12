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

        //System.out.println("Envia Solicitud Cliente");
        //System.out.println(s.toString());

        try {
            //System.out.println("Abre Conexión Cliente");
            Socket socket = new Socket("127.0.0.1",65000);

            ObjectOutputStream objetoSerial = new ObjectOutputStream(socket.getOutputStream());
            objetoSerial.writeObject(s);


            ObjectInputStream objectSerial2 = new ObjectInputStream(socket.getInputStream());
            SolicitudTerminal respuestaSolicitud = (SolicitudTerminal) objectSerial2.readObject();

            //System.out.println(respuestaSolicitud.toString());

            objetoSerial.flush();
            objetoSerial.close();
            objectSerial2.close();

            socket.close();

            procesarRespuesta(respuestaSolicitud);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void procesarRespuesta(SolicitudTerminal respuestaSolicitudTerminal){

        if (respuestaSolicitudTerminal.getTipoRespuesta() == TipoRespuesta.VENTA_EXITOSA){


                System.out.println("------------------------------------------------");
                System.out.println("VENTA EXITOSA");
                System.out.println("Importe " + respuestaSolicitudTerminal.getImporteTotal());
                System.out.println("Numero de ticket " + respuestaSolicitudTerminal.getNumeroTicket());
                System.out.println("Hora de venta " + respuestaSolicitudTerminal.getFechaVenta());
                System.out.println("------------------------------------------------");



        } else if (respuestaSolicitudTerminal.getTipoRespuesta() == TipoRespuesta.ANULACION_EXITOSA){

                System.out.println("------------------------------------------------");
                System.out.println("Anulacion EXITOSA");
                System.out.println("Numero de ticket " + respuestaSolicitudTerminal.getNumeroTicket());
                System.out.println("Codigo de Anulacion " + respuestaSolicitudTerminal.getCodigoAnulacion());
                System.out.println("------------------------------------------------");


        } else if (respuestaSolicitudTerminal.getTipoRespuesta() == TipoRespuesta.ERROR_ANULACION_FECHA ){

            System.out.println("------------------------------------------------");
            System.out.println("ERROR de Anulacion ");
            System.out.println("No se puede Anular Ticket porque su fecha de incio ya paso");
            System.out.println("------------------------------------------------");


        } else if (respuestaSolicitudTerminal.getTipoRespuesta() == TipoRespuesta.ERROR_ANULACION_NO_EXISTE ){

            System.out.println("------------------------------------------------");
            System.out.println("ERROR de Anulacion ");
            System.out.println("Ticket inexistente o vendido en otra Agencia");
            System.out.println("------------------------------------------------");

        } else if (respuestaSolicitudTerminal.getTipoRespuesta() == TipoRespuesta.ERROR_ANULACION_YA_ANULADO ){

            System.out.println("------------------------------------------------");
            System.out.println("ERROR de Anulacion ");
            System.out.println("El Ticket ya figura como anulado");
            System.out.println("------------------------------------------------");

        } else if (respuestaSolicitudTerminal.getTipoRespuesta() == TipoRespuesta.ERROR_ANULACION_GRAL ){

        System.out.println("------------------------------------------------");
        System.out.println("ERROR de Anulacion ");
        System.out.println("------------------------------------------------");

    }

    }



}
