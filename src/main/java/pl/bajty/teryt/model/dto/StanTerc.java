package pl.bajty.teryt.model.dto;

import java.time.LocalDate;

/**
 * Reprezentuje stan jednostki terytorialnej w systemie TERC.
 *
 * @param id             Identyfikator TERC jednostki.
 * @param nazwa          Nazwa jednostki.
 * @param nazwaDodatkowa Dodatkowa nazwa (np. określenie rodzaju jednostki).
 * @param stanNa         Data stanu danych.
 */
public record StanTerc(
        Terc id,
        String nazwa,
        String nazwaDodatkowa,
        LocalDate stanNa
) {
}
