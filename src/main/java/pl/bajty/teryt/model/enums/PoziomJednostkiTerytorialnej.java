package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

/**
 * Poziomy jednostek podziału terytorialnego kraju.
 */
public enum PoziomJednostkiTerytorialnej implements Slownik {
    WOJEWODZTWO("woj", "Województwo", 2),
    POWIAT("pow", "Powiat", 4),
    GMINA("gmi", "Gmina", 7);

    @Getter(onMethod_ = @Override)
    private final String kod;

    @Getter(onMethod_ = @Override)
    private final String nazwa;

    @Getter
    private final int codeLength;

    PoziomJednostkiTerytorialnej(String kod, String nazwa, int codeLength) {
        this.kod = kod;
        this.nazwa = nazwa;
        this.codeLength = codeLength;
    }

    public static PoziomJednostkiTerytorialnej fromKod(String kod) {
        if (kod == null) {
            throw new IllegalArgumentException("Kod poziomu jednostki nie może być null");
        }
        for (PoziomJednostkiTerytorialnej p : PoziomJednostkiTerytorialnej.values()) {
            if (p.kod.equalsIgnoreCase(kod)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Nieznany kod poziomu jednostki terytorialnej: " + kod);
    }
}