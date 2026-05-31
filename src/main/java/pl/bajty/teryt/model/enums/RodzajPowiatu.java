package pl.bajty.teryt.model.enums;

import lombok.Getter;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

@Getter
public enum RodzajPowiatu implements Slownik {
    POWIAT("p", "Powiat"),
    MIASTO_NA_PRAWACH_POWIATU("m", "Miasto na prawach powiatu");

    private final String kod;
    private final String nazwa;

    RodzajPowiatu(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static RodzajPowiatu fromKod(String kod) {
        for (RodzajPowiatu r : RodzajPowiatu.values()) {
            // equalsIgnoreCase jest bezpieczne na wypadek null, jeśli wywołujemy je na r.kod
            if (r.kod.equalsIgnoreCase(kod)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Nieznany kod rodzaju powiatu: " + kod);
    }
}