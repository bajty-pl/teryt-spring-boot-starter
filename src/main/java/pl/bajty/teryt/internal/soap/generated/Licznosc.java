
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Licznosc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Licznosc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LiczbaGmin" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="LiczbaMiejscowosci" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="LiczbaPowiatow" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="LiczbaUlic" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="Wojewodztwa" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Licznosc", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "liczbaGmin",
    "liczbaMiejscowosci",
    "liczbaPowiatow",
    "liczbaUlic",
    "wojewodztwa"
})
public class Licznosc {

    @XmlElementRef(name = "LiczbaGmin", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> liczbaGmin;
    @XmlElementRef(name = "LiczbaMiejscowosci", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> liczbaMiejscowosci;
    @XmlElementRef(name = "LiczbaPowiatow", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> liczbaPowiatow;
    @XmlElementRef(name = "LiczbaUlic", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> liczbaUlic;
    @XmlElementRef(name = "Wojewodztwa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> wojewodztwa;

    /**
     * Gets the value of the liczbaGmin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getLiczbaGmin() {
        return liczbaGmin;
    }

    /**
     * Sets the value of the liczbaGmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setLiczbaGmin(JAXBElement<ArrayOfint> value) {
        this.liczbaGmin = value;
    }

    /**
     * Gets the value of the liczbaMiejscowosci property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getLiczbaMiejscowosci() {
        return liczbaMiejscowosci;
    }

    /**
     * Sets the value of the liczbaMiejscowosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setLiczbaMiejscowosci(JAXBElement<ArrayOfint> value) {
        this.liczbaMiejscowosci = value;
    }

    /**
     * Gets the value of the liczbaPowiatow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getLiczbaPowiatow() {
        return liczbaPowiatow;
    }

    /**
     * Sets the value of the liczbaPowiatow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setLiczbaPowiatow(JAXBElement<ArrayOfint> value) {
        this.liczbaPowiatow = value;
    }

    /**
     * Gets the value of the liczbaUlic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getLiczbaUlic() {
        return liczbaUlic;
    }

    /**
     * Sets the value of the liczbaUlic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setLiczbaUlic(JAXBElement<ArrayOfint> value) {
        this.liczbaUlic = value;
    }

    /**
     * Gets the value of the wojewodztwa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getWojewodztwa() {
        return wojewodztwa;
    }

    /**
     * Sets the value of the wojewodztwa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setWojewodztwa(JAXBElement<ArrayOfstring> value) {
        this.wojewodztwa = value;
    }

}
