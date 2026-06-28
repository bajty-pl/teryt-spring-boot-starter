package pl.bajty.teryt.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.bajty.teryt.model.enums.RodzajMiejscowosci;

/**
 * Reprezentuje miejscowość w systemie TERYT.
 *
 * @param id                Identyfikator SIMC miejscowości.
 * @param nazwa             Nazwa miejscowości.
 * @param rodzajMiejscowosci Rodzaj miejscowości (wieś, osada, kolonia itp.).
 * @param symbolPodstawowy  Identyfikator SIMC miejscowości podstawowej.
 * @param gmina             Gmina, w której znajduje się miejscowość.
 */
public record Miejscowosc(
        @JsonProperty("id") Simc id,
        @JsonProperty("nazwa") String nazwa,
        @JsonProperty("rodzajMiejscowosci") RodzajMiejscowosci rodzajMiejscowosci,
        @JsonProperty("symbolPodstawowy") Simc symbolPodstawowy,
        @JsonProperty("gmina") Gmina gmina
) {
}
