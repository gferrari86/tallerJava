package uy.com.antel.DAO;

import uy.com.antel.mysql.TicketDaoMysqlScac;

import javax.naming.NamingException;

public interface IDAOManagerScac {

    TicketDaoMysqlScac getTicketMysqlDAO() throws NamingException;

}