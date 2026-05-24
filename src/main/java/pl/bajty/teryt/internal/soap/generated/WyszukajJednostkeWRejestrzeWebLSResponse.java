
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WyszukajJednostkeWRejestrzeWebLSResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfJednostkaPodzialuTerytorialnego" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wyszukajJednostkeWRejestrzeWebLSResult"
})
@XmlRootElement(name = "WyszukajJednostkeWRejestrzeWebLSResponse")
public class WyszukajJednostkeWRejestrzeWebLSResponse {

    @XmlElementRef(name = "WyszukajJednostkeWRejestrzeWebLSResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfJednostkaPodzialuTerytorialnego> wyszukajJednostkeWRejestrzeWebLSResult;

    /**
     * Gets the value of the wyszukajJednostkeWRejestrzeWebLSResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfJednostkaPodzialuTerytorialnego }{@code >}
     *     
     */
    public JAXBElement<ArrayOfJednostkaPodzialuTerytorialnego> getWyszukajJednostkeWRejestrzeWebLSResult() {
        return wyszukajJednostkeWRejestrzeWebLSResult;
    }

    /**
     * Sets the value of the wyszukajJednostkeWRejestrzeWebLSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfJednostkaPodzialuTerytorialnego }{@code >}
     *     
     */
    public void setWyszukajJednostkeWRejestrzeWebLSResult(JAXBElement<ArrayOfJednostkaPodzialuTerytorialnego> value) {
        this.wyszukajJednostkeWRejestrzeWebLSResult = value;
    }

}
