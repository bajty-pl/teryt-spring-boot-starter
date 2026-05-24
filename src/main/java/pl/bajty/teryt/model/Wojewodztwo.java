package pl.bajty.teryt.model;

import java.time.LocalDate;

public record Wojewodztwo(
        Terc id,
        String nazwa,
        LocalDate stanNa
) {
}
