package uy.com.antel;


import javax.jws.WebService;

@WebService
public class ImmWsImp implements InterfaceImmWs {

    public String sayHello(String name) {
        return "Hello " + name;
    }

}
