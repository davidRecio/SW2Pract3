
package serviciosweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para addReceta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="addReceta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="receta" type="{http://serviciosWeb/}receta" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addReceta", propOrder = {
    "receta"
})
public class AddReceta {

    protected Receta receta;

    /**
     * Obtiene el valor de la propiedad receta.
     * 
     * @return
     *     possible object is
     *     {@link Receta }
     *     
     */
    public Receta getReceta() {
        return receta;
    }

    /**
     * Define el valor de la propiedad receta.
     * 
     * @param value
     *     allowed object is
     *     {@link Receta }
     *     
     */
    public void setReceta(Receta value) {
        this.receta = value;
    }

}
