
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
 *         &lt;element name="PobierzZmianyTercAdresowyResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}PlikZmiany" minOccurs="0"/&gt;
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
    "pobierzZmianyTercAdresowyResult"
})
@XmlRootElement(name = "PobierzZmianyTercAdresowyResponse")
public class PobierzZmianyTercAdresowyResponse {

    @XmlElementRef(name = "PobierzZmianyTercAdresowyResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PlikZmiany> pobierzZmianyTercAdresowyResult;

    /**
     * Gets the value of the pobierzZmianyTercAdresowyResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PlikZmiany }{@code >}
     *     
     */
    public JAXBElement<PlikZmiany> getPobierzZmianyTercAdresowyResult() {
        return pobierzZmianyTercAdresowyResult;
    }

    /**
     * Sets the value of the pobierzZmianyTercAdresowyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PlikZmiany }{@code >}
     *     
     */
    public void setPobierzZmianyTercAdresowyResult(JAXBElement<PlikZmiany> value) {
        this.pobierzZmianyTercAdresowyResult = value;
    }

}
