package uy.com.antel.mysql;

import uy.com.antel.DAO.ITicketDAO;
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
    final String GETONE = "SELECT Nombre FROM TEditoriales WHERE EditorialId = ?";
    //SELECT Nombre FROM Editorial.TEditoriales where Nombre='Edit1';
    final String GETTHIS = "SELECT Nombre FROM TEditoriales WHERE Nombre= ?";
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
        t.setTipoSolicitud(tipoSolicitud);

        String matricula = rs.getString("Matricula");
        t.setMatriculaVehiculo(matricula);

        String fechaInicioEstacionamiento = rs.getString("FechaInicioEstacionamiento");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM");
        Date fechaHora=null;
        try {
            fechaHora=sdf.parse(fechaInicioEstacionamiento);
            t.setFechaInicioEstacionamiento(fechaHora);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String fechaVenta = rs.getString("FechaHoraVenta");
        fechaHora=null;
        try {
            fechaHora=sdf.parse(fechaVenta);
            t.setFechaHoraVenta(fechaHora);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer cminutos=rs.getInt("CantidadMinutos");
        t.setCantidadMinutos(cminutos);

        String agencia=rs.getString("Agencia");
        t.setAgencia(agencia);



        return null;
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

        return null;
    }
}
