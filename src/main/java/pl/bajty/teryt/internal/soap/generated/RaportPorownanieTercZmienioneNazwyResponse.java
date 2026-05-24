
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
 *         &lt;element name="RaportPorownanieTercZmienioneNazwyResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfRZmianyTerc" minOccurs="0"/&gt;
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
    "raportPorownanieTercZmienioneNazwyResult"
})
@XmlRootElement(name = "RaportPorownanieTercZmienioneNazwyResponse")
public class RaportPorownanieTercZmienioneNazwyResponse {

    @XmlElementRef(name = "RaportPorownanieTercZmienioneNazwyResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRZmianyTerc> raportPorownanieTercZmienioneNazwyResult;

    /**
     * Gets the value of the raportPorownanieTercZmienioneNazwyResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRZmianyTerc }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRZmianyTerc> getRaportPorownanieTercZmienioneNazwyResult() {
        return raportPorownanieTercZmienioneNazwyResult;
    }

    /**
     * Sets the value of the raportPorownanieTercZmienioneNazwyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRZmianyTerc }{@code >}
     *     
     */
    public void setRaportPorownanieTercZmienioneNazwyResult(JAXBElement<ArrayOfRZmianyTerc> value) {
        this.raportPorownanieTercZmienioneNazwyResult = value;
    }

}
