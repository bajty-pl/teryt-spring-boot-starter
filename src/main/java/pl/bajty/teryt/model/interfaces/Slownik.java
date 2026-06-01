package pl.bajty.teryt.model.interfaces;

/**
 * Interfejs reprezentujący wpis w słowniku systemowym TERYT.
 */
public interface Slownik {

    /**
     * Zwraca kod elementu słownikowego.
     *
     * @return kod elementu
     */
    String getKod();

    /**
     * Zwraca nazwę elementu słownikowego.
     *
     * @return nazwa elementu
     */
    String getNazwa();

}
