package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import pl.bajty.teryt.api.TerytClient;
import pl.bajty.teryt.model.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
class TerytClientImpl implements TerytClient {
    private final WebServiceTemplate webServiceTemplate;

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public LocalDate getCurrentDate(RodzajKatalogu type) {
        return null;
    }

    @Override
    public PlikKatalogu downloadCatalogFile(RodzajKatalogu type) {
        return null;
    }

    @Override
    public PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

    @Override
    public List<PlikZmiany> getPlikZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return List.of();
    }

    @Override
    public <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return List.of();
    }

    @Override
    public List<Wojewodztwo> getWojewodztwa() {
        return List.of();
    }

    @Override
    public List<Wojewodztwo> getWojewodztwa(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Wojewodztwo> getWojewodztwa(Region region, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Powiat> getPowiaty() {
        return List.of();
    }

    @Override
    public List<Powiat> getPowiaty(LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Powiat> getPowiaty(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Powiat> getPowiaty(Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Powiat> getPowiaty(String podregionId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy() {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Wojewodztwo wojewodztwo) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Terc wojewodztwoId) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Powiat powiat, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Powiat powiat) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina, boolean zSymbolem) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa, boolean zSymbolem) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId, boolean zSymbolem) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa, boolean zSymbolem) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(RodzajGminy rodzajGminy, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Ulica> getUlice(Miejscowosc miejscowosc, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Podregion> getPodregiony(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Podregion> getPodregiony(Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<Region> getRegiony(LocalDate stanNa) {
        return List.of();
    }

    @Override
    public Makroregion getMakroregion(Wojewodztwo wojewodztwo) {
        return null;
    }

    @Override
    public Makroregion getMakroregion(Terc wojewodztwoId) {
        return null;
    }

    @Override
    public List<StanSimc> getStanSimc(LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<StanTerc> getStanTerc(LocalDate stanNa) {
        return List.of();
    }

    @Override
    public List<StanUlic> getStanUlic(LocalDate stanNa) {
        return List.of();
    }

    @Override
    public Integer getRaport(RodzajRaportu rodzajRaportu) {
        return 0;
    }

    @Override
    public List<Miejscowosc> wyszukajMiejscowosc(String nazwa) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> wyszukajMiejscowosc(Terc id) {
        return List.of();
    }

    @Override
    public List<Miejscowosc> wyszukajMiejscowosc(String nazwa, Terc id) {
        return List.of();
    }

    @Override
    public List<Ulica> wyszukajUlice(String nazwa) {
        return List.of();
    }

    @Override
    public List<Ulica> wyszukajUlice(Ulic id) {
        return List.of();
    }

    @Override
    public List<Ulica> wyszukajUlice(String nazwa, Terc id) {
        return List.of();
    }

    @Override
    public List<ZweryfikowanyAdres> weryfikujAdresDlaMiejscowosci(String nazwaMiejscowosci) {
        return List.of();
    }

    @Override
    public List<ZweryfikowanyAdres> weryfikujAdresWMiejscowosci(String nazwaMiejscowosci, Simc symMiejscowosci) {
        return List.of();
    }

    @Override
    public List<ZweryfikowanyAdres> weryfikujAdresDlaUlic(String nazwaUlicy, String nazwaMiejscowosci) {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikRodzajowGmin() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikPoziomowJednostekTerytorialnych() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikRodzajowMiejscowosci() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikRodzajowRaportow() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikRodzajowPowiatow() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikRodzajowKatalogow() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikMakroregionow() {
        return List.of();
    }

    @Override
    public List<Slownik> getSlownikCechULIC() {
        return List.of();
    }

    @Override
    public void updateEMUiAAddressPoint(PunktAdresowy punktAdresowy) {

    }

    @Override
    public void updateEMUiAStreet(PlacUlica placUlica) {

    }
}
