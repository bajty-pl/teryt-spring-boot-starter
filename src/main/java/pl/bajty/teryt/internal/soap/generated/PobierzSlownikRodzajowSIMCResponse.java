
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
 *         &lt;element name="PobierzSlownikRodzajowSIMCResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfRodzajMiejscowosci" minOccurs="0"/&gt;
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
    "pobierzSlownikRodzajowSIMCResult"
})
@XmlRootElement(name = "PobierzSlownikRodzajowSIMCResponse")
public class PobierzSlownikRodzajowSIMCResponse {

    @XmlElementRef(name = "PobierzSlownikRodzajowSIMCResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRodzajMiejscowosci> pobierzSlownikRodzajowSIMCResult;

    /**
     * Gets the value of the pobierzSlownikRodzajowSIMCResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRodzajMiejscowosci }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRodzajMiejscowosci> getPobierzSlownikRodzajowSIMCResult() {
        return pobierzSlownikRodzajowSIMCResult;
    }

    /**
     * Sets the value of the pobierzSlownikRodzajowSIMCResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRodzajMiejscowosci }{@code >}
     *     
     */
    public void setPobierzSlownikRodzajowSIMCResult(JAXBElement<ArrayOfRodzajMiejscowosci> value) {
        this.pobierzSlownikRodzajowSIMCResult = value;
    }

}
