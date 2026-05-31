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
        if (kod == null || kod.isBlank()) {
            return null;
        }
        for (RodzajPowiatu r : RodzajPowiatu.values()) {
            if (r.kod.equalsIgnoreCase(kod.trim())) {
                return r;
            }
        }
        return null;
    }
}