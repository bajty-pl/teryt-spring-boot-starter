
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RLiczbaJednostkiTerc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RLiczbaJednostkiTerc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="delegatury" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dzielnice" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="gminy" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="gminyMW" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="gminyMiejskie" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="gminyWiejskie" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="miasta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="miastaGMW" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nazwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="powiaty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="powiatyMiasta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="symbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RLiczbaJednostkiTerc", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "delegatury",
    "dzielnice",
    "gminy",
    "gminyMW",
    "gminyMiejskie",
    "gminyWiejskie",
    "miasta",
    "miastaGMW",
    "nazwa",
    "powiaty",
    "powiatyMiasta",
    "symbol"
})
public class RLiczbaJednostkiTerc {

    protected Integer delegatury;
    protected Integer dzielnice;
    protected Integer gminy;
    protected Integer gminyMW;
    protected Integer gminyMiejskie;
    protected Integer gminyWiejskie;
    protected Integer miasta;
    protected Integer miastaGMW;
    @XmlElementRef(name = "nazwa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa;
    protected Integer powiaty;
    protected Integer powiatyMiasta;
    @XmlElementRef(name = "symbol", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbol;

    /**
     * Gets the value of the delegatury property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDelegatury() {
        return delegatury;
    }

    /**
     * Sets the value of the delegatury property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDelegatury(Integer value) {
        this.delegatury = value;
    }

    /**
     * Gets the value of the dzielnice property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDzielnice() {
        return dzielnice;
    }

    /**
     * Sets the value of the dzielnice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDzielnice(Integer value) {
        this.dzielnice = value;
    }

    /**
     * Gets the value of the gminy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGminy() {
        return gminy;
    }

    /**
     * Sets the value of the gminy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGminy(Integer value) {
        this.gminy = value;
    }

    /**
     * Gets the value of the gminyMW property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGminyMW() {
        return gminyMW;
    }

    /**
     * Sets the value of the gminyMW property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGminyMW(Integer value) {
        this.gminyMW = value;
    }

    /**
     * Gets the value of the gminyMiejskie property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGminyMiejskie() {
        return gminyMiejskie;
    }

    /**
     * Sets the value of the gminyMiejskie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGminyMiejskie(Integer value) {
        this.gminyMiejskie = value;
    }

    /**
     * Gets the value of the gminyWiejskie property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGminyWiejskie() {
        return gminyWiejskie;
    }

    /**
     * Sets the value of the gminyWiejskie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGminyWiejskie(Integer value) {
        this.gminyWiejskie = value;
    }

    /**
     * Gets the value of the miasta property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMiasta() {
        return miasta;
    }

    /**
     * Sets the value of the miasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMiasta(Integer value) {
        this.miasta = value;
    }

    /**
     * Gets the value of the miastaGMW property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMiastaGMW() {
        return miastaGMW;
    }

    /**
     * Sets the value of the miastaGMW property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMiastaGMW(Integer value) {
        this.miastaGMW = value;
    }

    /**
     * Gets the value of the nazwa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwa() {
        return nazwa;
    }

    /**
     * Sets the value of the nazwa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwa(JAXBElement<String> value) {
        this.nazwa = value;
    }

    /**
     * Gets the value of the powiaty property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowiaty() {
        return powiaty;
    }

    /**
     * Sets the value of the powiaty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowiaty(Integer value) {
        this.powiaty = value;
    }

    /**
     * Gets the value of the powiatyMiasta property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowiatyMiasta() {
        return powiatyMiasta;
    }

    /**
     * Sets the value of the powiatyMiasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowiatyMiasta(Integer value) {
        this.powiatyMiasta = value;
    }

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbol(JAXBElement<String> value) {
        this.symbol = value;
    }

}
