package pl.bajty.teryt.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("id") Ulic id,
        @JsonProperty("nazwa") String nazwa,
        @JsonProperty("cecha") CechaUlicy cecha,
        @JsonProperty("miejscowosc") Miejscowosc miejscowosc
) {
}
