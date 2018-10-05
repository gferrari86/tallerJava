package uy.com.antel.mysql;

import uy.com.antel.DAO.ITicketDAO;
import uy.com.antel.EstadoTicket;
import uy.com.antel.pojo.TicketSCAC;
import uy.com.antel.TipoSolicitud;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class TicketDaoMysqlScac implements ITicketDAO {
    //Primer recibe pedido
    final String INSERT = "INSERT INTO TTicketImm (NumeroTicketSCAC,TipoSolicitud,Matricula,FechaInicioEstacionamiento,FechaHoraVenta,CantidadMinutos,IdTerminal,EstadoTicket,Monto) values (?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE TEditoriales SET Nombre = ? WHERE EditorialId = ?";
    final String DELETE = "DELETE FROM TEditoriales where EditorialId = ?";
    final String GETALL = "SELECT EditorialId, Nombre FROM TEditoriales";
    final String GETONE = "SELECT Nombre FROM TTicketImm WHERE  NumeroTicketImm = ?";
    //SELECT Nombre FROM Editorial.TEditoriales where Nombre='Edit1';
    final String GETTHISID = "SELECT EditorialId FROM TEditoriales WHERE Nombre= ?";

    DataSource ds;

    private String TZ="GMT-3:00";
    private TimeZone timezone= TimeZone.getTimeZone(TZ);

    public TicketDaoMysqlScac(DataSource ds) {
        this.ds = (DataSource) ds;

    }

    //Introduzco el metodo para pasar el xmlGregorianCalendar a Date parar guardar en base

    public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar, TimeZone zone) {
        TimeZone.setDefault(zone);
        return new Date(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
    }

    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date, TimeZone zone) {
        XMLGregorianCalendar xmlGregorianCalendar = null;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.setTimeZone(zone);
        try {
            DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
            xmlGregorianCalendar = dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        }
        catch (Exception e) {
            System.out.println("Date 2 XMLGregorianCalendar" + e);
        }

        return xmlGregorianCalendar;
    }

    private TicketSCAC convertirTicket(ResultSet rs) throws SQLException {
        TicketSCAC t= new TicketSCAC();

        String numeroTicket = rs.getString("NumeroTicketImm");
        t.setNumeroTicket(numeroTicket);

        String tipoSolicitud = rs.getString("TipoSolicitud");
        TipoSolicitud m=TipoSolicitud.valueOf(tipoSolicitud);
        t.setTipoSolicitud(m);

        String matricula = rs.getString("Matricula");
        t.setMatriculaVehiculo(matricula);

        Date fechaInicioEstacionamiento = rs.getDate("FechaInicioEstacionamiento");
        XMLGregorianCalendar XMLGregCalFIE=dateToXMLGregorianCalendar(fechaInicioEstacionamiento,timezone);
        t.setFechaInicioEstacionamiento(XMLGregCalFIE);


        Date fechaVenta = rs.getDate("FechaHoraVenta");
        XMLGregorianCalendar XMLGregCalFV=dateToXMLGregorianCalendar(fechaVenta,timezone);
        t.setFechaHoraVenta(XMLGregCalFV);

        Integer cminutos=rs.getInt("CantidadMinutos");
        t.setCantidadMinutos(cminutos);

        String idTerminal=rs.getString("idTerminal");
        t.setIdTerminalAgencia(idTerminal);

        String estadoticket=rs.getString("EstadoTicket");

        EstadoTicket mm= EstadoTicket.valueOf(estadoticket);
        t.setEstadoTicket(mm);

        Float monto=rs.getFloat("Monto");
        t.setImporteTotal(monto);

        Integer uid=rs.getInt("UserIdVenta");

        return t;
    }


    public void insertar(TicketSCAC a) throws DAOException, NamingException {
        PreparedStatement orden = null;
        Connection ps = null;
        try {
            ps = ds.getConnection();
            orden = ps.prepareStatement(INSERT);
            orden.setString(1, (String) a.getNumeroTicket());
            orden.setString(2, a.getTipoSolicitud().toString());
            orden.setString(3,a.getMatriculaVehiculo());

            //pasar xmlgregoriancalendar >> date.java.util >> date.sql.date
            Date dateFIE=xmlGregorianCalendarToDate(a.getFechaInicioEstacionamiento(), TimeZone.getTimeZone("GMT-3:00"));
            java.sql.Date sqlDateFIE = new java.sql.Date(dateFIE.getTime());
            orden.setDate(4, sqlDateFIE);

            Date dateFHV=xmlGregorianCalendarToDate(a.getFechaHoraVenta(), TimeZone.getTimeZone("GMT-3:00"));
            java.sql.Date sqlDateFHV = new java.sql.Date(dateFHV.getTime());
            orden.setDate(5,sqlDateFHV);

            orden.setInt(6,a.getCantidadMinutos());
            orden.setString(7,a.getIdTerminalAgencia());
            orden.setString(8,a.getEstadoTicket().toString());
            orden.setFloat(9,a.getImporteTotal());
            orden.execute();

            if (orden.executeUpdate() == 0) {
                throw new DAOException("no se guardo dato " );
            }
            ;

        } catch (SQLException ex) {
            throw new DAOException("error sql", ex);
        } finally {
            if (orden != null) {
                try {
                    orden.close();
                } catch (SQLException ex) {
                    throw new DAOException("error cierre", ex);
                }
            }


        }

    }

    public void modificar(TicketSCAC a) throws DAOException {

    }

    public void eliminar(TicketSCAC a) throws DAOException {

    }

    public List<TicketSCAC> obtenerTodos() throws DAOException {
        return null;
    }

    public TicketSCAC obtener(String numeroticket) throws DAOException, NamingException {
        PreparedStatement orden = null;
        ResultSet rs = null;
        TicketSCAC e = null;
        Connection ps;
        try {
            ps = ds.getConnection();
            orden = ps.prepareStatement(GETONE);
            orden.setString(1, numeroticket);
            rs = orden.executeQuery();
            if (rs.next()) {
                e = convertirTicket(rs);
            } else {
                throw new DAOException("No se ha encontrado registro: " + numeroticket);
            }
        } catch (SQLException ex) {
            throw new DAOException("No se conecto", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL", ex);
                }
                if (orden != null) {
                    try {
                        orden.close();
                    } catch (SQLException ex) {
                        throw new DAOException("Error SQL", ex);
                    }
                }
            }

            return e;
        }
    }


}
