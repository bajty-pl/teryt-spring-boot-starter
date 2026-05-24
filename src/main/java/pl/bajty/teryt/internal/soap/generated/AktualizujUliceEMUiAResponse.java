
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
 *         &lt;element name="AktualizujUliceEMUiAResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}OdpowiedzTeryt" minOccurs="0"/>
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
    "aktualizujUliceEMUiAResult"
})
@XmlRootElement(name = "AktualizujUliceEMUiAResponse")
public class AktualizujUliceEMUiAResponse {

    @XmlElementRef(name = "AktualizujUliceEMUiAResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<OdpowiedzTeryt> aktualizujUliceEMUiAResult;

    /**
     * Gets the value of the aktualizujUliceEMUiAResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OdpowiedzTeryt }{@code >}
     *     
     */
    public JAXBElement<OdpowiedzTeryt> getAktualizujUliceEMUiAResult() {
        return aktualizujUliceEMUiAResult;
    }

    /**
     * Sets the value of the aktualizujUliceEMUiAResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OdpowiedzTeryt }{@code >}
     *     
     */
    public void setAktualizujUliceEMUiAResult(JAXBElement<OdpowiedzTeryt> value) {
        this.aktualizujUliceEMUiAResult = value;
    }

}
