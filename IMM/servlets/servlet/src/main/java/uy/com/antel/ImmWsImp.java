package uy.com.antel;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ImmWsImp {

    @WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
