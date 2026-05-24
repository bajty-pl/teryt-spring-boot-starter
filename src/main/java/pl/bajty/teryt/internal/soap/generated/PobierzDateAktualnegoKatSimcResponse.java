
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="PobierzDateAktualnegoKatSimcResult" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
