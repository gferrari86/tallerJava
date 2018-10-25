package uy.com.antel.mysql;

import uy.com.antel.DAO.IUsuariosTerminalesSCAC;
import uy.com.antel.pojo.TicketSCAC;
import uy.com.antel.pojo.UsuarioTerminal;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuariosTerminalesSCAC implements IUsuariosTerminalesSCAC {

    final String GETONE = "SELECT * FROM TUsuarios WHERE Usuario= ?";

    DataSource ds;


    public UsuariosTerminalesSCAC(DataSource ds) {
        this.ds = (DataSource) ds;

    }

    private UsuarioTerminal SQLtoUsuarioTerminal(ResultSet rs) throws SQLException {
        UsuarioTerminal u = new UsuarioTerminal();
        int id = rs.getInt("UserId");
        String usuario = rs.getString("Usuario");
        String pass = rs.getString("Pass");

        u.setUserid(id);
        u.setUser(usuario);
        u.setPass(pass);

        return u;


    }

    public void insertar(UsuarioTerminal a) throws DAOException, NamingException {

    }

    public void modificar(UsuarioTerminal a) throws DAOException {

    }

    public void eliminar(UsuarioTerminal a) throws DAOException {

    }

    public List<UsuarioTerminal> obtenerTodos() throws DAOException {
        return null;
    }

    public UsuarioTerminal obtener(String id) throws DAOException, NamingException {
        PreparedStatement orden = null;
        ResultSet rs = null;
        UsuarioTerminal e = null;
        Connection ps;
        try {
            ps = ds.getConnection();
            orden = ps.prepareStatement(GETONE);
            orden.setString(1, id);
            rs = orden.executeQuery();
            if (rs.next()) {
                e = SQLtoUsuarioTerminal(rs);
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
