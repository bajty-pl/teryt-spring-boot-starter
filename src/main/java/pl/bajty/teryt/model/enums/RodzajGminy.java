package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

public enum RodzajGminy implements Slownik {
    MIEJSKA("1", "Gmina miejska"),
    WIEJSKA("2", "Gmina wiejska"),
    MIEJSKO_WIEJSKA("3", "Gmina miejsko-wiejska"),
    MIASTO_W_GMINIE_MIEJSKO_WIEJSKIEJ("4", "Miasto w gminie miejsko-wiejskiej"),
    OBSZAR_WIEJSKI_W_GMINIE_MIEJSKO_WIEJSKIEJ("5", "Obszar wiejski w gminie miejsko-wiejskiej"),
    DZIELNICA_W_M_ST_WARSZAWA("8", "Dzielnica m. st. Warszawy"),
    DELEGATURA("9", "Delegatura");

    @Getter(onMethod_ = @Override)
    private final String kod;
    @Getter(onMethod_ = @Override)
    private final String nazwa;

    RodzajGminy(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static RodzajGminy fromKod(String kod) {
        if (kod == null || kod.isBlank()) {
            return null;
        }
        for (RodzajGminy r : RodzajGminy.values()) {
            if (r.kod.equalsIgnoreCase(kod.trim())) {
                return r;
            }
        }
        return null;
    }
}
