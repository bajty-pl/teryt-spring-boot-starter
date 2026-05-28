package pl.bajty.teryt.model.dto;

public record Ulica(
        Ulic id,
        String nazwa,
        String cecha,
        Miejscowosc miejscowosc,
        Gmina gmina,
        Powiat powiat,
        Wojewodztwo wojewodztwo
) {
}
