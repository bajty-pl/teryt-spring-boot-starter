
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
 *         &lt;element name="PobierzKatalogSIMCAdrResult" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}PlikKatalog" minOccurs="0"/>
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
    "pobierzKatalogSIMCAdrResult"
})
@XmlRootElement(name = "PobierzKatalogSIMCAdrResponse")
public class PobierzKatalogSIMCAdrResponse {

    @XmlElementRef(name = "PobierzKatalogSIMCAdrResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PlikKatalog> pobierzKatalogSIMCAdrResult;

    /**
     * Gets the value of the pobierzKatalogSIMCAdrResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PlikKatalog }{@code >}
     *     
     */
    public JAXBElement<PlikKatalog> getPobierzKatalogSIMCAdrResult() {
        return pobierzKatalogSIMCAdrResult;
    }

    /**
     * Sets the value of the pobierzKatalogSIMCAdrResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PlikKatalog }{@code >}
     *     
     */
    public void setPobierzKatalogSIMCAdrResult(JAXBElement<PlikKatalog> value) {
        this.pobierzKatalogSIMCAdrResult = value;
    }

}
