//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.14 at 11:20:17 AM IST 
//


package springwebservice.example.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hai" type="{http://com.example.springwebservice}hai"/>
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
    "hai"
})
@XmlRootElement(name = "addHaiRequest")
public class AddHaiRequest {

    @XmlElement(required = true)
    protected Hai hai;

    /**
     * Gets the value of the hai property.
     * 
     * @return
     *     possible object is
     *     {@link Hai }
     *     
     */
    public Hai getHai() {
        return hai;
    }

    /**
     * Sets the value of the hai property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hai }
     *     
     */
    public void setHai(Hai value) {
        this.hai = value;
    }

}
