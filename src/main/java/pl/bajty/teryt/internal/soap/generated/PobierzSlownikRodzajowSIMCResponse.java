
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
 *         &lt;element name="PobierzSlownikRodzajowSIMCResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfRodzajMiejscowosci" minOccurs="0"/>
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
