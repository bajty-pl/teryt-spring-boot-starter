package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

@Getter
public enum RodzajMiejscowosci implements Slownik {
    MIEJSCOWOSC_PODSTAWOWA("P", "Miejscowość podstawowa"),
    CZESC_MIEJSCOWOSCI("C", "Część miejscowości");

    private final String kod;
    private final String nazwa;

    RodzajMiejscowosci(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static RodzajMiejscowosci fromKod(String kod) {
        for (RodzajMiejscowosci r : RodzajMiejscowosci.values()) {
            if (r.kod.equals(kod)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Nieznany kod rodzaju miejscowości: " + kod);
    }
}