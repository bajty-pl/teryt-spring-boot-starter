package pl.bajty.teryt.model.dto;

import java.time.LocalDate;

/**
 * Reprezentuje podregion statystyczny.
 *
 * @param id             Identyfikator podregionu.
 * @param nazwa          Nazwa podregionu.
 * @param wojewodztwoId  Identyfikator TERC województwa.
 * @param powiatId       Identyfikator TERC powiatu.
 * @param stateDate      Data stanu danych.
 */
public record Podregion(
        String id,
        String nazwa,
        Terc wojewodztwoId,
        Terc powiatId,
        LocalDate stateDate
) {
}
