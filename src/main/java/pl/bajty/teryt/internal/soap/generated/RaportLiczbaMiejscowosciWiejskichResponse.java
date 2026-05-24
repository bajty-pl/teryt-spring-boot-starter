
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
 *         &lt;element name="RaportLiczbaMiejscowosciWiejskichResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfRMiejscowosciWiejskie" minOccurs="0"/>
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
    "raportLiczbaMiejscowosciWiejskichResult"
})
@XmlRootElement(name = "RaportLiczbaMiejscowosciWiejskichResponse")
public class RaportLiczbaMiejscowosciWiejskichResponse {

    @XmlElementRef(name = "RaportLiczbaMiejscowosciWiejskichResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRMiejscowosciWiejskie> raportLiczbaMiejscowosciWiejskichResult;

    /**
     * Gets the value of the raportLiczbaMiejscowosciWiejskichResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRMiejscowosciWiejskie }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRMiejscowosciWiejskie> getRaportLiczbaMiejscowosciWiejskichResult() {
        return raportLiczbaMiejscowosciWiejskichResult;
    }

    /**
     * Sets the value of the raportLiczbaMiejscowosciWiejskichResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRMiejscowosciWiejskie }{@code >}
     *     
     */
    public void setRaportLiczbaMiejscowosciWiejskichResult(JAXBElement<ArrayOfRMiejscowosciWiejskie> value) {
        this.raportLiczbaMiejscowosciWiejskichResult = value;
    }

}
