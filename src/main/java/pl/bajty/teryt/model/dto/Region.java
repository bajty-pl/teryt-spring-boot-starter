package pl.bajty.teryt.model.dto;

import java.time.LocalDate;

public record Region(
        String id,
        String nazwa,
        LocalDate stanNa
) {
}
