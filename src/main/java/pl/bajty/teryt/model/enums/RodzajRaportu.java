package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

public enum RodzajRaportu implements Slownik {
    LICZBA_JEDNOSTEK_TERC("TERC", "Liczba jednostek TERC"),
    LICZBA_MIEJSCOWOSCI_WIEJSKICH("WIEJSKIE", "Liczba miejscowości wiejskich"),
    LICZBA("LICZBA", "Liczba (ogólna)");

    @Getter(onMethod_ = @Override)
    private final String kod;

    @Getter(onMethod_ = @Override)
    private final String nazwa;

    RodzajRaportu(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static RodzajRaportu fromKod(String kod) {
        if (kod == null) {
            throw new IllegalArgumentException("Kod rodzaju raportu nie może być null");
        }
        for (RodzajRaportu r : RodzajRaportu.values()) {
            if (r.kod.equalsIgnoreCase(kod)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Nieznany kod rodzaju raportu: " + kod);
    }
}