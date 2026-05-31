package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

public enum CechaUlicy implements Slownik {
    ULICA("ul.", "Ulica"),
    ALEJA("al.", "Aleja"),
    PLAC("pl.", "Plac"),
    SKWER("skwer", "Skwer"),
    BULWAR("bulw.", "Bulwar"),
    RONDO("rondo", "Rondo"),
    PARK("park", "Park"),
    RYNEK("rynek", "Rynek"),
    SZOSA("szosa", "Szosa"),
    DROGA("droga", "Droga"),
    OSIEDLE("os.", "Osiedle"),
    OGROD("ogród", "Ogród"),
    WYSPA("wyspa", "Wyspa"),
    WYBRZEZE("wybrzeże", "Wybrzeże"),
    INNE("", "Inne");

    @Getter(onMethod_ = @Override)
    private final String kod;
    @Getter(onMethod_ = @Override)
    private final String nazwa;

    CechaUlicy(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static CechaUlicy fromKod(String kod) {
        if (kod == null) {
            return INNE;
        }
        for (CechaUlicy c : CechaUlicy.values()) {
            if (c.kod.equalsIgnoreCase(kod.trim())) {
                return c;
            }
        }
        return INNE;
    }
}