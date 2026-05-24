
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RMiejscowosciWiejskie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RMiejscowosciWiejskie"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="integralneInne" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="integralneOgolem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="integralnePrzysiolki" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="integralneWsie" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nazwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="podstawoweInne" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="podstawoweOgolem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="podstawoweWsie" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="woj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RMiejscowosciWiejskie", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "integralneInne",
    "integralneOgolem",
    "integralnePrzysiolki",
    "integralneWsie",
    "nazwa",
    "podstawoweInne",
    "podstawoweOgolem",
    "podstawoweWsie",
    "woj"
})
public class RMiejscowosciWiejskie {

    protected Integer integralneInne;
    protected Integer integralneOgolem;
    protected Integer integralnePrzysiolki;
    protected Integer integralneWsie;
    @XmlElementRef(name = "nazwa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa;
    protected Integer podstawoweInne;
    protected Integer podstawoweOgolem;
    protected Integer podstawoweWsie;
    @XmlElementRef(name = "woj", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> woj;

    /**
     * Gets the value of the integralneInne property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntegralneInne() {
        return integralneInne;
    }

    /**
     * Sets the value of the integralneInne property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntegralneInne(Integer value) {
        this.integralneInne = value;
    }

    /**
     * Gets the value of the integralneOgolem property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntegralneOgolem() {
        return integralneOgolem;
    }

    /**
     * Sets the value of the integralneOgolem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntegralneOgolem(Integer value) {
        this.integralneOgolem = value;
    }

    /**
     * Gets the value of the integralnePrzysiolki property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntegralnePrzysiolki() {
        return integralnePrzysiolki;
    }

    /**
     * Sets the value of the integralnePrzysiolki property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntegralnePrzysiolki(Integer value) {
        this.integralnePrzysiolki = value;
    }

    /**
     * Gets the value of the integralneWsie property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntegralneWsie() {
        return integralneWsie;
    }

    /**
     * Sets the value of the integralneWsie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntegralneWsie(Integer value) {
        this.integralneWsie = value;
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
     * Gets the value of the podstawoweInne property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPodstawoweInne() {
        return podstawoweInne;
    }

    /**
     * Sets the value of the podstawoweInne property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPodstawoweInne(Integer value) {
        this.podstawoweInne = value;
    }

    /**
     * Gets the value of the podstawoweOgolem property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPodstawoweOgolem() {
        return podstawoweOgolem;
    }

    /**
     * Sets the value of the podstawoweOgolem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPodstawoweOgolem(Integer value) {
        this.podstawoweOgolem = value;
    }

    /**
     * Gets the value of the podstawoweWsie property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPodstawoweWsie() {
        return podstawoweWsie;
    }

    /**
     * Sets the value of the podstawoweWsie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPodstawoweWsie(Integer value) {
        this.podstawoweWsie = value;
    }

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

}
