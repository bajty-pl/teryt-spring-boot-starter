package pl.bajty.teryt.model;

import java.time.LocalDate;

public record Region(
        String id,
        String nazwa,
        LocalDate stanNa
) {
}
