package pl.bajty.teryt.model.enums;

import lombok.Getter;

@Getter
public enum CechaUlicy {
    ULICA("ul."),
    ALEJA("al."),
    PLAC("pl."),
    SKWER("skwer"),
    BULWAR("bulw."),
    RONDO("rondo"),
    PARK("park"),
    RYNEK("rynek"),
    SZOSA("szosa"),
    DROGA("droga"),
    OSIEDLE("os."),
    OGROD("ogród"),
    WYSPA("wyspa"),
    WYBRZEZE("wybrzeże"),
    INNE("");

    private final String value;

    CechaUlicy(String value) {
        this.value = value;
    }

    public static CechaUlicy fromValue(String value) {
        if (value == null) return INNE;
        for (CechaUlicy c : CechaUlicy.values()) {
            if (c.value.equalsIgnoreCase(value.trim())) {
                return c;
            }
        }
        return INNE;
    }
}
