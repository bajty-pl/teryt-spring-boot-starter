package pl.bajty.teryt.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;
import pl.bajty.teryt.model.interfaces.JednostkaTerytorialna;

import java.time.LocalDate;

/**
 * Reprezentuje województwo w systemie TERYT.
 *
 * @param id      Identyfikator TERC województwa.
 * @param nazwa   Nazwa województwa.
 * @param stanNa  Data stanu danych.
 */
public record Wojewodztwo(
        @JsonProperty("id") Terc id,
        @JsonProperty("nazwa") String nazwa,
        @JsonProperty("stanNa") LocalDate stanNa
) implements JednostkaTerytorialna {
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
        return PoziomJednostkiTerytorialnej.WOJEWODZTWO;
    }
}
