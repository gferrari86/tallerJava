package uy.com.antel;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class galeatorio {

    public static void main(String args[]) throws NamingException, SQLException, ParseException {

        SecureRandom random = new SecureRandom();
        String text = new BigInteger(64, random).toString(16);
        System.out.println("imm" + text);

        String url = "jdbc:mysql://127.0.0.1:3306/DBSCAC";
        String user = "Editor";
        String pass = "EditorPass";
        System.out.println("Conectando...");
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Conectado!!");
            String INSERT = "INSERT INTO TTicketScac (NumeroTicketSCAC,TipoSolicitud,Matricula,FechaInicioEstacionamiento,FechaHoraVenta,CantidadMinutos,IdTerminal,EstadoTicket,Monto,CodigoAnulacion,UserIdVenta,UserIdAnulacion,NumeroTicketImm) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            String Fecha = "12/03/2018:18:15";

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm");
            Date fechaInicioEstacionamiento = sdf.parse(Fecha);

            Date date = new Date();
            //Date fechaVenta=sdf.parse(String.valueOf(date));


            PreparedStatement orden = null;
            //Connection ps = null;
            try {

                orden = connection.prepareStatement(INSERT);
                orden.setString(1, ("scac" + text));
                orden.setString(2, "venta");
                orden.setString(3, "sbe223332");
                orden.setObject(4, fechaInicioEstacionamiento);
                orden.setObject(5, date);
                orden.setInt(6, 60);
                orden.setString(7, "Abitab");
                orden.setString(8, "vendido");
                orden.setFloat(9, 122);
                orden.setString(10, ("nc"));
                orden.setString(11,"1");
                orden.setString(12,"1");
                orden.setString(13,"imm"+text);

                try {
                    orden.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } catch (Exception m) {
            }

        }


    }
}