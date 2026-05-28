package pl.bajty.teryt.model.enums;

import lombok.Getter;

@Getter
public enum RodzajGminy {
    MIEJSKA("1"),
    WIEJSKA("2"),
    MIEJSKO_WIEJSKA("3"),
    MIASTO_W_GMINIE_MIEJSKO_WIEJSKIEJ("4"),
    OBSZAR_WIEJSKI_W_GMINIE_MIEJSKO_WIEJSKIEJ("5"),
    DZIELNICA_W_M_ST_WARSZAWA("8"),
    DELEGATURA("9");

    private final String value;

    RodzajGminy(String value) {
        this.value = value;
    }

    public static RodzajGminy fromValue(String value) {
        for (RodzajGminy r : RodzajGminy.values()) {
            if (r.value.equals(value)) {
                return r;
            }
        }
        return null;
    }
}
