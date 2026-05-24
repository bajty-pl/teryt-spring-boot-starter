package pl.bajty.teryt.model;

import java.time.LocalDate;

public record Wojewodztwo(
        TercCode id,
        String name,
        LocalDate stateDate
) {
}
