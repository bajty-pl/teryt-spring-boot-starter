
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRodzajMiejscowosci complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRodzajMiejscowosci"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RodzajMiejscowosci" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}RodzajMiejscowosci" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRodzajMiejscowosci", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "rodzajMiejscowosci"
})
public class ArrayOfRodzajMiejscowosci {

    @XmlElement(name = "RodzajMiejscowosci", nillable = true)
    protected List<RodzajMiejscowosci> rodzajMiejscowosci;

    /**
     * Gets the value of the rodzajMiejscowosci property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the rodzajMiejscowosci property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRodzajMiejscowosci().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RodzajMiejscowosci }
     * 
     * 
     */
    public List<RodzajMiejscowosci> getRodzajMiejscowosci() {
        if (rodzajMiejscowosci == null) {
            rodzajMiejscowosci = new ArrayList<RodzajMiejscowosci>();
        }
        return this.rodzajMiejscowosci;
    }

}
