package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.RodzajMiejscowosci;

public record Miejscowosc(
        Simc id,
        String nazwa,
        RodzajMiejscowosci rodzajMiejscowosci,
        Simc symbolPodstawowy,
        Gmina gmina
) {
}
