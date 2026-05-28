package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.CechaUlicy;

public record Ulica(
        Ulic id,
        String nazwa,
        CechaUlicy cecha,
        Miejscowosc miejscowosc
) {
}
