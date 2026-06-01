package pl.bajty.teryt.model.interfaces;

import pl.bajty.teryt.model.dto.Terc;
import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;

/**
 * Interfejs reprezentujący jednostkę podziału terytorialnego kraju.
 */
public interface JednostkaTerytorialna {
    /**
     * Zwraca identyfikator jednostki terytorialnej (TERC).
     *
     * @return identyfikator TERC
     */
    Terc id();

    /**
     * Zwraca nazwę jednostki terytorialnej.
     *
     * @return nazwa jednostki
     */
    String nazwa();

    /**
     * Zwraca poziom jednostki w hierarchii podziału terytorialnego.
     *
     * @return poziom jednostki terytorialnej
     */
    PoziomJednostkiTerytorialnej poziomJednostkiTerytorialnej();
}
