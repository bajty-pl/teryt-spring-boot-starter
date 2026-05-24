
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="CzyZalogowanyResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "czyZalogowanyResult"
})
@XmlRootElement(name = "CzyZalogowanyResponse")
public class CzyZalogowanyResponse {

    @XmlElement(name = "CzyZalogowanyResult")
    protected Boolean czyZalogowanyResult;

    /**
     * Gets the value of the czyZalogowanyResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCzyZalogowanyResult() {
        return czyZalogowanyResult;
    }

    /**
     * Sets the value of the czyZalogowanyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCzyZalogowanyResult(Boolean value) {
        this.czyZalogowanyResult = value;
    }

}
