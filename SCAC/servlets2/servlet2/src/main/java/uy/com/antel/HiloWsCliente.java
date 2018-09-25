package uy.com.antel;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HiloWsCliente implements Runnable {

    public void run() {

        try {
            URL url = new URL("http://localhost:8080/servlet/sv?wsdl");
            QName qname = new QName("http://antel.com.uy/", "ImmWsImpService");

            Service service = Service.create(url, qname);
            ImmWsImp converter = service.getPort(ImmWsImp.class);
            System.out.println(converter.sayHello("Nombre"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //URL url = new URL("http://localhost:8080/servlet/sv?wsdl");

    }

}
