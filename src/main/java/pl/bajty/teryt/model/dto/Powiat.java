package pl.bajty.teryt.model.dto;


import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;
import pl.bajty.teryt.model.enums.RodzajPowiatu;
import pl.bajty.teryt.model.interfaces.JednostkaTerytorialna;

import java.time.LocalDate;

/**
 * Reprezentuje powiat w systemie TERYT.
 *
 * @param id             Identyfikator TERC powiatu.
 * @param nazwa          Nazwa powiatu.
 * @param rodzajPowiatu  Rodzaj powiatu (ziemski, miasto na prawach powiatu).
 * @param wojewodztwo    Województwo, do którego należy powiat.
 * @param stanNa         Data stanu danych.
 */
public record Powiat(
        Terc id,
        String nazwa,
        RodzajPowiatu rodzajPowiatu,
        Wojewodztwo wojewodztwo,
        LocalDate stanNa) implements JednostkaTerytorialna {
    @Override
    public Terc id() {
        return id;
    }

    @Override
    public String nazwa() {
        return nazwa;
    }

    @Override
    public PoziomJednostkiTerytorialnej poziomJednostkiTerytorialnej() {
        return PoziomJednostkiTerytorialnej.POWIAT;
    }
}
