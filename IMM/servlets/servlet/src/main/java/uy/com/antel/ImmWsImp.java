package uy.com.antel;


import uy.com.antel.mysql.DAOException;
import uy.com.antel.pojo.SolicitudIMM;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.NamingException;

@WebService
public class ImmWsImp {

    @WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public SolicitudIMM getSolicitud(SolicitudIMM sIMM) throws DAOException, NamingException {

        System.out.println("IMM Recibido TICKET de SCAC.");

        System.out.println(sIMM.toString());


        ControladorIMM controladorIMM = ControladorIMM.getInstancia();
        SolicitudIMM respuestaSolicitudIMM = controladorIMM.procesarSolicitudSCAC(sIMM);



        return respuestaSolicitudIMM;

    }



}
