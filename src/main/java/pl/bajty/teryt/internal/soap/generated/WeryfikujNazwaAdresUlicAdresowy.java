
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
 *         &lt;element name="nazwaWoj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nazwaPow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nazwaGmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nazwaMiejscowosc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rodzajMiejsc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nazwaUlicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "nazwaWoj",
    "nazwaPow",
    "nazwaGmi",
    "nazwaMiejscowosc",
    "rodzajMiejsc",
    "nazwaUlicy"
})
@XmlRootElement(name = "WeryfikujNazwaAdresUlicAdresowy")
public class WeryfikujNazwaAdresUlicAdresowy {

    @XmlElementRef(name = "nazwaWoj", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaWoj;
    @XmlElementRef(name = "nazwaPow", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaPow;
    @XmlElementRef(name = "nazwaGmi", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaGmi;
    @XmlElementRef(name = "nazwaMiejscowosc", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaMiejscowosc;
    @XmlElementRef(name = "rodzajMiejsc", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rodzajMiejsc;
    @XmlElementRef(name = "nazwaUlicy", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaUlicy;

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
     * Gets the value of the nazwaMiejscowosc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaMiejscowosc() {
        return nazwaMiejscowosc;
    }

    /**
     * Sets the value of the nazwaMiejscowosc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaMiejscowosc(JAXBElement<String> value) {
        this.nazwaMiejscowosc = value;
    }

    /**
     * Gets the value of the rodzajMiejsc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRodzajMiejsc() {
        return rodzajMiejsc;
    }

    /**
     * Sets the value of the rodzajMiejsc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRodzajMiejsc(JAXBElement<String> value) {
        this.rodzajMiejsc = value;
    }

    /**
     * Gets the value of the nazwaUlicy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaUlicy() {
        return nazwaUlicy;
    }

    /**
     * Sets the value of the nazwaUlicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaUlicy(JAXBElement<String> value) {
        this.nazwaUlicy = value;
    }

}
