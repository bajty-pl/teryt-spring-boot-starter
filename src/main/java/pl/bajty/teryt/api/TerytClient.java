package pl.bajty.teryt.api;

import pl.bajty.teryt.internal.soap.generated.Miejscowosc;
import pl.bajty.teryt.internal.soap.generated.Ulica;
import pl.bajty.teryt.model.*;

import javax.swing.plaf.synth.Region;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public interface TerytClient {
    // Auth
    boolean isLoggedIn();

    // Updates
    void updateEMUiAAddressPoint();

    void updateEMUiAStreet();

    // Trivia
    String triviaSimc();

    String triviaTerc();

    String triviaUlic();

    // Catalogs
    LocalDate getCurrentDate(RodzajKatalogu type);

    File downloadCatalogFile(RodzajKatalogu type);

    File downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo);

    // Gminy
    List<Gmina> getGminy(LocalDate stanNa);

    List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa);

    List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa);

    List<Gmina> getGminy(Powiat powiat, LocalDate stanNa);

    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId, LocalDate stanNa);

    // Miejscowości
    List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa);

    List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa, boolean zSymbolem);

    List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa);

    List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa, boolean zSymbolem);

    List<Miejscowosc> getMiejscowosci(RodzajGminy rodzajGminy, LocalDate stanNa);

    // Podregiony
    List<Podregion> getPodregiony(Gmina gmina, LocalDate stanNa);

    // Powiaty
    List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa);

    List<Powiat> getPowiaty(String podregionId, LocalDate stanNa);

    // Regiony
    List<Region> getRegiony(LocalDate stanNa);

    // Stany
    List<StanSimc> getStanSimc(LocalDate stanNa);

    List<StanTerc> getStanTerc(LocalDate stanNa);

    List<StanUlic> getStanUlic(LocalDate stanNa);

    // Ulice
    List<Ulica> getUlice(Miejscowosc miejscowosc, LocalDate stanNa);

    List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa);

    // Województwa
    List<Wojewodztwo> getWojewodztwa(LocalDate date);

    List<Wojewodztwo> getWojewodztwa(Region region, LocalDate date);

    // Raporty
    Integer getRaport(RodzajRaportu rodzajRaportu);

    // Zmiany
    <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo);

    // Weryfikacja
    boolean verify(String code);
}
