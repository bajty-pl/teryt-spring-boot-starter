
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
 *         &lt;element name="WyszukajUliceWebLSResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfWyszukanaUlicaZPodstawowa" minOccurs="0"/>
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
