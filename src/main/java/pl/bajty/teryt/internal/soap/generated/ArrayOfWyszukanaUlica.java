
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWyszukanaUlica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWyszukanaUlica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WyszukanaUlica" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}WyszukanaUlica" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWyszukanaUlica", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "wyszukanaUlica"
})
public class ArrayOfWyszukanaUlica {

    @XmlElement(name = "WyszukanaUlica", nillable = true)
    protected List<WyszukanaUlica> wyszukanaUlica;

    /**
     * Gets the value of the wyszukanaUlica property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wyszukanaUlica property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWyszukanaUlica().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WyszukanaUlica }
     * 
     * 
     */
    public List<WyszukanaUlica> getWyszukanaUlica() {
        if (wyszukanaUlica == null) {
            wyszukanaUlica = new ArrayList<WyszukanaUlica>();
        }
        return this.wyszukanaUlica;
    }

}
