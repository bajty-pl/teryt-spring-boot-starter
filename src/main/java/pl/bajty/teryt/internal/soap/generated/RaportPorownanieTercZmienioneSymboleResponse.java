
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
 *         &lt;element name="RaportPorownanieTercZmienioneSymboleResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfRZmianyTerc" minOccurs="0"/>
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
    "raportPorownanieTercZmienioneSymboleResult"
})
@XmlRootElement(name = "RaportPorownanieTercZmienioneSymboleResponse")
public class RaportPorownanieTercZmienioneSymboleResponse {

    @XmlElementRef(name = "RaportPorownanieTercZmienioneSymboleResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRZmianyTerc> raportPorownanieTercZmienioneSymboleResult;

    /**
     * Gets the value of the raportPorownanieTercZmienioneSymboleResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRZmianyTerc }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRZmianyTerc> getRaportPorownanieTercZmienioneSymboleResult() {
        return raportPorownanieTercZmienioneSymboleResult;
    }

    /**
     * Sets the value of the raportPorownanieTercZmienioneSymboleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRZmianyTerc }{@code >}
     *     
     */
    public void setRaportPorownanieTercZmienioneSymboleResult(JAXBElement<ArrayOfRZmianyTerc> value) {
        this.raportPorownanieTercZmienioneSymboleResult = value;
    }

}
