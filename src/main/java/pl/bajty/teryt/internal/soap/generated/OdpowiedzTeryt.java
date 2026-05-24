
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OdpowiedzTeryt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OdpowiedzTeryt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}OdpowiedzTerytStatus"/&gt;
 *         &lt;element name="OpisBledu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OdpowiedzTeryt", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "status",
    "opisBledu"
})
public class OdpowiedzTeryt {

    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "string")
    protected OdpowiedzTerytStatus status;
    @XmlElement(name = "OpisBledu", required = true, nillable = true)
    protected String opisBledu;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link OdpowiedzTerytStatus }
     *     
     */
    public OdpowiedzTerytStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link OdpowiedzTerytStatus }
     *     
     */
    public void setStatus(OdpowiedzTerytStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the opisBledu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisBledu() {
        return opisBledu;
    }

    /**
     * Sets the value of the opisBledu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisBledu(String value) {
        this.opisBledu = value;
    }

}
