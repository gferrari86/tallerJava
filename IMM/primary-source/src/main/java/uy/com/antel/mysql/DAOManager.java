package uy.com.antel.mysql;

import uy.com.antel.DAO.IDAOManager;
import uy.com.antel.pojo.SolicitudIMM;

import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DAOManager implements IDAOManager {

    private TicketMysqlDAO ticketDao=null;
    private Context contexto;
    private DataSource ds;

    public DAOManager() throws NamingException {
        this.contexto = new InitialContext();
        this.ds = (DataSource) contexto.lookup("java:jboss/datasources/DBIMM");
    }

    public TicketMysqlDAO getTicketMyslDAO() throws NamingException {
        if (ticketDao==null){
            ticketDao=new TicketMysqlDAO(ds);
        }
        return ticketDao;
    }


}
