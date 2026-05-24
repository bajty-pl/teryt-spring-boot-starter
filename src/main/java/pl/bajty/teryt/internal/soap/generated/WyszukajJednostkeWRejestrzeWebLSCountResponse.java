
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="WyszukajJednostkeWRejestrzeWebLSCountResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
    "wyszukajJednostkeWRejestrzeWebLSCountResult"
})
@XmlRootElement(name = "WyszukajJednostkeWRejestrzeWebLSCountResponse")
public class WyszukajJednostkeWRejestrzeWebLSCountResponse {

    @XmlElement(name = "WyszukajJednostkeWRejestrzeWebLSCountResult")
    protected Integer wyszukajJednostkeWRejestrzeWebLSCountResult;

    /**
     * Gets the value of the wyszukajJednostkeWRejestrzeWebLSCountResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWyszukajJednostkeWRejestrzeWebLSCountResult() {
        return wyszukajJednostkeWRejestrzeWebLSCountResult;
    }

    /**
     * Sets the value of the wyszukajJednostkeWRejestrzeWebLSCountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWyszukajJednostkeWRejestrzeWebLSCountResult(Integer value) {
        this.wyszukajJednostkeWRejestrzeWebLSCountResult = value;
    }

}
