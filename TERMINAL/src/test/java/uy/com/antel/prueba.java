package uy.com.antel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class prueba {

    public static void main(String args[]) throws ParseException {

        String Fecha="12/03/2018:18:15";

        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy:HH:mm");
        Date fechaInicioEstacionamiento = sdf.parse(Fecha);
        Calendar cal =new GregorianCalendar();
        cal.setTime(fechaInicioEstacionamiento);
        System.out.println("estacionamiento  "+cal.getTime());

        Calendar c= Calendar.getInstance();

        //Date fechaVenta=sdf.format(c.getTime());
        //System.out.println("ahora "+fechaVenta);
    }
}
