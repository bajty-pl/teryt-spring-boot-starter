package pl.bajty.teryt.model.dto;

import java.time.LocalDate;

/**
 * Reprezentuje województwo w systemie TERYT.
 *
 * @param id      Identyfikator TERC województwa.
 * @param nazwa   Nazwa województwa.
 * @param stanNa  Data stanu danych.
 */
public record Wojewodztwo(
        Terc id,
        String nazwa,
        LocalDate stanNa
) {
}
