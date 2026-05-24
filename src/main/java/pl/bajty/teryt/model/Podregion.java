package pl.bajty.teryt.model;

import java.time.LocalDate;

public record Podregion(
        String id,
        String nazwa,
        Terc wojewodztwoId,
        Terc powiatId,
        LocalDate stateDate
) {
}
