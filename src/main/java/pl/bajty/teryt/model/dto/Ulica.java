package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.CechaUlicy;

/**
 * Reprezentuje ulicę w systemie TERYT.
 *
 * @param id          Identyfikator ULIC ulicy.
 * @param nazwa       Nazwa ulicy.
 * @param cecha       Cecha ulicy (np. ul., al., pl.).
 * @param miejscowosc Miejscowość, w której znajduje się ulica.
 */
public record Ulica(
        Ulic id,
        String nazwa,
        CechaUlicy cecha,
        Miejscowosc miejscowosc
) {
}
