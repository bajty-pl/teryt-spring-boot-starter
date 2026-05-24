
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PunktAdresowy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PunktAdresowy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentyfikatorTERC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NazwaMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RodzajMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentyfikatorSIMC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NazwaPelnaUlic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RodzajObiektu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nazwa1Ulic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nazwa2Ulic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentyfikatorULIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumerPorzadkowy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataNadania" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Wspolrzedne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PoczatekWersjiObiektu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KoniecWersjiObiektu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PunktAdresowy", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "identyfikatorTERC",
    "nazwaMiejscowosci",
    "rodzajMiejscowosci",
    "identyfikatorSIMC",
    "nazwaPelnaUlic",
    "rodzajObiektu",
    "nazwa1Ulic",
    "nazwa2Ulic",
    "identyfikatorULIC",
    "numerPorzadkowy",
    "dataNadania",
    "wspolrzedne",
    "iIp",
    "poczatekWersjiObiektu",
    "koniecWersjiObiektu"
})
public class PunktAdresowy {

    @XmlElement(name = "IdentyfikatorTERC", required = true, nillable = true)
    protected String identyfikatorTERC;
    @XmlElement(name = "NazwaMiejscowosci", required = true, nillable = true)
    protected String nazwaMiejscowosci;
    @XmlElementRef(name = "RodzajMiejscowosci", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rodzajMiejscowosci;
    @XmlElement(name = "IdentyfikatorSIMC", required = true, nillable = true)
    protected String identyfikatorSIMC;
    @XmlElementRef(name = "NazwaPelnaUlic", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaPelnaUlic;
    @XmlElement(name = "RodzajObiektu", required = true, nillable = true)
    protected String rodzajObiektu;
    @XmlElementRef(name = "Nazwa1Ulic", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa1Ulic;
    @XmlElementRef(name = "Nazwa2Ulic", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa2Ulic;
    @XmlElementRef(name = "IdentyfikatorULIC", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identyfikatorULIC;
    @XmlElement(name = "NumerPorzadkowy", required = true, nillable = true)
    protected String numerPorzadkowy;
    @XmlElementRef(name = "DataNadania", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataNadania;
    @XmlElementRef(name = "Wspolrzedne", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wspolrzedne;
    @XmlElementRef(name = "IIp", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> iIp;
    @XmlElement(name = "PoczatekWersjiObiektu", required = true, nillable = true)
    protected String poczatekWersjiObiektu;
    @XmlElementRef(name = "KoniecWersjiObiektu", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> koniecWersjiObiektu;

    /**
     * Gets the value of the identyfikatorTERC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentyfikatorTERC() {
        return identyfikatorTERC;
    }

    /**
     * Sets the value of the identyfikatorTERC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentyfikatorTERC(String value) {
        this.identyfikatorTERC = value;
    }

    /**
     * Gets the value of the nazwaMiejscowosci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazwaMiejscowosci() {
        return nazwaMiejscowosci;
    }

    /**
     * Sets the value of the nazwaMiejscowosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazwaMiejscowosci(String value) {
        this.nazwaMiejscowosci = value;
    }

    /**
     * Gets the value of the rodzajMiejscowosci property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRodzajMiejscowosci() {
        return rodzajMiejscowosci;
    }

    /**
     * Sets the value of the rodzajMiejscowosci property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRodzajMiejscowosci(JAXBElement<String> value) {
        this.rodzajMiejscowosci = value;
    }

    /**
     * Gets the value of the identyfikatorSIMC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentyfikatorSIMC() {
        return identyfikatorSIMC;
    }

    /**
     * Sets the value of the identyfikatorSIMC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentyfikatorSIMC(String value) {
        this.identyfikatorSIMC = value;
    }

    /**
     * Gets the value of the nazwaPelnaUlic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaPelnaUlic() {
        return nazwaPelnaUlic;
    }

    /**
     * Sets the value of the nazwaPelnaUlic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaPelnaUlic(JAXBElement<String> value) {
        this.nazwaPelnaUlic = value;
    }

    /**
     * Gets the value of the rodzajObiektu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRodzajObiektu() {
        return rodzajObiektu;
    }

    /**
     * Sets the value of the rodzajObiektu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRodzajObiektu(String value) {
        this.rodzajObiektu = value;
    }

    /**
     * Gets the value of the nazwa1Ulic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwa1Ulic() {
        return nazwa1Ulic;
    }

    /**
     * Sets the value of the nazwa1Ulic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwa1Ulic(JAXBElement<String> value) {
        this.nazwa1Ulic = value;
    }

    /**
     * Gets the value of the nazwa2Ulic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwa2Ulic() {
        return nazwa2Ulic;
    }

    /**
     * Sets the value of the nazwa2Ulic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwa2Ulic(JAXBElement<String> value) {
        this.nazwa2Ulic = value;
    }

    /**
     * Gets the value of the identyfikatorULIC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentyfikatorULIC() {
        return identyfikatorULIC;
    }

    /**
     * Sets the value of the identyfikatorULIC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentyfikatorULIC(JAXBElement<String> value) {
        this.identyfikatorULIC = value;
    }

    /**
     * Gets the value of the numerPorzadkowy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerPorzadkowy() {
        return numerPorzadkowy;
    }

    /**
     * Sets the value of the numerPorzadkowy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerPorzadkowy(String value) {
        this.numerPorzadkowy = value;
    }

    /**
     * Gets the value of the dataNadania property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataNadania() {
        return dataNadania;
    }

    /**
     * Sets the value of the dataNadania property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataNadania(JAXBElement<String> value) {
        this.dataNadania = value;
    }

    /**
     * Gets the value of the wspolrzedne property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWspolrzedne() {
        return wspolrzedne;
    }

    /**
     * Sets the value of the wspolrzedne property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWspolrzedne(JAXBElement<String> value) {
        this.wspolrzedne = value;
    }

    /**
     * Gets the value of the iIp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIIp() {
        return iIp;
    }

    /**
     * Sets the value of the iIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIIp(JAXBElement<String> value) {
        this.iIp = value;
    }

    /**
     * Gets the value of the poczatekWersjiObiektu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoczatekWersjiObiektu() {
        return poczatekWersjiObiektu;
    }

    /**
     * Sets the value of the poczatekWersjiObiektu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoczatekWersjiObiektu(String value) {
        this.poczatekWersjiObiektu = value;
    }

    /**
     * Gets the value of the koniecWersjiObiektu property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKoniecWersjiObiektu() {
        return koniecWersjiObiektu;
    }

    /**
     * Sets the value of the koniecWersjiObiektu property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKoniecWersjiObiektu(JAXBElement<String> value) {
        this.koniecWersjiObiektu = value;
    }

}
