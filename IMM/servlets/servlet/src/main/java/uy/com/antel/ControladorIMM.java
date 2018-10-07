package uy.com.antel;

import uy.com.antel.mysql.DAOException;
import uy.com.antel.mysql.DAOManager;
import uy.com.antel.pojo.EstadoTicket;
import uy.com.antel.pojo.SolicitudIMM;
import uy.com.antel.pojo.TipoSolicitud;

import javax.naming.NamingException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ControladorIMM {

    private ControladorIMM() {

    }

    private static final ControladorIMM instancia = new ControladorIMM();

    public static ControladorIMM getInstancia(){

        return instancia;

    }
    public static String GeneroTicketIMM () {

        SecureRandom random = new SecureRandom();
        String text = new BigInteger(64, random).toString(16);
        //System.out.println("imm" + text);
        return "imm"+text;
    }
    public SolicitudIMM procesarSolicitudSCAC(SolicitudIMM sScac) throws NamingException, DAOException {

        if(sScac.getTipoSolicitud() == TipoSolicitud.VENTA){

            //TODO: Calcular importe

            sScac.setImporteTotal(123);
            sScac.setEstadoTicket(EstadoTicket.VENDIDO);

            //TODO: Generar numero de ticket
            sScac.setNumeroTicket(GeneroTicketIMM());

            //TODO: Guardar en base de datos
            DAOManager guardoTicket= new DAOManager();
            guardoTicket.getTicketMysqlDAO().insertar(sScac);

            return sScac;

        }else if(sScac.getTipoSolicitud() == TipoSolicitud.ANULACION){

            //TODO: Traer ticket de base de datos
            //TODO: Chequear que el ticket lo haya vendido la agencia??
            //TODO: Chequear Hora Anulacion < Hora Inicio
            //TODO: Chequear que Estado sea Vendido

            sScac.setCodigoAnulacion("codigo_anulacion_2000");

            return sScac;

        }



        return null;

    }


}
