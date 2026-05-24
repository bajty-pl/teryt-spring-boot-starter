
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
 *         &lt;element name="WeryfikujAdresDlaMiejscowosciAdresowyResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfZweryfikowanyAdresBezUlic" minOccurs="0"/>
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
    "weryfikujAdresDlaMiejscowosciAdresowyResult"
})
@XmlRootElement(name = "WeryfikujAdresDlaMiejscowosciAdresowyResponse")
public class WeryfikujAdresDlaMiejscowosciAdresowyResponse {

    @XmlElementRef(name = "WeryfikujAdresDlaMiejscowosciAdresowyResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfZweryfikowanyAdresBezUlic> weryfikujAdresDlaMiejscowosciAdresowyResult;

    /**
     * Gets the value of the weryfikujAdresDlaMiejscowosciAdresowyResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfZweryfikowanyAdresBezUlic }{@code >}
     *     
     */
    public JAXBElement<ArrayOfZweryfikowanyAdresBezUlic> getWeryfikujAdresDlaMiejscowosciAdresowyResult() {
        return weryfikujAdresDlaMiejscowosciAdresowyResult;
    }

    /**
     * Sets the value of the weryfikujAdresDlaMiejscowosciAdresowyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfZweryfikowanyAdresBezUlic }{@code >}
     *     
     */
    public void setWeryfikujAdresDlaMiejscowosciAdresowyResult(JAXBElement<ArrayOfZweryfikowanyAdresBezUlic> value) {
        this.weryfikujAdresDlaMiejscowosciAdresowyResult = value;
    }

}
