
package serviciosweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para exportarReceta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="exportarReceta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreFichero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreReceta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportarReceta", propOrder = {
    "nombreFichero",
    "nombreReceta"
})
public class ExportarReceta {

    protected String nombreFichero;
    protected String nombreReceta;

    /**
     * Obtiene el valor de la propiedad nombreFichero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFichero() {
        return nombreFichero;
    }

    /**
     * Define el valor de la propiedad nombreFichero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFichero(String value) {
        this.nombreFichero = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreReceta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreReceta() {
        return nombreReceta;
    }

    /**
     * Define el valor de la propiedad nombreReceta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreReceta(String value) {
        this.nombreReceta = value;
    }

}
