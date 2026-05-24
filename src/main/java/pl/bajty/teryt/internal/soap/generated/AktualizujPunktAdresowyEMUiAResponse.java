
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
 *         &lt;element name="AktualizujPunktAdresowyEMUiAResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}OdpowiedzTeryt" minOccurs="0"/>
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
    "aktualizujPunktAdresowyEMUiAResult"
})
@XmlRootElement(name = "AktualizujPunktAdresowyEMUiAResponse")
public class AktualizujPunktAdresowyEMUiAResponse {

    @XmlElementRef(name = "AktualizujPunktAdresowyEMUiAResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<OdpowiedzTeryt> aktualizujPunktAdresowyEMUiAResult;

    /**
     * Gets the value of the aktualizujPunktAdresowyEMUiAResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OdpowiedzTeryt }{@code >}
     *     
     */
    public JAXBElement<OdpowiedzTeryt> getAktualizujPunktAdresowyEMUiAResult() {
        return aktualizujPunktAdresowyEMUiAResult;
    }

    /**
     * Sets the value of the aktualizujPunktAdresowyEMUiAResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OdpowiedzTeryt }{@code >}
     *     
     */
    public void setAktualizujPunktAdresowyEMUiAResult(JAXBElement<OdpowiedzTeryt> value) {
        this.aktualizujPunktAdresowyEMUiAResult = value;
    }

}
