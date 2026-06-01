package pl.bajty.teryt.model.dto;

import java.time.LocalDate;

/**
 * Reprezentuje region statystyczny.
 *
 * @param id      Identyfikator regionu.
 * @param nazwa   Nazwa regionu.
 * @param stanNa  Data stanu danych.
 */
public record Region(
        String id,
        String nazwa,
        LocalDate stanNa
) {
}
