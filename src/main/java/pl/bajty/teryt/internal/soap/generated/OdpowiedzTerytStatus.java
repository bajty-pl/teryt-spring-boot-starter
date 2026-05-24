
package pl.bajty.teryt.internal.soap.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OdpowiedzTerytStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="OdpowiedzTerytStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Sukces"/&gt;
 *     &lt;enumeration value="Blad"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OdpowiedzTerytStatus", namespace = "http://schemas.datacontract.org/2004/07/TerytUslugaWs1")
@XmlEnum
public enum OdpowiedzTerytStatus {

    @XmlEnumValue("Sukces")
    SUKCES("Sukces"),
    @XmlEnumValue("Blad")
    BLAD("Blad");
    private final String value;

    OdpowiedzTerytStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OdpowiedzTerytStatus fromValue(String v) {
        for (OdpowiedzTerytStatus c: OdpowiedzTerytStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
