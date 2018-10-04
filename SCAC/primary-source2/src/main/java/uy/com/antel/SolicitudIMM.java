
package uy.com.antel;

import uy.com.antel.pojo.EstadoTicket;
import uy.com.antel.pojo.TipoSolicitud;

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
 *         &lt;element name="codigoAnulacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoTicket" type="{http://antel.com.uy/}estadoTicket" minOccurs="0"/>
 *         &lt;element name="fechaHoraAnulacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaHoraVenta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaInicioEstacionamiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="importeTotal" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="matriculaVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroTicket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "codigoAnulacion",
    "estadoTicket",
    "fechaHoraAnulacion",
    "fechaHoraVenta",
    "fechaInicioEstacionamiento",
    "importeTotal",
    "matriculaVehiculo",
    "numeroTicket",
    "tipoSolicitud"
})
public class SolicitudIMM {

    protected int cantidadMinutos;
    protected String codigoAnulacion;
    @XmlSchemaType(name = "string")
    protected EstadoTicket estadoTicket;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraAnulacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraVenta;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioEstacionamiento;
    protected float importeTotal;
    protected String matriculaVehiculo;
    protected String numeroTicket;
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
     * Obtiene el valor de la propiedad codigoAnulacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAnulacion() {
        return codigoAnulacion;
    }

    /**
     * Define el valor de la propiedad codigoAnulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAnulacion(String value) {
        this.codigoAnulacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoTicket.
     * 
     * @return
     *     possible object is
     *     {@link EstadoTicket }
     *     
     */
    public EstadoTicket getEstadoTicket() {
        return estadoTicket;
    }

    /**
     * Define el valor de la propiedad estadoTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoTicket }
     *     
     */
    public void setEstadoTicket(EstadoTicket value) {
        this.estadoTicket = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraAnulacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraAnulacion() {
        return fechaHoraAnulacion;
    }

    /**
     * Define el valor de la propiedad fechaHoraAnulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraAnulacion(XMLGregorianCalendar value) {
        this.fechaHoraAnulacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraVenta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    /**
     * Define el valor de la propiedad fechaHoraVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraVenta(XMLGregorianCalendar value) {
        this.fechaHoraVenta = value;
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
     * Obtiene el valor de la propiedad importeTotal.
     * 
     */
    public float getImporteTotal() {
        return importeTotal;
    }

    /**
     * Define el valor de la propiedad importeTotal.
     * 
     */
    public void setImporteTotal(float value) {
        this.importeTotal = value;
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
     * Obtiene el valor de la propiedad numeroTicket.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTicket() {
        return numeroTicket;
    }

    /**
     * Define el valor de la propiedad numeroTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTicket(String value) {
        this.numeroTicket = value;
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
