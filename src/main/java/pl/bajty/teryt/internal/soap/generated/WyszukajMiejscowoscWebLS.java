
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
 *         &lt;element name="nazwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rodzajMiejscowosci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="symbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idents" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfidentyfikatory" minOccurs="0"/&gt;
 *         &lt;element name="czyPelnaNazwa" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="czyFragmentNazwy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="zawezenieRekordow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="odKtoregoRekordu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="iloscRekordow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
    "nazwa",
    "rodzajMiejscowosci",
    "symbol",
    "idents",
    "czyPelnaNazwa",
    "czyFragmentNazwy",
    "zawezenieRekordow",
    "odKtoregoRekordu",
    "iloscRekordow",
    "dataStanu"
})
@XmlRootElement(name = "WyszukajMiejscowoscWebLS")
public class WyszukajMiejscowoscWebLS {

    @XmlElementRef(name = "nazwa", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa;
    @XmlElementRef(name = "rodzajMiejscowosci", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rodzajMiejscowosci;
    @XmlElementRef(name = "symbol", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbol;
    @XmlElementRef(name = "idents", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfidentyfikatory> idents;
    protected Boolean czyPelnaNazwa;
    protected Boolean czyFragmentNazwy;
    protected Boolean zawezenieRekordow;
    protected Integer odKtoregoRekordu;
    protected Integer iloscRekordow;
    @XmlElement(name = "DataStanu")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataStanu;

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

    /**
     * Gets the value of the idents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfidentyfikatory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfidentyfikatory> getIdents() {
        return idents;
    }

    /**
     * Sets the value of the idents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfidentyfikatory }{@code >}
     *     
     */
    public void setIdents(JAXBElement<ArrayOfidentyfikatory> value) {
        this.idents = value;
    }

    /**
     * Gets the value of the czyPelnaNazwa property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCzyPelnaNazwa() {
        return czyPelnaNazwa;
    }

    /**
     * Sets the value of the czyPelnaNazwa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCzyPelnaNazwa(Boolean value) {
        this.czyPelnaNazwa = value;
    }

    /**
     * Gets the value of the czyFragmentNazwy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCzyFragmentNazwy() {
        return czyFragmentNazwy;
    }

    /**
     * Sets the value of the czyFragmentNazwy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCzyFragmentNazwy(Boolean value) {
        this.czyFragmentNazwy = value;
    }

    /**
     * Gets the value of the zawezenieRekordow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZawezenieRekordow() {
        return zawezenieRekordow;
    }

    /**
     * Sets the value of the zawezenieRekordow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZawezenieRekordow(Boolean value) {
        this.zawezenieRekordow = value;
    }

    /**
     * Gets the value of the odKtoregoRekordu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOdKtoregoRekordu() {
        return odKtoregoRekordu;
    }

    /**
     * Sets the value of the odKtoregoRekordu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOdKtoregoRekordu(Integer value) {
        this.odKtoregoRekordu = value;
    }

    /**
     * Gets the value of the iloscRekordow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIloscRekordow() {
        return iloscRekordow;
    }

    /**
     * Sets the value of the iloscRekordow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIloscRekordow(Integer value) {
        this.iloscRekordow = value;
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
