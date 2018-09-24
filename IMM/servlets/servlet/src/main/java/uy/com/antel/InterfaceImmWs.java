package uy.com.antel;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface InterfaceImmWs {

    @WebMethod
    String sayHello(String name);

}
