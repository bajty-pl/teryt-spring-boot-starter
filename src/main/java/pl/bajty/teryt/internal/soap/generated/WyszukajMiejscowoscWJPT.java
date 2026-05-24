
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="nazwaWoj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nazwaPow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nazwaGmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nazwaMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identyfikatorMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "nazwaWoj",
    "nazwaPow",
    "nazwaGmi",
    "nazwaMiejscowosci",
    "identyfikatorMiejscowosci"
})
@XmlRootElement(name = "WyszukajMiejscowoscWJPT")
public class WyszukajMiejscowoscWJPT {

    @XmlElementRef(name = "nazwaWoj", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaWoj;
    @XmlElementRef(name = "nazwaPow", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaPow;
    @XmlElementRef(name = "nazwaGmi", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaGmi;
    @XmlElementRef(name = "nazwaMiejscowosci", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaMiejscowosci;
    @XmlElementRef(name = "identyfikatorMiejscowosci", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identyfikatorMiejscowosci;

    /**
     * Gets the value of the nazwaWoj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaWoj() {
        return nazwaWoj;
    }

    /**
     * Sets the value of the nazwaWoj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaWoj(JAXBElement<String> value) {
        this.nazwaWoj = value;
    }

    /**
     * Gets the value of the nazwaPow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaPow() {
        return nazwaPow;
    }

    /**
     * Sets the value of the nazwaPow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaPow(JAXBElement<String> value) {
        this.nazwaPow = value;
    }

    /**
     * Gets the value of the nazwaGmi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaGmi() {
        return nazwaGmi;
    }

    /**
     * Sets the value of the nazwaGmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaGmi(JAXBElement<String> value) {
        this.nazwaGmi = value;
    }

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
