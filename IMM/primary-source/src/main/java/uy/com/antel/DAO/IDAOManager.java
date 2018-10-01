package uy.com.antel.DAO;

import uy.com.antel.mysql.TicketMysqlDAO;

import javax.naming.NamingException;

public interface IDAOManager {
    TicketMysqlDAO getTicketMyslDAO() throws NamingException;

}
