
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
 *         &lt;element name="WeryfikujNazwaAdresUlicResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfZweryfikowanyAdres" minOccurs="0"/>
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
    "weryfikujNazwaAdresUlicResult"
})
@XmlRootElement(name = "WeryfikujNazwaAdresUlicResponse")
public class WeryfikujNazwaAdresUlicResponse {

    @XmlElementRef(name = "WeryfikujNazwaAdresUlicResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfZweryfikowanyAdres> weryfikujNazwaAdresUlicResult;

    /**
     * Gets the value of the weryfikujNazwaAdresUlicResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfZweryfikowanyAdres }{@code >}
     *     
     */
    public JAXBElement<ArrayOfZweryfikowanyAdres> getWeryfikujNazwaAdresUlicResult() {
        return weryfikujNazwaAdresUlicResult;
    }

    /**
     * Sets the value of the weryfikujNazwaAdresUlicResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfZweryfikowanyAdres }{@code >}
     *     
     */
    public void setWeryfikujNazwaAdresUlicResult(JAXBElement<ArrayOfZweryfikowanyAdres> value) {
        this.weryfikujNazwaAdresUlicResult = value;
    }

}
