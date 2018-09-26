
package uy.com.antel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para solicitudIMM complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudIMM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidadMinutos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaInicioEstacionamiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="matriculaVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroTicketAnulacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoSolicitud" type="{http://antel.com.uy/}tipoSolicitud" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudIMM", propOrder = {
    "cantidadMinutos",
    "fechaInicioEstacionamiento",
    "matriculaVehiculo",
    "numeroTicketAnulacion",
    "tipoSolicitud"
})
public class SolicitudIMM {

    protected int cantidadMinutos;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioEstacionamiento;
    protected String matriculaVehiculo;
    protected String numeroTicketAnulacion;
    @XmlSchemaType(name = "string")
    protected TipoSolicitud tipoSolicitud;

    /**
     * Obtiene el valor de la propiedad cantidadMinutos.
     * 
     */
    public int getCantidadMinutos() {
        return cantidadMinutos;
    }

    /**
     * Define el valor de la propiedad cantidadMinutos.
     * 
     */
    public void setCantidadMinutos(int value) {
        this.cantidadMinutos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicioEstacionamiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioEstacionamiento() {
        return fechaInicioEstacionamiento;
    }

    /**
     * Define el valor de la propiedad fechaInicioEstacionamiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioEstacionamiento(XMLGregorianCalendar value) {
        this.fechaInicioEstacionamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad matriculaVehiculo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    /**
     * Define el valor de la propiedad matriculaVehiculo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatriculaVehiculo(String value) {
        this.matriculaVehiculo = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroTicketAnulacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTicketAnulacion() {
        return numeroTicketAnulacion;
    }

    /**
     * Define el valor de la propiedad numeroTicketAnulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTicketAnulacion(String value) {
        this.numeroTicketAnulacion = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link TipoSolicitud }
     *     
     */
    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    /**
     * Define el valor de la propiedad tipoSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoSolicitud }
     *     
     */
    public void setTipoSolicitud(TipoSolicitud value) {
        this.tipoSolicitud = value;
    }

}
