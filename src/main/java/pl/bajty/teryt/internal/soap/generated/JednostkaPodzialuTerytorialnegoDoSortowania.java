
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JednostkaPodzialuTerytorialnegoDoSortowania complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JednostkaPodzialuTerytorialnegoDoSortowania"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NazwaDodatkowaWyszukana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NazwaGminy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NazwaPowiat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NazwaWojewodztwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NazwaWyszukana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RodzajGminy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortGminy" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SortPowiat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SymbolGminy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SymbolPowiat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SymbolWojewodztwa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SymbolWyszukana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JednostkaPodzialuTerytorialnegoDoSortowania", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "nazwaDodatkowaWyszukana",
    "nazwaGminy",
    "nazwaPowiat",
    "nazwaWojewodztwa",
    "nazwaWyszukana",
    "rodzajGminy",
    "sortGminy",
    "sortPowiat",
    "symbolGminy",
    "symbolPowiat",
    "symbolWojewodztwa",
    "symbolWyszukana"
})
public class JednostkaPodzialuTerytorialnegoDoSortowania {

    @XmlElementRef(name = "NazwaDodatkowaWyszukana", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaDodatkowaWyszukana;
    @XmlElementRef(name = "NazwaGminy", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaGminy;
    @XmlElementRef(name = "NazwaPowiat", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaPowiat;
    @XmlElementRef(name = "NazwaWojewodztwa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaWojewodztwa;
    @XmlElementRef(name = "NazwaWyszukana", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazwaWyszukana;
    @XmlElementRef(name = "RodzajGminy", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rodzajGminy;
    @XmlElement(name = "SortGminy")
    protected Integer sortGminy;
    @XmlElement(name = "SortPowiat")
    protected Integer sortPowiat;
    @XmlElementRef(name = "SymbolGminy", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolGminy;
    @XmlElementRef(name = "SymbolPowiat", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolPowiat;
    @XmlElementRef(name = "SymbolWojewodztwa", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolWojewodztwa;
    @XmlElementRef(name = "SymbolWyszukana", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolWyszukana;

    /**
     * Gets the value of the nazwaDodatkowaWyszukana property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaDodatkowaWyszukana() {
        return nazwaDodatkowaWyszukana;
    }

    /**
     * Sets the value of the nazwaDodatkowaWyszukana property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaDodatkowaWyszukana(JAXBElement<String> value) {
        this.nazwaDodatkowaWyszukana = value;
    }

    /**
     * Gets the value of the nazwaGminy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaGminy() {
        return nazwaGminy;
    }

    /**
     * Sets the value of the nazwaGminy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaGminy(JAXBElement<String> value) {
        this.nazwaGminy = value;
    }

    /**
     * Gets the value of the nazwaPowiat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaPowiat() {
        return nazwaPowiat;
    }

    /**
     * Sets the value of the nazwaPowiat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaPowiat(JAXBElement<String> value) {
        this.nazwaPowiat = value;
    }

    /**
     * Gets the value of the nazwaWojewodztwa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaWojewodztwa() {
        return nazwaWojewodztwa;
    }

    /**
     * Sets the value of the nazwaWojewodztwa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaWojewodztwa(JAXBElement<String> value) {
        this.nazwaWojewodztwa = value;
    }

    /**
     * Gets the value of the nazwaWyszukana property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazwaWyszukana() {
        return nazwaWyszukana;
    }

    /**
     * Sets the value of the nazwaWyszukana property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazwaWyszukana(JAXBElement<String> value) {
        this.nazwaWyszukana = value;
    }

    /**
     * Gets the value of the rodzajGminy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRodzajGminy() {
        return rodzajGminy;
    }

    /**
     * Sets the value of the rodzajGminy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRodzajGminy(JAXBElement<String> value) {
        this.rodzajGminy = value;
    }

    /**
     * Gets the value of the sortGminy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSortGminy() {
        return sortGminy;
    }

    /**
     * Sets the value of the sortGminy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSortGminy(Integer value) {
        this.sortGminy = value;
    }

    /**
     * Gets the value of the sortPowiat property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSortPowiat() {
        return sortPowiat;
    }

    /**
     * Sets the value of the sortPowiat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSortPowiat(Integer value) {
        this.sortPowiat = value;
    }

    /**
     * Gets the value of the symbolGminy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolGminy() {
        return symbolGminy;
    }

    /**
     * Sets the value of the symbolGminy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolGminy(JAXBElement<String> value) {
        this.symbolGminy = value;
    }

    /**
     * Gets the value of the symbolPowiat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolPowiat() {
        return symbolPowiat;
    }

    /**
     * Sets the value of the symbolPowiat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolPowiat(JAXBElement<String> value) {
        this.symbolPowiat = value;
    }

    /**
     * Gets the value of the symbolWojewodztwa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolWojewodztwa() {
        return symbolWojewodztwa;
    }

    /**
     * Sets the value of the symbolWojewodztwa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolWojewodztwa(JAXBElement<String> value) {
        this.symbolWojewodztwa = value;
    }

    /**
     * Gets the value of the symbolWyszukana property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolWyszukana() {
        return symbolWyszukana;
    }

    /**
     * Sets the value of the symbolWyszukana property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolWyszukana(JAXBElement<String> value) {
        this.symbolWyszukana = value;
    }

}
