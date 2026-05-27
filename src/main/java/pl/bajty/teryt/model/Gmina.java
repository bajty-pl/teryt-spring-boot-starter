package pl.bajty.teryt.model;

import java.time.LocalDate;

public record Gmina(
        Terc id,
        String nazwa,
        RodzajGminy rodzajGminy,
        Powiat powiat,
        Wojewodztwo wojewodztwo,
        LocalDate stanNa) {
}
