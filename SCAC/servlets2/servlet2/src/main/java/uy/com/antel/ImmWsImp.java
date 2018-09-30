
package uy.com.antel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ImmWsImp", targetNamespace = "http://antel.com.uy/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ImmWsImp {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://antel.com.uy/", className = "uy.com.antel.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://antel.com.uy/", className = "uy.com.antel.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns uy.com.antel.SolicitudIMM
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSolicitud", targetNamespace = "http://antel.com.uy/", className = "uy.com.antel.GetSolicitud")
    @ResponseWrapper(localName = "getSolicitudResponse", targetNamespace = "http://antel.com.uy/", className = "uy.com.antel.GetSolicitudResponse")
    public SolicitudIMM getSolicitud(
        @WebParam(name = "arg0", targetNamespace = "")
        SolicitudIMM arg0);

}
