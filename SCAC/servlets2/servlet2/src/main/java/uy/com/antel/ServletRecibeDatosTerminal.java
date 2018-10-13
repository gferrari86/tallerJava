package uy.com.antel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet( urlPatterns = {"/MiServlet"}, loadOnStartup = 1)
public class ServletRecibeDatosTerminal extends HttpServlet {

    @Override
    public void init() throws ServletException {

        System.out.println("Inicia ServletRecibeDatosTerminal");
        Thread t = new Thread(new HiloConexionTerminal());
        t.start();

        super.init();
    }
}
