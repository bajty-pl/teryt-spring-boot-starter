package pl.bajty.teryt.model;

public record Zmiana<T>(
        RodzajZmiany rodzajZmiany,
        T stanPrzed,
        T stanPo
) {
}
