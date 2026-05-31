package pl.bajty.teryt.api;

import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.enums.RodzajKatalogu;
import pl.bajty.teryt.model.enums.RodzajRaportu;
import pl.bajty.teryt.model.interfaces.Slownik;

import java.time.LocalDate;
import java.util.List;

public interface TerytClient {

    // ==========================================
    // 1. Autoryzacja i diagnostyka
    // ==========================================
    boolean isLoggedIn();

    // ==========================================
    // 2. Obsługa plików katalogowych i zmianowych
    // ==========================================

    LocalDate getCatalogDate(RodzajKatalogu type);

    PlikKatalogu downloadCatalogFile(RodzajKatalogu type);

    PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo);

    List<PlikZmiany> getPlikZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo);

    <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo);

    // ==========================================
    // 3. Przeglądanie struktury podziału (TERC)
    // ==========================================

    // Województwa
    List<Wojewodztwo> getWojewodztwa();

    List<Wojewodztwo> getWojewodztwa(LocalDate stanNa);

    List<Wojewodztwo> getWojewodztwa(Region region, LocalDate stanNa);

    // Powiaty
    List<Powiat> getPowiaty();

    List<Powiat> getPowiaty(LocalDate stanNa);

    List<Powiat> getPowiaty(Wojewodztwo wojewodztwo, LocalDate stanNa);

    List<Powiat> getPowiaty(Terc wojewodztwoId, LocalDate stanNa);

    List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa);

    List<Powiat> getPowiaty(String podregionId, LocalDate stanNa);

    // Gminy
    List<Gmina> getGminy();

    List<Gmina> getGminy(LocalDate stanNa);

    List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa);

    List<Gmina> getGminy(Wojewodztwo wojewodztwo);

    List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa);

    List<Gmina> getGminy(Terc wojewodztwoId);

    List<Gmina> getGminy(Powiat powiat, LocalDate stanNa);

    List<Gmina> getGminy(Powiat powiat);

    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId, LocalDate stanNa);

    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId);

    // ==========================================
    // 4. Miejscowości i Ulice (SIMC / ULIC)
    // ==========================================

    // Miejscowości
    List<Miejscowosc> getMiejscowosci(Gmina gmina);

    List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa);

    List<Miejscowosc> getMiejscowosci(Gmina gmina, boolean zSymbolem);

    List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa, boolean zSymbolem);

    List<Miejscowosc> getMiejscowosci(Terc gminaId);

    List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa);

    List<Miejscowosc> getMiejscowosci(Terc gminaId, boolean zSymbolem);

    List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa, boolean zSymbolem);

    List<Miejscowosc> getMiejscowosci(RodzajGminy rodzajGminy, LocalDate stanNa);

    // Ulice
    List<Ulica> getUlice(Miejscowosc miejscowosc, LocalDate stanNa);

    List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa);

    // ==========================================
    // 5. Podział statystyczny (NUTS / KTS)
    // ==========================================

    // Podregiony (NUTS 3)
    List<Podregion> getPodregiony(Wojewodztwo wojewodztwo, LocalDate stanNa);

    List<Podregion> getPodregiony(Terc wojewodztwoId, LocalDate stanNa);

    // Regiony (NUTS 2)
    List<Region> getRegiony(LocalDate stanNa);

    // Makroregiony (NUTS 1)
    Makroregion getMakroregion(Wojewodztwo wojewodztwo);

    Makroregion getMakroregion(Terc wojewodztwoId);

    // ==========================================
    // 6. Raporty i stany
    // ==========================================
    List<StanSimc> getStanSimc();

    PlikKatalogu getStanTerc(LocalDate stanNa);

    List<StanUlic> getStanUlic(LocalDate stanNa);

    Integer getRaport(RodzajRaportu rodzajRaportu);

    // ==========================================
    // 7. Wyszukiwanie (Search)
    // ==========================================
    List<Miejscowosc> wyszukajMiejscowosc(String nazwa);

    List<Miejscowosc> wyszukajMiejscowosc(Terc id);

    List<Miejscowosc> wyszukajMiejscowosc(String nazwa, Terc id);

    List<Ulica> wyszukajUlice(String nazwa);

    List<Ulica> wyszukajUlice(Ulic id);

    List<Ulica> wyszukajUlice(String nazwa, Terc id);

    // ==========================================
    // 8. Weryfikacja adresów (Nowość)
    // ==========================================
    List<ZweryfikowanyAdres> weryfikujAdresDlaMiejscowosci(String nazwaMiejscowosci);

    List<ZweryfikowanyAdres> weryfikujAdresWMiejscowosci(String nazwaMiejscowosci, Simc symMiejscowosci);

    List<ZweryfikowanyAdres> weryfikujAdresDlaUlic(String nazwaUlicy, String nazwaMiejscowosci);

    // ==========================================
    // 9. Słowniki pomocnicze
    // ==========================================
    List<Slownik> getSlownikRodzajowGmin();

    List<Slownik> getSlownikPoziomowJednostekTerytorialnych();

    List<Slownik> getSlownikRodzajowMiejscowosci();

    List<Slownik> getSlownikRodzajowRaportow();

    List<Slownik> getSlownikRodzajowPowiatow();

    List<Slownik> getSlownikRodzajowKatalogow();

    List<Slownik> getSlownikMakroregionow();

    List<Slownik> getSlownikCechULIC();

    // ==========================================
    // 10. Aktualizacja EMUiA (Poprawione sygnatury)
    // ==========================================
    void updateEMUiAAddressPoint(PunktAdresowy punktAdresowy);

    void updateEMUiAStreet(PlacUlica placUlica);
}