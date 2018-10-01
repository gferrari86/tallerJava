package uy.com.antel;


import uy.com.antel.pojo.SolicitudIMM;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ImmWsImp {

    @WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public SolicitudIMM getSolicitud(SolicitudIMM sIMM){

        System.out.println("IMM Recibido TICKET de SCAC");

        System.out.println(sIMM.toString());

        sIMM.setNumeroTicket("numero_ticket_1000");

        return sIMM;

    }



}
