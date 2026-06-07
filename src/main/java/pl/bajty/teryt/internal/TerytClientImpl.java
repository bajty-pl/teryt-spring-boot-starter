package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import pl.bajty.teryt.api.TerytClient;
import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.Makroregion;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.enums.RodzajKatalogu;
import pl.bajty.teryt.model.enums.RodzajRaportu;
import pl.bajty.teryt.model.interfaces.Slownik;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TerytClientImpl implements TerytClient {
    private final AuthService authService;
    private final TercService tercService;
    private final SimcService simcService;
    private final UlicService ulicService;
    private final VerifyService verifyService;
    private final FilesService filesService;
    private final DictionaryService dictionaryService;
    private final RegionService regionService;

    @Override
    public boolean isLoggedIn() {
        return authService.isLoggedIn();
    }

    @Override
    public LocalDate getCatalogDate(RodzajKatalogu type) {
        return filesService.getCatalogDate(type);
    }

    @Override
    public DanePliku downloadCatalogFileData(RodzajKatalogu type) {
        return DanePliku.from(downloadCatalogFile(type));
    }

    @Override
    public PlikKatalogu downloadCatalogFile(RodzajKatalogu type) {
        return filesService.downloadCatalogFile(type);
    }

    @Override
    public DanePliku downloadZmianyFileData(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo) {
        return DanePliku.from(downloadZmianyFile(type, stanOd, stanDo));
    }

    @Override
    public PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo) {
        return filesService.downloadZmianyFile(type, stanOd, stanDo);
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
        return tercService.getWojewodztwa(LocalDate.now());
    }

    @Override
    public List<Wojewodztwo> getWojewodztwa(LocalDate date) {
        return tercService.getWojewodztwa(date);
    }

    @Override
    public List<Wojewodztwo> getWojewodztwa(Region region, LocalDate stanNa) {
        return tercService.getWojewodztwa(region, stanNa);
    }

    @Override
    public Optional<Wojewodztwo> getWojewodztwo(Terc id) {
        return tercService.getWojewodztwa(LocalDate.now()).stream()
                .filter(w -> w.id().value().equals(id.value()))
                .findFirst();
    }

    @Override
    public List<Powiat> getPowiaty() {
        return tercService.getPowiaty();
    }

    @Override
    public List<Powiat> getPowiaty(LocalDate stanNa) {
        return tercService.getPowiaty(stanNa);
    }

    @Override
    public List<Powiat> getPowiaty(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return tercService.getPowiaty(wojewodztwo, stanNa);
    }

    @Override
    public List<Powiat> getPowiaty(Terc wojewodztwoId, LocalDate stanNa) {
        return tercService.getPowiaty(wojewodztwoId, stanNa);
    }

    @Override
    public List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa) {
        return tercService.getPowiaty(podregion, stanNa);
    }

    @Override
    public List<Powiat> getPowiaty(String podregionId, LocalDate stanNa) {
        return tercService.getPowiaty(podregionId, stanNa);
    }

    @Override
    public Optional<Powiat> getPowiat(Terc id) {
        return tercService.getPowiaty(id.getParentId(), LocalDate.now()).stream()
                .filter(p -> p.id().value().equals(id.value()))
                .findFirst();
    }

    @Override
    public List<Gmina> getGminy() {
        return tercService.getGminy();
    }

    @Override
    public List<Gmina> getGminy(LocalDate stanNa) {
        return tercService.getGminy(stanNa);
    }

    @Override
    public List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return tercService.getGminy(wojewodztwo, stanNa);
    }

    @Override
    public List<Gmina> getGminy(Wojewodztwo wojewodztwo) {
        return tercService.getGminy(wojewodztwo);
    }

    @Override
    public List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa) {
        return tercService.getGminy(wojewodztwoId, stanNa);
    }

    @Override
    public List<Gmina> getGminy(Terc wojewodztwoId) {
        return tercService.getGminy(wojewodztwoId);
    }

    @Override
    public List<Gmina> getGminy(Powiat powiat, LocalDate stanNa) {
        return tercService.getGminy(powiat, stanNa);
    }

    @Override
    public List<Gmina> getGminy(Powiat powiat) {
        return tercService.getGminy(powiat);
    }

    @Override
    public List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId, LocalDate stanNa) {
        return tercService.getGminy(wojewodztwoId, powiatId, stanNa);
    }

    @Override
    public List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId) {
        return tercService.getGminy(powiatId, wojewodztwoId);
    }

    @Override
    public Optional<Gmina> getGmina(Terc id) {
        return tercService.getGminy(id.getWojewodztwoTerc(), id.getPowiatTerc(), LocalDate.now()).stream()
                .filter(g -> g.id().value().equals(id.value()))
                .findFirst();
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina) {
        return simcService.getMiejscowosci(gmina);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa) {
        return simcService.getMiejscowosci(gmina, stanNa);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina, boolean zSymbolem) {
        return simcService.getMiejscowosci(gmina, zSymbolem);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa, boolean zSymbolem) {
        return simcService.getMiejscowosci(gmina, stanNa, zSymbolem);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId) {
        return simcService.getMiejscowosci(gminaId);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa) {
        return simcService.getMiejscowosci(gminaId, stanNa);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId, boolean zSymbolem) {
        return simcService.getMiejscowosci(gminaId, zSymbolem);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa, boolean zSymbolem) {
        return simcService.getMiejscowosci(gminaId, stanNa, zSymbolem);
    }

    @Override
    public List<Miejscowosc> getMiejscowosci(RodzajGminy rodzajGminy, LocalDate stanNa) {
        return simcService.getMiejscowosci(rodzajGminy, stanNa);
    }

    @Override
    public Optional<Miejscowosc> getMiejscowosc(Simc id) {
        return simcService.wyszukajMiejscowosc(id.value()).stream()
                .filter(m -> m.id().value().equals(id.value()))
                .findFirst();
    }

    @Override
    public List<Ulica> getUlice(Miejscowosc miejscowosc, LocalDate stanNa) {
        return ulicService.getUlice(miejscowosc.id(), stanNa);
    }

    @Override
    public List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa) {
        return ulicService.getUlice(miejscowoscId, stanNa);
    }

    @Override
    public Optional<Ulica> getUlica(Ulic id, Simc miejscowoscId) {
        return ulicService.getUlice(miejscowoscId, LocalDate.now()).stream()
                .filter(u -> u.id().value().equals(id.value()))
                .findFirst();
    }

    @Override
    public List<StanSimc> getStanSimc() {
        return simcService.getStanSimc();
    }

    @Override
    public PlikKatalogu getStanTerc(LocalDate stanNa) {
        return tercService.getStanTerc(stanNa);
    }

    @Override
    public DanePliku getStanTercData(LocalDate stanNa) {
        return DanePliku.from(getStanTerc(stanNa));
    }

    @Override
    public List<StanUlic> getStanUlic() {
        return ulicService.getStanUlic();
    }

    @Override
    public Integer getRaport(RodzajRaportu rodzajRaportu) {
        return 0;
    }

    @Override
    public List<Miejscowosc> wyszukajMiejscowosc(String nazwa) {
        return simcService.wyszukajMiejscowosc(nazwa);
    }

    @Override
    public List<Miejscowosc> wyszukajMiejscowosc(Terc id) {
        return simcService.wyszukajMiejscowosc(id);
    }

    @Override
    public List<Miejscowosc> wyszukajMiejscowosc(String nazwa, Terc id) {
        return simcService.wyszukajMiejscowosc(nazwa, id);
    }

    @Override
    public List<Ulica> wyszukajUlice(String nazwa) {
        return ulicService.wyszukajUlice(nazwa);
    }

    @Override
    public List<Ulica> wyszukajUlice(Ulic id) {
        return ulicService.wyszukajUlice(id);
    }

    @Override
    public List<Ulica> wyszukajUlice(String nazwa, Terc id) {
        return ulicService.wyszukajUlice(nazwa, id);
    }

    @Override
    public List<ZweryfikowanyAdres> weryfikujAdresDlaMiejscowosci(String nazwaMiejscowosci) {
        return verifyService.weryfikujAdresDlaMiejscowosci(nazwaMiejscowosci);
    }

    @Override
    public List<ZweryfikowanyAdres> weryfikujAdresWMiejscowosci(String nazwaMiejscowosci, Simc symMiejscowosci) {
        return verifyService.weryfikujAdresWMiejscowosci(nazwaMiejscowosci, symMiejscowosci);
    }

    @Override
    public List<ZweryfikowanyAdres> weryfikujAdresDlaUlic(String nazwaUlicy, String nazwaMiejscowosci) {
        return verifyService.weryfikujAdresDlaUlic(nazwaUlicy, nazwaMiejscowosci);
    }

    @Override
    public List<Slownik> getSlownikRodzajowGmin() {
        return dictionaryService.getSlownikRodzajowGmin();
    }

    @Override
    public List<Slownik> getSlownikPoziomowJednostekTerytorialnych() {
        return dictionaryService.getSlownikPoziomowJednostekTerytorialnych();
    }

    @Override
    public List<Slownik> getSlownikRodzajowMiejscowosci() {
        return dictionaryService.getSlownikRodzajowMiejscowosci();
    }

    @Override
    public List<Slownik> getSlownikRodzajowRaportow() {
        return dictionaryService.getSlownikRodzajowRaportow();
    }

    @Override
    public List<Slownik> getSlownikRodzajowPowiatow() {
        return dictionaryService.getSlownikRodzajowPowiatow();
    }

    @Override
    public List<Slownik> getSlownikRodzajowKatalogow() {
        return dictionaryService.getSlownikRodzajowKatalogow();
    }

    @Override
    public List<Slownik> getSlownikMakroregionow() {
        return dictionaryService.getSlownikMakroregionow();
    }

    @Override
    public List<Slownik> getSlownikCechULIC() {
        return dictionaryService.getSlownikCechUlic();
    }

    @Override
    public void updateEMUiAAddressPoint(PunktAdresowy punktAdresowy) {
        throw new UnsupportedOperationException("Metoda updateEMUiAAddressPoint nie jest jeszcze zaimplementowana.");
    }

    @Override
    public void updateEMUiAStreet(PlacUlica placUlica) {
        throw new UnsupportedOperationException("Metoda updateEMUiAStreet nie jest jeszcze zaimplementowana.");
    }

    @Override
    public List<Podregion> getPodregiony(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return regionService.getPodregiony(wojewodztwo, stanNa);
    }

    @Override
    public List<Podregion> getPodregiony(Terc wojewodztwoId, LocalDate stanNa) {
        return regionService.getPodregiony(wojewodztwoId, stanNa);
    }

    @Override
    public List<Region> getRegiony(LocalDate stanNa) {
        return regionService.getRegiony(stanNa);
    }

    @Override
    public Makroregion getMakroregion(Wojewodztwo wojewodztwo) {
        return regionService.getMakroregion(wojewodztwo.id());
    }

    @Override
    public Makroregion getMakroregion(Terc wojewodztwoId) {
        return regionService.getMakroregion(wojewodztwoId);
    }
}
