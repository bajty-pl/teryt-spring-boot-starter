package pl.bajty.teryt.model;

public record Miejscowosc(
        Simc id,
        String nazwa,
        RodzajMiejscowosci rodzajMiejscowosci,
        Simc symbolPodstawowy,
        Gmina gmina,
        Powiat powiat,
        Wojewodztwo wojewodztwo
) {
}
