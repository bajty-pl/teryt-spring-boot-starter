package pl.bajty.teryt.model.dto;

/**
 * Reprezentuje plik z katalogu TERYT.
 *
 * @param nazwa     Nazwa pliku.
 * @param zawartosc Zawartość pliku (zakodowana w Base64).
 * @param opis      Opis zawartości pliku.
 */
public record PlikKatalogu(
        String nazwa,
        String zawartosc,
        String opis
) {
}
