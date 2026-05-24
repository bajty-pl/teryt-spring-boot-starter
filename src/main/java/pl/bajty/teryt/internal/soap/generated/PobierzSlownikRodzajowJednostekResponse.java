
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
 *         &lt;element name="PobierzSlownikRodzajowJednostekResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
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
    "pobierzSlownikRodzajowJednostekResult"
})
@XmlRootElement(name = "PobierzSlownikRodzajowJednostekResponse")
public class PobierzSlownikRodzajowJednostekResponse {

    @XmlElementRef(name = "PobierzSlownikRodzajowJednostekResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> pobierzSlownikRodzajowJednostekResult;

    /**
     * Gets the value of the pobierzSlownikRodzajowJednostekResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getPobierzSlownikRodzajowJednostekResult() {
        return pobierzSlownikRodzajowJednostekResult;
    }

    /**
     * Sets the value of the pobierzSlownikRodzajowJednostekResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setPobierzSlownikRodzajowJednostekResult(JAXBElement<ArrayOfstring> value) {
        this.pobierzSlownikRodzajowJednostekResult = value;
    }

}
