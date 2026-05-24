
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nazwaMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identyfikatorMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nazwaMiejscowosci",
    "identyfikatorMiejscowosci"
})
@XmlRootElement(name = "WyszukajMiejscowosc")
public class WyszukajMiejscowosc {

    @XmlElementRef(name = "nazwaMiejscowosci", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaMiejscowosci;
    @XmlElementRef(name = "identyfikatorMiejscowosci", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identyfikatorMiejscowosci;

    /**
     * Gets the value of the nazwaMiejscowosci property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaMiejscowosci() {
        return nazwaMiejscowosci;
    }

    /**
     * Sets the value of the nazwaMiejscowosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaMiejscowosci(JAXBElement<String> value) {
        this.nazwaMiejscowosci = value;
    }

    /**
     * Gets the value of the identyfikatorMiejscowosci property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentyfikatorMiejscowosci() {
        return identyfikatorMiejscowosci;
    }

    /**
     * Sets the value of the identyfikatorMiejscowosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentyfikatorMiejscowosci(JAXBElement<String> value) {
        this.identyfikatorMiejscowosci = value;
    }

}
