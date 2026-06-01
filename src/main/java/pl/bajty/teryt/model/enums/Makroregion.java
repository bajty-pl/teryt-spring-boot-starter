package pl.bajty.teryt.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.bajty.teryt.model.interfaces.Slownik;

/**
 * Makroregiony Polski zgodnie z klasyfikacją NUTS 1.
 */
@RequiredArgsConstructor
public enum Makroregion implements Slownik {

    POLUDNIOWY("PL2", "Makroregion południowy"),
    POLNOCNO_ZACHODNI("PL4", "Makroregion północno-zachodni"),
    POLUDNIOWO_ZACHODNI("PL5", "Makroregion południowo-zachodni"),
    POLNOCNY("PL6", "Makroregion północny"),
    CENTRALNY("PL7", "Makroregion centralny"),
    WSCHODNI("PL8", "Makroregion wschodni"),
    WOJEWODZTWO_MAZOWIECKIE("PL9", "Makroregion województwo mazowieckie");

    @Getter(onMethod_ = @Override)
    private final String kod;

    @Getter(onMethod_ = @Override)
    private final String nazwa;
}
