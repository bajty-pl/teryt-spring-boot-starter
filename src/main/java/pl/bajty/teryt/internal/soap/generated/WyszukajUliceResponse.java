
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="WyszukajUliceResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfUlica" minOccurs="0"/&gt;
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
    "wyszukajUliceResult"
})
@XmlRootElement(name = "WyszukajUliceResponse")
public class WyszukajUliceResponse {

    @XmlElementRef(name = "WyszukajUliceResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfUlica> wyszukajUliceResult;

    /**
     * Gets the value of the wyszukajUliceResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUlica }{@code >}
     *     
     */
    public JAXBElement<ArrayOfUlica> getWyszukajUliceResult() {
        return wyszukajUliceResult;
    }

    /**
     * Sets the value of the wyszukajUliceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUlica }{@code >}
     *     
     */
    public void setWyszukajUliceResult(JAXBElement<ArrayOfUlica> value) {
        this.wyszukajUliceResult = value;
    }

}
