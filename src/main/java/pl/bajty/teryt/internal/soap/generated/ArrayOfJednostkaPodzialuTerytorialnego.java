
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJednostkaPodzialuTerytorialnego complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJednostkaPodzialuTerytorialnego"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="JednostkaPodzialuTerytorialnego" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}JednostkaPodzialuTerytorialnego" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJednostkaPodzialuTerytorialnego", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "jednostkaPodzialuTerytorialnego"
})
public class ArrayOfJednostkaPodzialuTerytorialnego {

    @XmlElement(name = "JednostkaPodzialuTerytorialnego", nillable = true)
    protected List<JednostkaPodzialuTerytorialnego> jednostkaPodzialuTerytorialnego;

    /**
     * Gets the value of the jednostkaPodzialuTerytorialnego property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the jednostkaPodzialuTerytorialnego property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJednostkaPodzialuTerytorialnego().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JednostkaPodzialuTerytorialnego }
     * 
     * 
     */
    public List<JednostkaPodzialuTerytorialnego> getJednostkaPodzialuTerytorialnego() {
        if (jednostkaPodzialuTerytorialnego == null) {
            jednostkaPodzialuTerytorialnego = new ArrayList<JednostkaPodzialuTerytorialnego>();
        }
        return this.jednostkaPodzialuTerytorialnego;
    }

}
