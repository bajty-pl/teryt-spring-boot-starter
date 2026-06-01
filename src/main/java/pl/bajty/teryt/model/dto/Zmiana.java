package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.RodzajZmiany;

/**
 * Reprezentuje zmianę w danych obiektu TERYT.
 *
 * @param <T>           Typ obiektu, którego dotyczy zmiana.
 * @param rodzajZmiany  Rodzaj dokonanej zmiany.
 * @param stanPrzed    Stan obiektu przed zmianą.
 * @param stanPo       Stan obiektu po zmianie.
 */
public record Zmiana<T>(
        RodzajZmiany rodzajZmiany,
        T stanPrzed,
        T stanPo
) {
}
