package uy.com.antel;

import uy.com.antel.mysql.DAOException;
import uy.com.antel.mysql.DAOManager;
import uy.com.antel.pojo.SolicitudIMM;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Declaracion de clase ControladorVistaIMM

 */

public class ControladorVistaIMM {

    private static ControladorVistaIMM administraweb;

    public ControladorVistaIMM() {

    }

    public static ControladorVistaIMM getInstancia() {
        if (administraweb == null) {
            administraweb = new ControladorVistaIMM();

        }
        return administraweb;
    }

    public float calculaMontoVendido(Date fechainicio, Date fechafin) throws NamingException, DAOException {

        /* Calcula el importe de tickets vendidos entre dos fechas
        *@param fechainicio, fechafin
         */

        DAOManager consulto = new DAOManager();
        List<SolicitudIMM>lista= new ArrayList<SolicitudIMM>();
        lista=consulto.getTicketMysqlDAO().obtenerTicketsVendidos(fechainicio,fechafin);
         if (lista != null) {
             float sum = 0;
             for (SolicitudIMM e : lista) {
                 sum = e.getImporteTotal()+sum;
             }

             return sum;
         }
         else {
             return 0;
             }
        }



        }
