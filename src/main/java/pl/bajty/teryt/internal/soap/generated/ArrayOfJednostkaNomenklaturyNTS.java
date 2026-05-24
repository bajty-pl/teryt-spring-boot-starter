
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJednostkaNomenklaturyNTS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJednostkaNomenklaturyNTS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="JednostkaNomenklaturyNTS" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}JednostkaNomenklaturyNTS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJednostkaNomenklaturyNTS", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "jednostkaNomenklaturyNTS"
})
public class ArrayOfJednostkaNomenklaturyNTS {

    @XmlElement(name = "JednostkaNomenklaturyNTS", nillable = true)
    protected List<JednostkaNomenklaturyNTS> jednostkaNomenklaturyNTS;

    /**
     * Gets the value of the jednostkaNomenklaturyNTS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the jednostkaNomenklaturyNTS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJednostkaNomenklaturyNTS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JednostkaNomenklaturyNTS }
     * 
     * 
     */
    public List<JednostkaNomenklaturyNTS> getJednostkaNomenklaturyNTS() {
        if (jednostkaNomenklaturyNTS == null) {
            jednostkaNomenklaturyNTS = new ArrayList<JednostkaNomenklaturyNTS>();
        }
        return this.jednostkaNomenklaturyNTS;
    }

}
