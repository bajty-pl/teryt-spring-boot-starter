
package pl.bajty.teryt.internal.soap.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUlicaDrzewo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUlicaDrzewo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UlicaDrzewo" type="{http://schemas.datacontract.org/2004/07/TerytUslugaWs1}UlicaDrzewo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUlicaDrzewo", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1", propOrder = {
    "ulicaDrzewo"
})
public class ArrayOfUlicaDrzewo {

    @XmlElement(name = "UlicaDrzewo", nillable = true)
    protected List<UlicaDrzewo> ulicaDrzewo;

    /**
     * Gets the value of the ulicaDrzewo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ulicaDrzewo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUlicaDrzewo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UlicaDrzewo }
     * 
     * 
     */
    public List<UlicaDrzewo> getUlicaDrzewo() {
        if (ulicaDrzewo == null) {
            ulicaDrzewo = new ArrayList<UlicaDrzewo>();
        }
        return this.ulicaDrzewo;
    }

}
