package uy.com.antel.mysql;

import uy.com.antel.DAO.ITicketDAO;
import uy.com.antel.pojo.EstadoTicket;
import uy.com.antel.pojo.SolicitudIMM;
import uy.com.antel.pojo.TipoSolicitud;


import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TicketMysqlDAO implements ITicketDAO {
    final String INSERT = "INSERT INTO TTicketImm (NumeroTicketImm,TipoSolicitud,Matricula,FechaInicioEstacionamiento,FechaHoraVenta,CantidadMinutos,Agencia,EstadoTicket,Monto) values (?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE TEditoriales SET Nombre = ? WHERE EditorialId = ?";
    final String DELETE = "DELETE FROM TEditoriales where EditorialId = ?";
    final String GETALL = "SELECT EditorialId, Nombre FROM TEditoriales";
    final String GETONE = "SELECT Nombre FROM TTicketImm WHERE  NumeroTicketImm = ?";
    //SELECT Nombre FROM Editorial.TEditoriales where Nombre='Edit1';
    final String GETTHISID = "SELECT EditorialId FROM TEditoriales WHERE Nombre= ?";

    DataSource ds;


    public TicketMysqlDAO(DataSource ds) {
        this.ds = (DataSource) ds;

    }

    private SolicitudIMM convertirTicket(ResultSet rs) throws SQLException {
        SolicitudIMM t= new SolicitudIMM();

        String numeroTicket = rs.getString("NumeroTicketImm");
        t.setNumeroTicket(numeroTicket);

        String tipoSolicitud = rs.getString("TipoSolicitud");
        TipoSolicitud m=TipoSolicitud.valueOf(tipoSolicitud);
        t.setTipoSolicitud(m);

        String matricula = rs.getString("Matricula");
        t.setMatriculaVehiculo(matricula);

        Date fechaInicioEstacionamiento = rs.getDate("FechaInicioEstacionamiento");
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM");
        t.setFechaInicioEstacionamiento(fechaInicioEstacionamiento);

        Date fechaVenta = rs.getDate("FechaHoraVenta");
        t.setFechaHoraVenta(fechaVenta);


        Integer cminutos=rs.getInt("CantidadMinutos");
        t.setCantidadMinutos(cminutos);

        String agencia=rs.getString("Agencia");
        t.setAgencia(agencia);

        String estadoticket=rs.getString("EstadoTicket");
        EstadoTicket m1=EstadoTicket.valueOf(estadoticket);
        t.setEstadoTicket(m1);

        Float monto=rs.getFloat("Monto");
        t.setImporteTotal(monto);

        return t;
    }

    public void insertar(SolicitudIMM a) throws DAOException, NamingException {
        PreparedStatement orden = null;
        Connection ps = null;
        try {
            ps = ds.getConnection();
            orden = ps.prepareStatement(INSERT);
            orden.setString(1, (String) a.getNumeroTicket());
            orden.setString(2, a.getTipoSolicitud().toString());
            orden.setString(3,a.getMatriculaVehiculo());
            orden.setDate(4, (java.sql.Date) a.getFechaInicioEstacionamiento());
            orden.setDate(5,(java.sql.Date)a.getFechaHoraVenta());//YY-MM-DD hh:mm
            orden.setInt(6,a.getCantidadMinutos());
            orden.setString(7,a.getAgencia());
            orden.setString(8,a.getEstadoTicket().toString());
            orden.setFloat(9,a.getImporteTotal());

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

    public void modificar(SolicitudIMM a) throws DAOException {

    }

    public void eliminar(SolicitudIMM a) throws DAOException {

    }

    public List<SolicitudIMM> obtenerTodos() throws DAOException {
        return null;
    }

    public SolicitudIMM obtener(String numeroticket) throws DAOException, NamingException {
        PreparedStatement orden = null;
        ResultSet rs = null;
        SolicitudIMM e = null;
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
