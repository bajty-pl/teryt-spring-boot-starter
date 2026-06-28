package pl.bajty.teryt.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

/**
 * Rodzaje powiatów (powiat ziemski lub miasto na prawach powiatu).
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RodzajPowiatu implements Slownik {
    POWIAT("p", "Powiat"),
    MIASTO_NA_PRAWACH_POWIATU("m", "Miasto na prawach powiatu");

    @Getter(onMethod_ = @Override)
    private final String kod;
    @Getter(onMethod_ = @Override)
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