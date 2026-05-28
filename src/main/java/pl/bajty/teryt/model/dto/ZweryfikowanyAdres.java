package pl.bajty.teryt.model.dto;

public record ZweryfikowanyAdres(
        String wojewodztwo,
        String symbolWoj,
        String powiat,
        String symbolPow,
        String gmina,
        String symbolGmi,
        String rodzajGminy,
        String symbolRodzajuGminy,
        String miejscowosc,
        String symbolMiejscowosci,
        String rodzajMiejscowosci,
        String historycznyRodzajMiejscowosci,
        String ulica,
        String symbolUlicy,
        String cechaUlicy
) {
}
