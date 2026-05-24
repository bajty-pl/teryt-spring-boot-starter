
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
 *         &lt;element name="WyszukajUliceWebLSResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfWyszukanaUlicaZPodstawowa" minOccurs="0"/&gt;
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
    "wyszukajUliceWebLSResult"
})
@XmlRootElement(name = "WyszukajUliceWebLSResponse")
public class WyszukajUliceWebLSResponse {

    @XmlElementRef(name = "WyszukajUliceWebLSResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWyszukanaUlicaZPodstawowa> wyszukajUliceWebLSResult;

    /**
     * Gets the value of the wyszukajUliceWebLSResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWyszukanaUlicaZPodstawowa }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWyszukanaUlicaZPodstawowa> getWyszukajUliceWebLSResult() {
        return wyszukajUliceWebLSResult;
    }

    /**
     * Sets the value of the wyszukajUliceWebLSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWyszukanaUlicaZPodstawowa }{@code >}
     *     
     */
    public void setWyszukajUliceWebLSResult(JAXBElement<ArrayOfWyszukanaUlicaZPodstawowa> value) {
        this.wyszukajUliceWebLSResult = value;
    }

}
