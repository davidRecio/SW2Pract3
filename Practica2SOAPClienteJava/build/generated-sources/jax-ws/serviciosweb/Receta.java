
package serviciosweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para receta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="receta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ingrediente" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ingrediente" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dificultad" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receta", propOrder = {
    "nombre",
    "ingrediente",
    "precio"
})
public class Receta {

    protected String nombre;
    protected Receta.Ingrediente ingrediente;
    protected Double precio;
    @XmlAttribute(name = "dificultad")
    protected String dificultad;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad ingrediente.
     * 
     * @return
     *     possible object is
     *     {@link Receta.Ingrediente }
     *     
     */
    public Receta.Ingrediente getIngrediente() {
        return ingrediente;
    }

    /**
     * Define el valor de la propiedad ingrediente.
     * 
     * @param value
     *     allowed object is
     *     {@link Receta.Ingrediente }
     *     
     */
    public void setIngrediente(Receta.Ingrediente value) {
        this.ingrediente = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrecio(Double value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad dificultad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * Define el valor de la propiedad dificultad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDificultad(String value) {
        this.dificultad = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ingrediente" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ingrediente"
    })
    public static class Ingrediente {

        @XmlElement(nillable = true)
        protected List<String> ingrediente;

        /**
         * Gets the value of the ingrediente property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ingrediente property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIngrediente().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIngrediente() {
            if (ingrediente == null) {
                ingrediente = new ArrayList<String>();
            }
            return this.ingrediente;
        }

    }

}
