
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
 *         &lt;element name="WyszukajMiejscowoscWebLSResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfWyszukanaMiejscowoscZPodstawowa" minOccurs="0"/>
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
    "wyszukajMiejscowoscWebLSResult"
})
@XmlRootElement(name = "WyszukajMiejscowoscWebLSResponse")
public class WyszukajMiejscowoscWebLSResponse {

    @XmlElementRef(name = "WyszukajMiejscowoscWebLSResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWyszukanaMiejscowoscZPodstawowa> wyszukajMiejscowoscWebLSResult;

    /**
     * Gets the value of the wyszukajMiejscowoscWebLSResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWyszukanaMiejscowoscZPodstawowa }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWyszukanaMiejscowoscZPodstawowa> getWyszukajMiejscowoscWebLSResult() {
        return wyszukajMiejscowoscWebLSResult;
    }

    /**
     * Sets the value of the wyszukajMiejscowoscWebLSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWyszukanaMiejscowoscZPodstawowa }{@code >}
     *     
     */
    public void setWyszukajMiejscowoscWebLSResult(JAXBElement<ArrayOfWyszukanaMiejscowoscZPodstawowa> value) {
        this.wyszukajMiejscowoscWebLSResult = value;
    }

}
