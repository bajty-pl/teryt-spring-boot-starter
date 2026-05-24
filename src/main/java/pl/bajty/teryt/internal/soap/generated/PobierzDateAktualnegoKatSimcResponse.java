
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="PobierzDateAktualnegoKatSimcResult" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
    "pobierzDateAktualnegoKatSimcResult"
})
@XmlRootElement(name = "PobierzDateAktualnegoKatSimcResponse")
public class PobierzDateAktualnegoKatSimcResponse {

    @XmlElement(name = "PobierzDateAktualnegoKatSimcResult")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pobierzDateAktualnegoKatSimcResult;

    /**
     * Gets the value of the pobierzDateAktualnegoKatSimcResult property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPobierzDateAktualnegoKatSimcResult() {
        return pobierzDateAktualnegoKatSimcResult;
    }

    /**
     * Sets the value of the pobierzDateAktualnegoKatSimcResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPobierzDateAktualnegoKatSimcResult(XMLGregorianCalendar value) {
        this.pobierzDateAktualnegoKatSimcResult = value;
    }

}
