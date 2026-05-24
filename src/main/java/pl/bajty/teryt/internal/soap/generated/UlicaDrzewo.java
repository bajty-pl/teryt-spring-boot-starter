
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UlicaDrzewo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UlicaDrzewo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Gmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IdentyfikatorMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IdentyfikatorMiejscowosciPodstawowej" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IndeksKlucza" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Nazwa1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Nazwa2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NazwaCechy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Pow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RodzGmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StanNa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SymbolUlicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Woj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UlicaDrzewo", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "cecha",
    "gmi",
    "identyfikatorMiejscowosci",
    "identyfikatorMiejscowosciPodstawowej",
    "indeksKlucza",
    "nazwa1",
    "nazwa2",
    "nazwaCechy",
    "pow",
    "rodzGmi",
    "stanNa",
    "symbolUlicy",
    "woj"
})
public class UlicaDrzewo {

    @XmlElementRef(name = "Cecha", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cecha;
    @XmlElementRef(name = "Gmi", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gmi;
    @XmlElementRef(name = "IdentyfikatorMiejscowosci", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identyfikatorMiejscowosci;
    @XmlElementRef(name = "IdentyfikatorMiejscowosciPodstawowej", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identyfikatorMiejscowosciPodstawowej;
    @XmlElement(name = "IndeksKlucza")
    protected Integer indeksKlucza;
    @XmlElementRef(name = "Nazwa1", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa1;
    @XmlElementRef(name = "Nazwa2", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa2;
    @XmlElementRef(name = "NazwaCechy", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaCechy;
    @XmlElementRef(name = "Pow", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pow;
    @XmlElementRef(name = "RodzGmi", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rodzGmi;
    @XmlElementRef(name = "StanNa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stanNa;
    @XmlElementRef(name = "SymbolUlicy", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolUlicy;
    @XmlElementRef(name = "Woj", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> woj;

    /**
     * Gets the value of the cecha property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCecha() {
        return cecha;
    }

    /**
     * Sets the value of the cecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCecha(JAXBElement<String> value) {
        this.cecha = value;
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

    /**
     * Gets the value of the identyfikatorMiejscowosciPodstawowej property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentyfikatorMiejscowosciPodstawowej() {
        return identyfikatorMiejscowosciPodstawowej;
    }

    /**
     * Sets the value of the identyfikatorMiejscowosciPodstawowej property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentyfikatorMiejscowosciPodstawowej(JAXBElement<String> value) {
        this.identyfikatorMiejscowosciPodstawowej = value;
    }

    /**
     * Gets the value of the indeksKlucza property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIndeksKlucza() {
        return indeksKlucza;
    }

    /**
     * Sets the value of the indeksKlucza property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIndeksKlucza(Integer value) {
        this.indeksKlucza = value;
    }

    /**
     * Gets the value of the nazwa1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwa1() {
        return nazwa1;
    }

    /**
     * Sets the value of the nazwa1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwa1(JAXBElement<String> value) {
        this.nazwa1 = value;
    }

    /**
     * Gets the value of the nazwa2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwa2() {
        return nazwa2;
    }

    /**
     * Sets the value of the nazwa2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwa2(JAXBElement<String> value) {
        this.nazwa2 = value;
    }

    /**
     * Gets the value of the nazwaCechy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaCechy() {
        return nazwaCechy;
    }

    /**
     * Sets the value of the nazwaCechy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaCechy(JAXBElement<String> value) {
        this.nazwaCechy = value;
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
     * Gets the value of the rodzGmi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRodzGmi() {
        return rodzGmi;
    }

    /**
     * Sets the value of the rodzGmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRodzGmi(JAXBElement<String> value) {
        this.rodzGmi = value;
    }

    /**
     * Gets the value of the stanNa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStanNa() {
        return stanNa;
    }

    /**
     * Sets the value of the stanNa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStanNa(JAXBElement<String> value) {
        this.stanNa = value;
    }

    /**
     * Gets the value of the symbolUlicy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolUlicy() {
        return symbolUlicy;
    }

    /**
     * Sets the value of the symbolUlicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolUlicy(JAXBElement<String> value) {
        this.symbolUlicy = value;
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
