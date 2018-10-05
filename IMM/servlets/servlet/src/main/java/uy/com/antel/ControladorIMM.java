package uy.com.antel;

import uy.com.antel.pojo.EstadoTicket;
import uy.com.antel.pojo.SolicitudIMM;
import uy.com.antel.pojo.TipoSolicitud;

public class ControladorIMM {

    private ControladorIMM() {

    }

    private static final ControladorIMM instancia = new ControladorIMM();


    public static ControladorIMM getInstancia(){

        return instancia;

    }

    public SolicitudIMM procesarSolicitudSCAC(SolicitudIMM sScac){

        if(sScac.getTipoSolicitud() == TipoSolicitud.VENTA){

            //TODO: Calcular importe
            //TODO: Generar numero de ticket
            //TODO: Guardar en base de datos
            sScac.setNumeroTicket("numero_ticket_1000");
            sScac.setImporteTotal(123);
            sScac.setEstadoTicket(EstadoTicket.VENDIDO);

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
