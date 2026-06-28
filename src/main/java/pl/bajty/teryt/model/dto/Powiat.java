package pl.bajty.teryt.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("id") Terc id,
        @JsonProperty("nazwa") String nazwa,
        @JsonProperty("rodzajPowiatu") RodzajPowiatu rodzajPowiatu,
        @JsonProperty("wojewodztwo") Wojewodztwo wojewodztwo,
        @JsonProperty("stanNa") LocalDate stanNa) implements JednostkaTerytorialna {
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
