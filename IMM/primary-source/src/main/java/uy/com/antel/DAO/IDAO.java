package uy.com.antel.DAO;

import javax.naming.NamingException;
import java.util.List;


import uy.com.antel.mysql.DAOException;

import javax.naming.NamingException;
import java.util.List;


//T clase del sistema
// K el tipo de datos de la clave primaria

    public interface IDAO <T,K> {
        void insertar (T a) throws DAOException, NamingException;
        void modificar (T a) throws DAOException;
        void eliminar (T a) throws DAOException;
        List<T> obtenerTodos() throws DAOException;
        T obtener(K id) throws DAOException, NamingException;

    }


