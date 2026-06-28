package pl.bajty.teryt.api;

import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.Makroregion;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.enums.RodzajKatalogu;
import pl.bajty.teryt.model.enums.RodzajRaportu;
import pl.bajty.teryt.model.interfaces.Slownik;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Interfejs klienta usługi TERYT (Krajowy Rejestr Urzędowy Podziału Terytorialnego Kraju).
 * Zapewnia dostęp do danych o podziale terytorialnym Polski, miejscowościach i ulicach.
 */
public interface TerytClient {

    // ==========================================
    // 1. Autoryzacja i diagnostyka
    // ==========================================

    /**
     * Sprawdza, czy klient jest aktualnie zalogowany do usługi TERYT.
     *
     * @return true, jeśli sesja jest aktywna; false w przeciwnym razie.
     */
    boolean isLoggedIn();

    // ==========================================
    // 2. Obsługa plików katalogowych i zmianowych
    // ==========================================

    /**
     * Pobiera datę ostatniej aktualizacji określonego katalogu.
     *
     * @param type Rodzaj katalogu (np. TERC, SIMC, ULIC).
     * @return Data aktualizacji katalogu.
     */
    LocalDate getCatalogDate(RodzajKatalogu type);

    /**
     * Pobiera pełny plik katalogu o podanym rodzaju (zawartość zakodowana w Base64).
     *
     * @param type Rodzaj katalogu.
     * @return Obiekt zawierający dane pliku katalogu.
     */
    PlikKatalogu downloadCatalogFile(RodzajKatalogu type);

    /**
     * Pobiera pełny plik katalogu o podanym rodzaju (zawartość rozkodowana).
     *
     * @param type Rodzaj katalogu.
     * @return Obiekt zawierający rozkodowane dane pliku katalogu.
     */
    DanePliku downloadCatalogFileData(RodzajKatalogu type);

    /**
     * Pobiera plik zmian dla podanego katalogu w określonym przedziale czasowym (zawartość zakodowana w Base64).
     *
     * @param type    Rodzaj katalogu.
     * @param stanOd Początek przedziału czasowego.
     * @param stanDo Koniec przedziału czasowego.
     * @return Obiekt zawierający dane pliku zmian.
     */
    PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo);

    /**
     * Pobiera plik zmian dla podanego katalogu w określonym przedziale czasowym (zawartość rozkodowana).
     *
     * @param type    Rodzaj katalogu.
     * @param stanOd Początek przedziału czasowego.
     * @param stanDo Koniec przedziału czasowego.
     * @return Obiekt zawierający rozkodowane dane pliku zmian.
     */
    DanePliku downloadZmianyFileData(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo);

    /**
     * Pobiera listę plików zmian dla podanego katalogu w określonym przedziale czasowym.
     *
     * @param rodzajKatalogu Rodzaj katalogu.
     * @param stanOd         Początek przedziału czasowego.
     * @param stanDo         Koniec przedziału czasowego.
     * @return Lista obiektów informacyjnych o plikach zmian.
     */
    List<PlikZmiany> getPlikZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo);

    /**
     * Pobiera szczegółową listę zmian (rekordów) dla podanego katalogu i zakresu dat.
     *
     * @param <T>             Typ obiektu danych w zmianie.
     * @param rodzajKatalogu Rodzaj katalogu.
     * @param stanOd         Początek przedziału czasowego.
     * @param stanDo         Koniec przedziału czasowego.
     * @return Lista obiektów reprezentujących poszczególne zmiany.
     */
    <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo);

    // ==========================================
    // 3. Przeglądanie struktury podziału (TERC)
    // ==========================================

    // Województwa

    /**
     * Pobiera listę wszystkich województw aktualną obecnie.
     *
     * @return Lista województw.
     */
    List<Wojewodztwo> getWojewodztwa();

    /**
     * Pobiera listę województw aktualną na podany dzień.
     *
     * @param stanNa Data, na którą ma zostać zwrócony stan danych.
     * @return Lista województw.
     */
    List<Wojewodztwo> getWojewodztwa(LocalDate stanNa);

    /**
     * Pobiera listę województw należących do danego regionu statystycznego.
     *
     * @param region  Region statystyczny.
     * @param stanNa Data, na którą ma zostać zwrócony stan danych.
     * @return Lista województw w regionie.
     */
    List<Wojewodztwo> getWojewodztwa(Region region, LocalDate stanNa);

    /**
     * Pobiera dane pojedynczego województwa o podanym identyfikatorze TERC.
     *
     * @param id Identyfikator TERC województwa (2 cyfry).
     * @return Optional zawierający województwo lub pusty, jeśli nie znaleziono lub kod jest niepoprawny.
     */
    Optional<Wojewodztwo> getWojewodztwo(String id);

    /**
     * Pobiera dane pojedynczego województwa o podanym identyfikatorze TERC.
     *
     * @param id Identyfikator TERC województwa.
     * @return Optional zawierający województwo lub pusty, jeśli nie znaleziono.
     */
    Optional<Wojewodztwo> getWojewodztwo(Terc id);

    // Powiaty

    /**
     * Pobiera listę wszystkich powiatów.
     *
     * @return Lista powiatów.
     */
    List<Powiat> getPowiaty();

    /**
     * Pobiera listę powiatów aktualną na podany dzień.
     *
     * @param stanNa Data stanu danych.
     * @return Lista powiatów.
     */
    List<Powiat> getPowiaty(LocalDate stanNa);

    /**
     * Pobiera listę powiatów w ramach konkretnego województwa.
     *
     * @param wojewodztwo Obiekt województwa.
     * @param stanNa      Data stanu danych.
     * @return Lista powiatów w województwie.
     */
    List<Powiat> getPowiaty(Wojewodztwo wojewodztwo, LocalDate stanNa);

    /**
     * Pobiera listę powiatów w ramach województwa o podanym identyfikatorze TERC.
     *
     * @param wojewodztwoId Identyfikator TERC województwa.
     * @param stanNa         Data stanu danych.
     * @return Lista powiatów.
     */
    List<Powiat> getPowiaty(Terc wojewodztwoId, LocalDate stanNa);

    /**
     * Pobiera listę powiatów należących do danego podregionu statystycznego.
     *
     * @param podregion Obiekt podregionu.
     * @param stanNa    Data stanu danych.
     * @return Lista powiatów w podregionie.
     */
    List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa);

    /**
     * Pobiera listę powiatów należących do podregionu o podanym identyfikatorze.
     *
     * @param podregionId Identyfikator podregionu.
     * @param stanNa      Data stanu danych.
     * @return Lista powiatów.
     */
    List<Powiat> getPowiaty(String podregionId, LocalDate stanNa);

    /**
     * Pobiera dane pojedynczego powiatu o podanym identyfikatorze TERC.
     *
     * @param id Identyfikator TERC powiatu (4 cyfry).
     * @return Optional zawierający powiat lub pusty, jeśli nie znaleziono lub kod jest niepoprawny.
     */
    Optional<Powiat> getPowiat(String id);

    /**
     * Pobiera dane pojedynczego powiatu o podanym identyfikatorze TERC.
     *
     * @param id Identyfikator TERC powiatu.
     * @return Optional zawierający powiat lub pusty, jeśli nie znaleziono.
     */
    Optional<Powiat> getPowiat(Terc id);

    // Gminy

    /**
     * Pobiera listę wszystkich gmin.
     *
     * @return Lista gmin.
     */
    List<Gmina> getGminy();

    /**
     * Pobiera listę gmin aktualną na podany dzień.
     *
     * @param stanNa Data stanu danych.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(LocalDate stanNa);

    /**
     * Pobiera listę gmin w województwie na podany dzień.
     *
     * @param wojewodztwo Obiekt województwa.
     * @param stanNa      Data stanu danych.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa);

    /**
     * Pobiera listę gmin w województwie (stan aktualny).
     *
     * @param wojewodztwo Obiekt województwa.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Wojewodztwo wojewodztwo);

    /**
     * Pobiera listę gmin w województwie o podanym ID na podany dzień.
     *
     * @param wojewodztwoId ID województwa.
     * @param stanNa         Data stanu danych.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa);

    /**
     * Pobiera listę gmin w województwie o podanym ID (stan aktualny).
     *
     * @param wojewodztwoId ID województwa.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Terc wojewodztwoId);

    /**
     * Pobiera listę gmin w danym powiecie na podany dzień.
     *
     * @param powiat Obiekt powiatu.
     * @param stanNa Data stanu danych.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Powiat powiat, LocalDate stanNa);

    /**
     * Pobiera listę gmin w danym powiecie (stan aktualny).
     *
     * @param powiat Obiekt powiatu.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Powiat powiat);

    /**
     * Pobiera listę gmin w powiecie i województwie o podanych identyfikatorach.
     *
     * @param powiatId      ID powiatu.
     * @param wojewodztwoId ID województwa.
     * @param stanNa         Data stanu danych.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId, LocalDate stanNa);

    /**
     * Pobiera listę gmin w powiecie i województwie o podanych identyfikatorach (stan aktualny).
     *
     * @param powiatId      ID powiatu.
     * @param wojewodztwoId ID województwa.
     * @return Lista gmin.
     */
    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId);

    /**
     * Pobiera dane pojedynczej gminy o podanym identyfikatorze TERC.
     *
     * @param id Identyfikator TERC gminy (7 cyfr).
     * @return Optional zawierający gminę lub pusty, jeśli nie znaleziono lub kod jest niepoprawny.
     */
    Optional<Gmina> getGmina(String id);

    /**
     * Pobiera dane pojedynczej gminy o podanym identyfikatorze TERC.
     *
     * @param id Identyfikator TERC gminy.
     * @return Optional zawierający gminę lub pusty, jeśli nie znaleziono.
     */
    Optional<Gmina> getGmina(Terc id);

    // ==========================================
    // 4. Miejscowości i Ulice (SIMC / ULIC)
    // ==========================================

    // Miejscowości

    /**
     * Pobiera listę miejscowości w danej gminie.
     *
     * @param gmina Obiekt gminy.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Gmina gmina);

    /**
     * Pobiera listę miejscowości w gminie na podany dzień.
     *
     * @param gmina  Obiekt gminy.
     * @param stanNa Data stanu danych.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa);

    /**
     * Pobiera listę miejscowości w gminie z opcją pobrania pełnych symboli.
     *
     * @param gmina      Obiekt gminy.
     * @param zSymbolem Czy dołączyć pełne symbole.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Gmina gmina, boolean zSymbolem);

    /**
     * Pobiera listę miejscowości w gminie na podany dzień z opcją pobrania pełnych symboli.
     *
     * @param gmina      Obiekt gminy.
     * @param stanNa     Data stanu danych.
     * @param zSymbolem Czy dołączyć pełne symbole.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa, boolean zSymbolem);

    /**
     * Pobiera listę miejscowości w gminie o podanym identyfikatorze TERC.
     *
     * @param gminaId ID gminy.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Terc gminaId);

    /**
     * Pobiera listę miejscowości w gminie o podanym ID na dany dzień.
     *
     * @param gminaId ID gminy.
     * @param stanNa  Data stanu danych.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa);

    /**
     * Pobiera listę miejscowości w gminie o podanym ID z opcją pobrania symboli.
     *
     * @param gminaId   ID gminy.
     * @param zSymbolem Czy dołączyć symbole.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Terc gminaId, boolean zSymbolem);

    /**
     * Pobiera listę miejscowości w gminie o podanym ID na dany dzień z opcją symboli.
     *
     * @param gminaId   ID gminy.
     * @param stanNa    Data stanu danych.
     * @param zSymbolem Czy dołączyć symbole.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa, boolean zSymbolem);

    /**
     * Pobiera miejscowości przefiltrowane przez rodzaj gminy.
     *
     * @param rodzajGminy Rodzaj gminy.
     * @param stanNa      Data stanu danych.
     * @return Lista miejscowości.
     */
    List<Miejscowosc> getMiejscowosci(RodzajGminy rodzajGminy, LocalDate stanNa);

    /**
     * Pobiera dane pojedynczej miejscowości o podanym identyfikatorze SIMC.
     *
     * @param id Identyfikator SIMC miejscowości (7 cyfr).
     * @return Optional zawierający miejscowość lub pusty, jeśli nie znaleziono lub kod jest niepoprawny.
     */
    Optional<Miejscowosc> getMiejscowosc(String id);

    /**
     * Pobiera dane pojedynczej miejscowości o podanym identyfikatorze SIMC.
     *
     * @param id Identyfikator SIMC miejscowości.
     * @return Optional zawierający miejscowość lub pusty, jeśli nie znaleziono.
     */
    Optional<Miejscowosc> getMiejscowosc(Simc id);

    /**
     * Pobiera dane pojedynczej miejscowości o podanym identyfikatorze SIMC na dany dzień.
     *
     * @param id      Identyfikator SIMC miejscowości.
     * @param stanNa  Data stanu danych.
     * @return Optional zawierający miejscowość lub pusty, jeśli nie znaleziono.
     */
    Optional<Miejscowosc> getMiejscowosc(Simc id, LocalDate stanNa);

    // Ulice

    /**
     * Pobiera listę ulic w danej miejscowości na podany dzień.
     *
     * @param miejscowosc Obiekt miejscowości.
     * @param stanNa      Data stanu danych.
     * @return Lista ulic.
     */
    List<Ulica> getUlice(Miejscowosc miejscowosc, LocalDate stanNa);

    /**
     * Pobiera listę ulic w miejscowości o podanym identyfikatorze SIMC.
     *
     * @param miejscowoscId Symbol SIMC miejscowości.
     * @param stanNa         Data stanu danych.
     * @return Lista ulic.
     */
    List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa);

    /**
     * Pobiera dane pojedynczej ulicy o podanych identyfikatorach.
     *
     * @param id            Identyfikator ULIC ulicy (5 cyfr).
     * @param miejscowoscId Identyfikator SIMC miejscowości (7 cyfr).
     * @return Optional zawierający ulicę lub pusty, jeśli nie znaleziono lub kody są niepoprawne.
     */
    Optional<Ulica> getUlica(String id, String miejscowoscId);

    /**
     * Pobiera dane pojedynczej ulicy o podanych identyfikatorach.
     *
     * @param id            Identyfikator ULIC ulicy.
     * @param miejscowoscId Identyfikator SIMC miejscowości.
     * @return Optional zawierający ulicę lub pusty, jeśli nie znaleziono.
     */
    Optional<Ulica> getUlica(Ulic id, Simc miejscowoscId);

    /**
     * Pobiera dane pojedynczej ulicy o podanych identyfikatorach na dany dzień.
     *
     * @param id            Identyfikator ULIC ulicy.
     * @param miejscowoscId Identyfikator SIMC miejscowości.
     * @param stanNa        Data stanu danych.
     * @return Optional zawierający ulicę lub pusty, jeśli nie znaleziono.
     */
    Optional<Ulica> getUlica(Ulic id, Simc miejscowoscId, LocalDate stanNa);

    // ==========================================
    // 5. Podział statystyczny (NUTS / KTS)
    // ==========================================

    // Podregiony (NUTS 3)

    /**
     * Pobiera listę podregionów (NUTS 3) w województwie.
     *
     * @param wojewodztwo Obiekt województwa.
     * @param stanNa      Data stanu danych.
     * @return Lista podregionów.
     */
    List<Podregion> getPodregiony(Wojewodztwo wojewodztwo, LocalDate stanNa);

    /**
     * Pobiera listę podregionów (NUTS 3) w województwie o podanym ID.
     *
     * @param wojewodztwoId ID województwa.
     * @param stanNa         Data stanu danych.
     * @return Lista podregionów.
     */
    List<Podregion> getPodregiony(Terc wojewodztwoId, LocalDate stanNa);

    // Regiony (NUTS 2)

    /**
     * Pobiera listę regionów (NUTS 2) aktualną na podany dzień.
     *
     * @param stanNa Data stanu danych.
     * @return Lista regionów.
     */
    List<Region> getRegiony(LocalDate stanNa);

    // Makroregiony (NUTS 1)

    /**
     * Pobiera makroregion (NUTS 1), do którego należy podane województwo.
     *
     * @param wojewodztwo Obiekt województwa.
     * @return Obiekt makroregionu.
     */
    Makroregion getMakroregion(Wojewodztwo wojewodztwo);

    /**
     * Pobiera makroregion (NUTS 1) dla województwa o podanym identyfikatorze.
     *
     * @param wojewodztwoId ID województwa.
     * @return Obiekt makroregionu.
     */
    Makroregion getMakroregion(Terc wojewodztwoId);

    // ==========================================
    // 6. Raporty i stany
    // ==========================================

    /**
     * Pobiera aktualny stan katalogu miejscowości (SIMC).
     *
     * @return Lista obiektów stanu SIMC.
     */
    List<StanSimc> getStanSimc();

    /**
     * Pobiera stan katalogu TERC na podany dzień (zawartość zakodowana w Base64).
     *
     * @param stanNa Data stanu danych.
     * @return Obiekt zawierający dane katalogu TERC.
     */
    PlikKatalogu getStanTerc(LocalDate stanNa);

    /**
     * Pobiera stan katalogu TERC na podany dzień (zawartość rozkodowana).
     *
     * @param stanNa Data stanu danych.
     * @return Obiekt zawierający rozkodowane dane katalogu TERC.
     */
    DanePliku getStanTercData(LocalDate stanNa);

    /**
     * Pobiera aktualny stan katalogu ulic (ULIC).
     *
     * @return Lista obiektów stanu ULIC.
     */
    List<StanUlic> getStanUlic();

    /**
     * Pobiera identyfikator raportu o podanym rodzaju.
     *
     * @param rodzajRaportu Rodzaj raportu.
     * @return ID raportu.
     */
    Integer getRaport(RodzajRaportu rodzajRaportu);

    // ==========================================
    // 7. Wyszukiwanie (Search)
    // ==========================================

    /**
     * Wyszukuje miejscowości po nazwie.
     *
     * @param nazwa Nazwa miejscowości.
     * @return Lista pasujących miejscowości.
     */
    List<Miejscowosc> wyszukajMiejscowosc(String nazwa);

    /**
     * Pobiera dane miejscowości o podanym identyfikatorze TERC (kodzie jednostki).
     *
     * @param id ID jednostki terytorialnej.
     * @return Lista miejscowości (zazwyczaj jedna lub pusta).
     */
    List<Miejscowosc> wyszukajMiejscowosc(Terc id);

    /**
     * Wyszukuje miejscowości po nazwie w obrębie jednostki o podanym ID.
     *
     * @param nazwa Nazwa miejscowości.
     * @param id    ID jednostki terytorialnej (np. gminy).
     * @return Lista pasujących miejscowości.
     */
    List<Miejscowosc> wyszukajMiejscowosc(String nazwa, Terc id);

    /**
     * Wyszukuje ulice po nazwie.
     *
     * @param nazwa Nazwa ulicy.
     * @return Lista pasujących ulic.
     */
    List<Ulica> wyszukajUlice(String nazwa);

    /**
     * Pobiera dane ulicy o podanym identyfikatorze ULIC.
     *
     * @param id Symbol ULIC.
     * @return Lista ulic.
     */
    List<Ulica> wyszukajUlice(Ulic id);

    /**
     * Wyszukuje ulice po nazwie w obrębie jednostki o podanym ID.
     *
     * @param nazwa Nazwa ulicy.
     * @param id    ID jednostki terytorialnej.
     * @return Lista pasujących ulic.
     */
    List<Ulica> wyszukajUlice(String nazwa, Terc id);

    // ==========================================
    // 8. Weryfikacja adresów (Nowość)
    // ==========================================

    /**
     * Weryfikuje poprawność adresu dla podanej nazwy miejscowości.
     *
     * @param nazwaMiejscowosci Nazwa miejscowości do weryfikacji.
     * @return Lista zweryfikowanych adresów.
     */
    List<ZweryfikowanyAdres> weryfikujAdresDlaMiejscowosci(String nazwaMiejscowosci);

    /**
     * Weryfikuje poprawność adresu w konkretnej miejscowości określonej przez symbol SIMC.
     *
     * @param nazwaMiejscowosci Nazwa miejscowości.
     * @param symMiejscowosci   Symbol SIMC miejscowości.
     * @return Lista zweryfikowanych adresów.
     */
    List<ZweryfikowanyAdres> weryfikujAdresWMiejscowosci(String nazwaMiejscowosci, Simc symMiejscowosci);

    /**
     * Weryfikuje adres na podstawie nazwy ulicy i miejscowości.
     *
     * @param nazwaUlicy        Nazwa ulicy.
     * @param nazwaMiejscowosci Nazwa miejscowości.
     * @return Lista zweryfikowanych adresów.
     */
    List<ZweryfikowanyAdres> weryfikujAdresDlaUlic(String nazwaUlicy, String nazwaMiejscowosci);

    // ==========================================
    // 9. Słowniki pomocnicze
    // ==========================================

    /**
     * Pobiera słownik rodzajów gmin.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikRodzajowGmin();

    /**
     * Pobiera słownik poziomów jednostek terytorialnych.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikPoziomowJednostekTerytorialnych();

    /**
     * Pobiera słownik rodzajów miejscowości.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikRodzajowMiejscowosci();

    /**
     * Pobiera słownik rodzajów raportów.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikRodzajowRaportow();

    /**
     * Pobiera słownik rodzajów powiatów.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikRodzajowPowiatow();

    /**
     * Pobiera słownik rodzajów katalogów.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikRodzajowKatalogow();

    /**
     * Pobiera słownik makroregionów.
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikMakroregionow();

    /**
     * Pobiera słownik cech dla ulic (ULIC).
     *
     * @return Lista elementów słownika.
     */
    List<Slownik> getSlownikCechULIC();

    // ==========================================
    // 10. Aktualizacja EMUiA (Poprawione sygnatury)
    // ==========================================

    /**
     * Aktualizuje punkt adresowy w systemie EMUiA.
     *
     * @param punktAdresowy Obiekt punktu adresowego.
     * @throws UnsupportedOperationException Zawsze, ponieważ funkcja czeka na implementację.
     */
    void updateEMUiAAddressPoint(PunktAdresowy punktAdresowy);

    /**
     * Aktualizuje dane o ulicy/placu w systemie EMUiA.
     *
     * @param placUlica Obiekt ulicy/placu.
     * @throws UnsupportedOperationException Zawsze, ponieważ funkcja czeka na implementację.
     */
    void updateEMUiAStreet(PlacUlica placUlica);
}