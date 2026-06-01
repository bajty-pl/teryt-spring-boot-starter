package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.RodzajGminy;

import java.time.LocalDate;

/**
 * Reprezentuje gminę w systemie TERYT.
 *
 * @param id           Identyfikator TERC gminy.
 * @param nazwa        Nazwa gminy.
 * @param rodzajGminy  Rodzaj gminy (miejska, wiejska, miejsko-wiejska itp.).
 * @param powiat       Powiat, do którego należy gmina.
 * @param stanNa       Data stanu danych.
 */
public record Gmina(
        Terc id,
        String nazwa,
        RodzajGminy rodzajGminy,
        Powiat powiat,
        LocalDate stanNa) {
}
