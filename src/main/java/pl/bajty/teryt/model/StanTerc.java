package pl.bajty.teryt.model;

import java.time.LocalDate;

public record StanTerc(
        Terc id,
        String nazwa,
        String nazwaDodatkowa,
        LocalDate stanNa
) {
}
