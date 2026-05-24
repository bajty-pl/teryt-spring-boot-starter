package pl.bajty.teryt.model;


import java.time.LocalDate;

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
        return id.getPoziomJednostkiTerytorialnej();
    }
}
