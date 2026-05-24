
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
 *         &lt;element name="RaportPorownanieTercNoweJednostkiResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ArrayOfRJednostkiTerc" minOccurs="0"/>
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
    "raportPorownanieTercNoweJednostkiResult"
})
@XmlRootElement(name = "RaportPorownanieTercNoweJednostkiResponse")
public class RaportPorownanieTercNoweJednostkiResponse {

    @XmlElementRef(name = "RaportPorownanieTercNoweJednostkiResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRJednostkiTerc> raportPorownanieTercNoweJednostkiResult;

    /**
     * Gets the value of the raportPorownanieTercNoweJednostkiResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRJednostkiTerc }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRJednostkiTerc> getRaportPorownanieTercNoweJednostkiResult() {
        return raportPorownanieTercNoweJednostkiResult;
    }

    /**
     * Sets the value of the raportPorownanieTercNoweJednostkiResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRJednostkiTerc }{@code >}
     *     
     */
    public void setRaportPorownanieTercNoweJednostkiResult(JAXBElement<ArrayOfRJednostkiTerc> value) {
        this.raportPorownanieTercNoweJednostkiResult = value;
    }

}
