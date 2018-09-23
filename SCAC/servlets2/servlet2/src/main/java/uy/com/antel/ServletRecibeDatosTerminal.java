package uy.com.antel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletRecibeDatosTerminal extends HttpServlet {

    @Override
    public void init() throws ServletException {

        System.out.println("Inicia ServletRecibeDatosTerminal");
        Thread t = new Thread(new HiloRecibeDatosTerminal());
        t.start();

        super.init();
    }
}
