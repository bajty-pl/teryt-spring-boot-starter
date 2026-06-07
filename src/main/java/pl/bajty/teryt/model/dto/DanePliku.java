package pl.bajty.teryt.model.dto;

import java.util.Base64;

/**
 * Reprezentuje rozkodowany plik z katalogu TERYT, gotowy do zapisu na dysku.
 *
 * @param nazwa     Nazwa pliku.
 * @param zawartosc Zawartość pliku w formie tablicy bajtów.
 * @param opis      Opis zawartości pliku.
 */
public record DanePliku(
        String nazwa,
        byte[] zawartosc,
        String opis
) {
    /**
     * Tworzy obiekt DanePliku z obiektu PlikKatalogu, dekodując zawartość z Base64.
     *
     * @param plikKatalogu Obiekt z zawartością w Base64.
     * @return Obiekt z rozkodowaną zawartością.
     */
    public static DanePliku from(PlikKatalogu plikKatalogu) {
        if (plikKatalogu == null) {
            return null;
        }
        byte[] decoded = (plikKatalogu.zawartosc() != null)
                ? Base64.getDecoder().decode(plikKatalogu.zawartosc())
                : new byte[0];
        return new DanePliku(plikKatalogu.nazwa(), decoded, plikKatalogu.opis());
    }
}
