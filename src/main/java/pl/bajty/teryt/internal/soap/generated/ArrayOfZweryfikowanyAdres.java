
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfZweryfikowanyAdres complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfZweryfikowanyAdres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZweryfikowanyAdres" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}ZweryfikowanyAdres" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfZweryfikowanyAdres", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "zweryfikowanyAdres"
})
public class ArrayOfZweryfikowanyAdres {

    @XmlElement(name = "ZweryfikowanyAdres", nillable = true)
    protected List<ZweryfikowanyAdres> zweryfikowanyAdres;

    /**
     * Gets the value of the zweryfikowanyAdres property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zweryfikowanyAdres property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZweryfikowanyAdres().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZweryfikowanyAdres }
     * 
     * 
     */
    public List<ZweryfikowanyAdres> getZweryfikowanyAdres() {
        if (zweryfikowanyAdres == null) {
            zweryfikowanyAdres = new ArrayList<ZweryfikowanyAdres>();
        }
        return this.zweryfikowanyAdres;
    }

}
