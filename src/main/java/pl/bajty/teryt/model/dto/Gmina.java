package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.RodzajGminy;

import java.time.LocalDate;

public record Gmina(
        Terc id,
        String nazwa,
        RodzajGminy rodzajGminy,
        Powiat powiat,
        Wojewodztwo wojewodztwo,
        LocalDate stanNa) {
}
