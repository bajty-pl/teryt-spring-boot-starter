package pl.bajty.teryt.model.enums;

import lombok.Getter;

@Getter
public enum RodzajMiejscowosci {
    MIEJSCOWOSC_PODSTAWOWA("P"),
    CZESC_MIEJSCOWOSCI("C");

    private final String value;

    RodzajMiejscowosci(String value) {
        this.value = value;
    }

    public static RodzajMiejscowosci fromValue(String value) {
        for (RodzajMiejscowosci r : RodzajMiejscowosci.values()) {
            if (r.value.equals(value)) {
                return r;
            }
        }
        return null;
    }
}
