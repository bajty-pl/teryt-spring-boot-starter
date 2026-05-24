package pl.bajty.teryt.model;

import java.time.LocalDate;

public record Gmina(
        Terc id,
        String name,
        RodzajGminy rodzajGminy,
        Powiat powiat,
        Wojewodztwo wojewodztwo,
        LocalDate stateDate) {
}
