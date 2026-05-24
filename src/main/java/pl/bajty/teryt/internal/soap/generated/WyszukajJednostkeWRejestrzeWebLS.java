
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
 *         &lt;element name="identyfiks" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfidentyfikatory" minOccurs="0"/&gt;
 *         &lt;element name="kategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "identyfiks",
    "kategoria",
    "zawezenieRekordow",
    "odKtoregoRekordu",
    "iloscRekordow",
    "dataStanu"
})
@XmlRootElement(name = "WyszukajJednostkeWRejestrzeWebLS")
public class WyszukajJednostkeWRejestrzeWebLS {

    @XmlElementRef(name = "nazwa", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwa;
    @XmlElementRef(name = "identyfiks", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfidentyfikatory> identyfiks;
    @XmlElementRef(name = "kategoria", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> kategoria;
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
     * Gets the value of the identyfiks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfidentyfikatory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfidentyfikatory> getIdentyfiks() {
        return identyfiks;
    }

    /**
     * Sets the value of the identyfiks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfidentyfikatory }{@code >}
     *     
     */
    public void setIdentyfiks(JAXBElement<ArrayOfidentyfikatory> value) {
        this.identyfiks = value;
    }

    /**
     * Gets the value of the kategoria property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKategoria() {
        return kategoria;
    }

    /**
     * Sets the value of the kategoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKategoria(JAXBElement<String> value) {
        this.kategoria = value;
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
