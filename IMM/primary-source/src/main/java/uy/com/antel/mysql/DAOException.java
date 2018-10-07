package uy.com.antel.mysql;

public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
        System.out.println(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}