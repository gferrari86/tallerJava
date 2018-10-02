
package uy.com.antel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoTicket.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoTicket">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VENDIDO"/>
 *     &lt;enumeration value="ANULADO"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadoTicket")
@XmlEnum
public enum EstadoTicket {

    VENDIDO,
    ANULADO,
    ERROR;

    public String value() {
        return name();
    }

    public static EstadoTicket fromValue(String v) {
        return valueOf(v);
    }

}
