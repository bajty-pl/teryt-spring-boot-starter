package pl.bajty.teryt.model.dto;

/**
 * Reprezentuje wynik weryfikacji adresu.
 *
 * @param miejscowosc Zweryfikowana miejscowość.
 * @param ulica       Zweryfikowana ulica.
 */
public record ZweryfikowanyAdres(
        Miejscowosc miejscowosc,
        Ulica ulica
) {
}
