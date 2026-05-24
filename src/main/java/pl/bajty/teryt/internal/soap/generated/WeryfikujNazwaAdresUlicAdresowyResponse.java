
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
 *         &lt;element name="WeryfikujNazwaAdresUlicAdresowyResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfZweryfikowanyAdres" minOccurs="0"/&gt;
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
    "weryfikujNazwaAdresUlicAdresowyResult"
})
@XmlRootElement(name = "WeryfikujNazwaAdresUlicAdresowyResponse")
public class WeryfikujNazwaAdresUlicAdresowyResponse {

    @XmlElementRef(name = "WeryfikujNazwaAdresUlicAdresowyResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfZweryfikowanyAdres> weryfikujNazwaAdresUlicAdresowyResult;

    /**
     * Gets the value of the weryfikujNazwaAdresUlicAdresowyResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfZweryfikowanyAdres }{@code >}
     *     
     */
    public JAXBElement<ArrayOfZweryfikowanyAdres> getWeryfikujNazwaAdresUlicAdresowyResult() {
        return weryfikujNazwaAdresUlicAdresowyResult;
    }

    /**
     * Sets the value of the weryfikujNazwaAdresUlicAdresowyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfZweryfikowanyAdres }{@code >}
     *     
     */
    public void setWeryfikujNazwaAdresUlicAdresowyResult(JAXBElement<ArrayOfZweryfikowanyAdres> value) {
        this.weryfikujNazwaAdresUlicAdresowyResult = value;
    }

}
