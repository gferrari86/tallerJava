
package uy.com.antel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uy.com.antel package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHello_QNAME = new QName("http://antel.com.uy/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://antel.com.uy/", "sayHelloResponse");
    private final static QName _GetSolicitud_QNAME = new QName("http://antel.com.uy/", "getSolicitud");
    private final static QName _GetSolicitudResponse_QNAME = new QName("http://antel.com.uy/", "getSolicitudResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uy.com.antel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link GetSolicitud }
     * 
     */
    public GetSolicitud createGetSolicitud() {
        return new GetSolicitud();
    }

    /**
     * Create an instance of {@link GetSolicitudResponse }
     * 
     */
    public GetSolicitudResponse createGetSolicitudResponse() {
        return new GetSolicitudResponse();
    }

    /**
     * Create an instance of {@link SolicitudIMM }
     * 
     */
    public SolicitudIMM createSolicitudIMM() {
        return new SolicitudIMM();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://antel.com.uy/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://antel.com.uy/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSolicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://antel.com.uy/", name = "getSolicitud")
    public JAXBElement<GetSolicitud> createGetSolicitud(GetSolicitud value) {
        return new JAXBElement<GetSolicitud>(_GetSolicitud_QNAME, GetSolicitud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSolicitudResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://antel.com.uy/", name = "getSolicitudResponse")
    public JAXBElement<GetSolicitudResponse> createGetSolicitudResponse(GetSolicitudResponse value) {
        return new JAXBElement<GetSolicitudResponse>(_GetSolicitudResponse_QNAME, GetSolicitudResponse.class, null, value);
    }

}
