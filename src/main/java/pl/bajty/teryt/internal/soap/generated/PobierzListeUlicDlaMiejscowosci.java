
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="woj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rodzaj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="msc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="czyWersjaUrzedowa" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="czyWersjaAdresowa" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="DataStanu" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
    "woj",
    "pow",
    "gmi",
    "rodzaj",
    "msc",
    "czyWersjaUrzedowa",
    "czyWersjaAdresowa",
    "dataStanu"
})
@XmlRootElement(name = "PobierzListeUlicDlaMiejscowosci")
public class PobierzListeUlicDlaMiejscowosci {

    @XmlElementRef(name = "woj", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> woj;
    @XmlElementRef(name = "pow", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pow;
    @XmlElementRef(name = "gmi", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gmi;
    @XmlElementRef(name = "rodzaj", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rodzaj;
    @XmlElementRef(name = "msc", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> msc;
    protected Boolean czyWersjaUrzedowa;
    protected Boolean czyWersjaAdresowa;
    @XmlElement(name = "DataStanu")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataStanu;

    /**
     * Gets the value of the woj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWoj() {
        return woj;
    }

    /**
     * Sets the value of the woj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWoj(JAXBElement<String> value) {
        this.woj = value;
    }

    /**
     * Gets the value of the pow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPow() {
        return pow;
    }

    /**
     * Sets the value of the pow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPow(JAXBElement<String> value) {
        this.pow = value;
    }

    /**
     * Gets the value of the gmi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGmi() {
        return gmi;
    }

    /**
     * Sets the value of the gmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGmi(JAXBElement<String> value) {
        this.gmi = value;
    }

    /**
     * Gets the value of the rodzaj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRodzaj() {
        return rodzaj;
    }

    /**
     * Sets the value of the rodzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRodzaj(JAXBElement<String> value) {
        this.rodzaj = value;
    }

    /**
     * Gets the value of the msc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMsc() {
        return msc;
    }

    /**
     * Sets the value of the msc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMsc(JAXBElement<String> value) {
        this.msc = value;
    }

    /**
     * Gets the value of the czyWersjaUrzedowa property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCzyWersjaUrzedowa() {
        return czyWersjaUrzedowa;
    }

    /**
     * Sets the value of the czyWersjaUrzedowa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCzyWersjaUrzedowa(Boolean value) {
        this.czyWersjaUrzedowa = value;
    }

    /**
     * Gets the value of the czyWersjaAdresowa property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCzyWersjaAdresowa() {
        return czyWersjaAdresowa;
    }

    /**
     * Sets the value of the czyWersjaAdresowa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCzyWersjaAdresowa(Boolean value) {
        this.czyWersjaAdresowa = value;
    }

    /**
     * Gets the value of the dataStanu property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataStanu() {
        return dataStanu;
    }

    /**
     * Sets the value of the dataStanu property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataStanu(XMLGregorianCalendar value) {
        this.dataStanu = value;
    }

}
