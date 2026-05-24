
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
 *         &lt;element name="PobierzZmianySimcAdresowyResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}PlikZmiany" minOccurs="0"/>
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
    "pobierzZmianySimcAdresowyResult"
})
@XmlRootElement(name = "PobierzZmianySimcAdresowyResponse")
public class PobierzZmianySimcAdresowyResponse {

    @XmlElementRef(name = "PobierzZmianySimcAdresowyResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PlikZmiany> pobierzZmianySimcAdresowyResult;

    /**
     * Gets the value of the pobierzZmianySimcAdresowyResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PlikZmiany }{@code >}
     *     
     */
    public JAXBElement<PlikZmiany> getPobierzZmianySimcAdresowyResult() {
        return pobierzZmianySimcAdresowyResult;
    }

    /**
     * Sets the value of the pobierzZmianySimcAdresowyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PlikZmiany }{@code >}
     *     
     */
    public void setPobierzZmianySimcAdresowyResult(JAXBElement<PlikZmiany> value) {
        this.pobierzZmianySimcAdresowyResult = value;
    }

}
