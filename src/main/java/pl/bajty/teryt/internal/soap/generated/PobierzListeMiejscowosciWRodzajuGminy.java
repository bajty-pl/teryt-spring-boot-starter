
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
 *         &lt;element name="symbolWoj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="symbolPow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="symbolGmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="symbolRodz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "symbolWoj",
    "symbolPow",
    "symbolGmi",
    "symbolRodz",
    "dataStanu"
})
@XmlRootElement(name = "PobierzListeMiejscowosciWRodzajuGminy")
public class PobierzListeMiejscowosciWRodzajuGminy {

    @XmlElementRef(name = "symbolWoj", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolWoj;
    @XmlElementRef(name = "symbolPow", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolPow;
    @XmlElementRef(name = "symbolGmi", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolGmi;
    @XmlElementRef(name = "symbolRodz", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolRodz;
    @XmlElement(name = "DataStanu")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataStanu;

    /**
     * Gets the value of the symbolWoj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolWoj() {
        return symbolWoj;
    }

    /**
     * Sets the value of the symbolWoj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolWoj(JAXBElement<String> value) {
        this.symbolWoj = value;
    }

    /**
     * Gets the value of the symbolPow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolPow() {
        return symbolPow;
    }

    /**
     * Sets the value of the symbolPow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolPow(JAXBElement<String> value) {
        this.symbolPow = value;
    }

    /**
     * Gets the value of the symbolGmi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolGmi() {
        return symbolGmi;
    }

    /**
     * Sets the value of the symbolGmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolGmi(JAXBElement<String> value) {
        this.symbolGmi = value;
    }

    /**
     * Gets the value of the symbolRodz property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolRodz() {
        return symbolRodz;
    }

    /**
     * Sets the value of the symbolRodz property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolRodz(JAXBElement<String> value) {
        this.symbolRodz = value;
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
