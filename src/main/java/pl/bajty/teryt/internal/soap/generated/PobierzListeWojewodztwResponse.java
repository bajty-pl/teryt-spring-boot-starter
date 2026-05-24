
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
 *         &lt;element name="PobierzListeWojewodztwResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfJednostkaTerytorialna" minOccurs="0"/>
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
    "pobierzListeWojewodztwResult"
})
@XmlRootElement(name = "PobierzListeWojewodztwResponse")
public class PobierzListeWojewodztwResponse {

    @XmlElementRef(name = "PobierzListeWojewodztwResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfJednostkaTerytorialna> pobierzListeWojewodztwResult;

    /**
     * Gets the value of the pobierzListeWojewodztwResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfJednostkaTerytorialna }{@code >}
     *     
     */
    public JAXBElement<ArrayOfJednostkaTerytorialna> getPobierzListeWojewodztwResult() {
        return pobierzListeWojewodztwResult;
    }

    /**
     * Sets the value of the pobierzListeWojewodztwResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfJednostkaTerytorialna }{@code >}
     *     
     */
    public void setPobierzListeWojewodztwResult(JAXBElement<ArrayOfJednostkaTerytorialna> value) {
        this.pobierzListeWojewodztwResult = value;
    }

}
