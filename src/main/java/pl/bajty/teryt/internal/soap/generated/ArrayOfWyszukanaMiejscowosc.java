
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWyszukanaMiejscowosc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWyszukanaMiejscowosc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WyszukanaMiejscowosc" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}WyszukanaMiejscowosc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWyszukanaMiejscowosc", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "wyszukanaMiejscowosc"
})
public class ArrayOfWyszukanaMiejscowosc {

    @XmlElement(name = "WyszukanaMiejscowosc", nillable = true)
    protected List<WyszukanaMiejscowosc> wyszukanaMiejscowosc;

    /**
     * Gets the value of the wyszukanaMiejscowosc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wyszukanaMiejscowosc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWyszukanaMiejscowosc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WyszukanaMiejscowosc }
     * 
     * 
     */
    public List<WyszukanaMiejscowosc> getWyszukanaMiejscowosc() {
        if (wyszukanaMiejscowosc == null) {
            wyszukanaMiejscowosc = new ArrayList<WyszukanaMiejscowosc>();
        }
        return this.wyszukanaMiejscowosc;
    }

}
