
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identyfikatory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identyfikatory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="simc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identyfikatory", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "simc",
    "terc"
})
public class Identyfikatory {

    @XmlElementRef(name = "simc", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> simc;
    @XmlElementRef(name = "terc", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> terc;

    /**
     * Gets the value of the simc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSimc() {
        return simc;
    }

    /**
     * Sets the value of the simc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSimc(JAXBElement<String> value) {
        this.simc = value;
    }

    /**
     * Gets the value of the terc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTerc() {
        return terc;
    }

    /**
     * Sets the value of the terc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTerc(JAXBElement<String> value) {
        this.terc = value;
    }

}
