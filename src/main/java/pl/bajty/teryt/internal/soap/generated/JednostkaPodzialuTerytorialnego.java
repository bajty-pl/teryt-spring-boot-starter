
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JednostkaPodzialuTerytorialnego complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JednostkaPodzialuTerytorialnego">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GmiNazwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GmiNazwaDodatkowa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GmiRodzaj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GmiSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PowSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Powiat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WojSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Wojewodztwo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JednostkaPodzialuTerytorialnego", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "gmiNazwa",
    "gmiNazwaDodatkowa",
    "gmiRodzaj",
    "gmiSymbol",
    "powSymbol",
    "powiat",
    "wojSymbol",
    "wojewodztwo"
})
public class JednostkaPodzialuTerytorialnego {

    @XmlElementRef(name = "GmiNazwa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gmiNazwa;
    @XmlElementRef(name = "GmiNazwaDodatkowa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gmiNazwaDodatkowa;
    @XmlElementRef(name = "GmiRodzaj", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gmiRodzaj;
    @XmlElementRef(name = "GmiSymbol", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gmiSymbol;
    @XmlElementRef(name = "PowSymbol", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> powSymbol;
    @XmlElementRef(name = "Powiat", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> powiat;
    @XmlElementRef(name = "WojSymbol", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wojSymbol;
    @XmlElementRef(name = "Wojewodztwo", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wojewodztwo;

    /**
     * Gets the value of the gmiNazwa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGmiNazwa() {
        return gmiNazwa;
    }

    /**
     * Sets the value of the gmiNazwa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGmiNazwa(JAXBElement<String> value) {
        this.gmiNazwa = value;
    }

    /**
     * Gets the value of the gmiNazwaDodatkowa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGmiNazwaDodatkowa() {
        return gmiNazwaDodatkowa;
    }

    /**
     * Sets the value of the gmiNazwaDodatkowa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGmiNazwaDodatkowa(JAXBElement<String> value) {
        this.gmiNazwaDodatkowa = value;
    }

    /**
     * Gets the value of the gmiRodzaj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGmiRodzaj() {
        return gmiRodzaj;
    }

    /**
     * Sets the value of the gmiRodzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGmiRodzaj(JAXBElement<String> value) {
        this.gmiRodzaj = value;
    }

    /**
     * Gets the value of the gmiSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGmiSymbol() {
        return gmiSymbol;
    }

    /**
     * Sets the value of the gmiSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGmiSymbol(JAXBElement<String> value) {
        this.gmiSymbol = value;
    }

    /**
     * Gets the value of the powSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPowSymbol() {
        return powSymbol;
    }

    /**
     * Sets the value of the powSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPowSymbol(JAXBElement<String> value) {
        this.powSymbol = value;
    }

    /**
     * Gets the value of the powiat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPowiat() {
        return powiat;
    }

    /**
     * Sets the value of the powiat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPowiat(JAXBElement<String> value) {
        this.powiat = value;
    }

    /**
     * Gets the value of the wojSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWojSymbol() {
        return wojSymbol;
    }

    /**
     * Sets the value of the wojSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWojSymbol(JAXBElement<String> value) {
        this.wojSymbol = value;
    }

    /**
     * Gets the value of the wojewodztwo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWojewodztwo() {
        return wojewodztwo;
    }

    /**
     * Sets the value of the wojewodztwo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWojewodztwo(JAXBElement<String> value) {
        this.wojewodztwo = value;
    }

}
