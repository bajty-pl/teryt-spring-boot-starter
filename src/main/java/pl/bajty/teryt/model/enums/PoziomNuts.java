package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

/**
 * Poziomy klasyfikacji Jednostek Terytorialnych do Celów Statystycznych (NUTS).
 */
public enum PoziomNuts implements Slownik {
    MAKROREGION_NUTS1("NUTS1", "Makroregion (NUTS 1)"),
    REGION_NUTS2("NUTS2", "Region (NUTS 2)"),
    PODREGION_NUTS3("NUTS3", "Podregion (NUTS 3)");

    @Getter(onMethod_ = @Override)
    private final String kod;

    @Getter(onMethod_ = @Override)
    private final String nazwa;

    PoziomNuts(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static PoziomNuts fromKod(String kod) {
        if (kod == null) {
            throw new IllegalArgumentException("Kod poziomu NUTS nie może być null");
        }
        for (PoziomNuts p : PoziomNuts.values()) {
            if (p.kod.equalsIgnoreCase(kod)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Nieznany kod poziomu NUTS: " + kod);
    }
}