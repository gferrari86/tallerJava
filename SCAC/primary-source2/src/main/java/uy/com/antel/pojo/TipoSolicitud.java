
package uy.com.antel.pojo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoSolicitud.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoSolicitud">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VENTA"/>
 *     &lt;enumeration value="ANULACION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoSolicitud")
@XmlEnum
public enum TipoSolicitud {

    VENTA,
    ANULACION;

    public String value() {
        return name();
    }

    public static TipoSolicitud fromValue(String v) {
        return valueOf(v);
    }

}
