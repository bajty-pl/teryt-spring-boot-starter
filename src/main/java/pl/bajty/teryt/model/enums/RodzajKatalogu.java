package pl.bajty.teryt.model.enums;

import lombok.Getter;
import pl.bajty.teryt.model.interfaces.Slownik;

/**
 * Rodzaje katalogów dostępnych w systemie TERYT.
 */
public enum RodzajKatalogu implements Slownik {
    NTS("NTS", "Katalog NTS (Jednostki terytorialne)"),
    SIMC("SIMC", "Katalog SIMC (Miejscowości)"),
    SIMC_ADRESOWY("SIMC_ADR", "Katalog SIMC - adresowy"),
    SIMC_STATYSTYCZNY("SIMC_STAT", "Katalog SIMC - statystyczny"),
    TERC("TERC", "Katalog TERC (Podział terytorialny)"),
    TERC_ADRESOWY("TERC_ADR", "Katalog TERC - adresowy"),
    ULIC("ULIC", "Katalog ULIC (Ulice)"),
    ULIC_ADRESOWY("ULIC_ADR", "Katalog ULIC - adresowy"),
    ULIC_BEZ_DZIELNIC("ULIC_BD", "Katalog ULIC - bez dzielnic"),
    ULIC_STARY("ULIC_OLD", "Katalog ULIC - stary");

    @Getter(onMethod_ = @Override)
    private final String kod;

    @Getter(onMethod_ = @Override)
    private final String nazwa;

    RodzajKatalogu(String kod, String nazwa) {
        this.kod = kod;
        this.nazwa = nazwa;
    }

    public static RodzajKatalogu fromKod(String kod) {
        if (kod == null) {
            throw new IllegalArgumentException("Kod rodzaju katalogu nie może być null");
        }
        for (RodzajKatalogu r : RodzajKatalogu.values()) {
            if (r.kod.equalsIgnoreCase(kod)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Nieznany kod rodzaju katalogu: " + kod);
    }
}