package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;

public interface JednostkaTerytorialna {
    Terc id();

    String nazwa();

    PoziomJednostkiTerytorialnej poziomJednostkiTerytorialnej();
}
