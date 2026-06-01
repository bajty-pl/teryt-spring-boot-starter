package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.interfaces.JednostkaTerytorialna;

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
        return PoziomJednostkiTerytorialnej.GMINA;
    }
}
