
package pl.bajty.teryt.internal.soap.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OdpowiedzTerytStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OdpowiedzTerytStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sukces"/>
 *     &lt;enumeration value="Blad"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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
