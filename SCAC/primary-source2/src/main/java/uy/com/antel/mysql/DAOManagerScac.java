

package uy.com.antel.mysql;


        import uy.com.antel.DAO.IDAOManagerScac;

        import javax.naming.NamingException;
        import javax.naming.Context;
        import javax.naming.InitialContext;
        import javax.sql.DataSource;

public class DAOManagerScac implements IDAOManagerScac {

    private TicketDaoMysqlScac ticketDao=null;
    private UsuariosTerminalesSCAC usuarioDao=null;
    private Context contexto;
    private DataSource ds;

    public DAOManagerScac() throws NamingException {
        this.contexto = new InitialContext();
        this.ds = (DataSource) contexto.lookup("java:jboss/datasources/DBSCAC");
    }

    public TicketDaoMysqlScac getTicketMysqlDAO() throws NamingException {
        if (ticketDao==null){
            ticketDao=new TicketDaoMysqlScac(ds);
        }
        return ticketDao;
    }

    public UsuariosTerminalesSCAC getUsuarioTMysqlDAO() throws NamingException {
        if (usuarioDao==null){
            usuarioDao=new UsuariosTerminalesSCAC(ds);
        }
        return usuarioDao;
    }


}