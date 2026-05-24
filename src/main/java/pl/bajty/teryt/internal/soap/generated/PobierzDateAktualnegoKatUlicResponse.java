
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
 *         &lt;element name="PobierzDateAktualnegoKatUlicResult" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "pobierzDateAktualnegoKatUlicResult"
})
@XmlRootElement(name = "PobierzDateAktualnegoKatUlicResponse")
public class PobierzDateAktualnegoKatUlicResponse {

    @XmlElement(name = "PobierzDateAktualnegoKatUlicResult")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pobierzDateAktualnegoKatUlicResult;

    /**
     * Gets the value of the pobierzDateAktualnegoKatUlicResult property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPobierzDateAktualnegoKatUlicResult() {
        return pobierzDateAktualnegoKatUlicResult;
    }

    /**
     * Sets the value of the pobierzDateAktualnegoKatUlicResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPobierzDateAktualnegoKatUlicResult(XMLGregorianCalendar value) {
        this.pobierzDateAktualnegoKatUlicResult = value;
    }

}
