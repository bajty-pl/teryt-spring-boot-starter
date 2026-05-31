package pl.bajty.teryt.model.interfaces;

import pl.bajty.teryt.model.dto.Terc;
import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;

public interface JednostkaTerytorialna {
    Terc id();

    String nazwa();

    PoziomJednostkiTerytorialnej poziomJednostkiTerytorialnej();
}
