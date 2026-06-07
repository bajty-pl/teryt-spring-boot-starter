package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.dto.PlikKatalogu;
import pl.bajty.teryt.model.dto.PlikZmiany;
import pl.bajty.teryt.model.enums.RodzajKatalogu;
import pl.bajty.teryt.model.dto.Zmiana;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class FilesService {

    private static final String ACTION_BASE = "http://tempuri.org/ITerytWs1/";

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    LocalDate getCatalogDate(RodzajKatalogu type) {
        if (type == null) {
            throw new IllegalArgumentException("RodzajKatalogu nie może być null");
        }
        return switch (type) {
            case TERC, TERC_ADRESOWY -> getTercDate();
            case SIMC, SIMC_ADRESOWY, SIMC_STATYSTYCZNY -> getSimcDate();
            case ULIC, ULIC_ADRESOWY, ULIC_BEZ_DZIELNIC, ULIC_STARY -> getUlicDate();
            case NTS -> getNtsDate();
        };
    }

    private LocalDate getTercDate() {
        var response = (PobierzDateAktualnegoKatTercResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzDateAktualnegoKatTerc(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzDateAktualnegoKatTerc"))
        );
        return toLocalDate(response == null ? null : response.getPobierzDateAktualnegoKatTercResult());
    }

    private LocalDate getSimcDate() {
        var response = (PobierzDateAktualnegoKatSimcResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzDateAktualnegoKatSimc(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzDateAktualnegoKatSimc"))
        );
        return toLocalDate(response == null ? null : response.getPobierzDateAktualnegoKatSimcResult());
    }

    private LocalDate getUlicDate() {
        var response = (PobierzDateAktualnegoKatUlicResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzDateAktualnegoKatUlic(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzDateAktualnegoKatUlic"))
        );
        return toLocalDate(response == null ? null : response.getPobierzDateAktualnegoKatUlicResult());
    }

    private LocalDate getNtsDate() {
        var response = (PobierzDateAktualnegoKatNTSResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzDateAktualnegoKatNTS(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzDateAktualnegoKatNTS"))
        );
        return toLocalDate(response == null ? null : response.getPobierzDateAktualnegoKatNTSResult());
    }

    private static LocalDate toLocalDate(XMLGregorianCalendar value) {
        if (value == null) {
            return null;
        }
        return LocalDate.of(value.getYear(), value.getMonth(), value.getDay());
    }

    private XMLGregorianCalendar toXMLGregorianCalendar(LocalDate date) {
        if (date == null) {
            return null;
        }
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Błąd konfiguracji XML przy konwersji daty", e);
        }
    }

    private PlikKatalogu mapToDto(PlikKatalog plik) {
        if (plik == null) {
            return null;
        }
        return new PlikKatalogu(
                plik.getNazwaPliku() != null ? plik.getNazwaPliku().getValue() : null,
                plik.getPlikZawartosc() != null ? plik.getPlikZawartosc().getValue() : null,
                plik.getOpis() != null ? plik.getOpis().getValue() : null
        );
    }

    private PlikKatalogu mapZmianyToDto(pl.bajty.teryt.internal.soap.generated.PlikZmiany plik) {
        if (plik == null) {
            return null;
        }
        return new PlikKatalogu(
                plik.getNazwaPliku() != null ? plik.getNazwaPliku().getValue() : null,
                plik.getPlikZawartosc() != null ? plik.getPlikZawartosc().getValue() : null,
                plik.getOpis() != null ? plik.getOpis().getValue() : null
        );
    }

    PlikKatalogu downloadCatalogFile(RodzajKatalogu type) {
        if (type == null) {
            throw new IllegalArgumentException("RodzajKatalogu nie może być null");
        }
        return switch (type) {
            case TERC -> downloadTerc();
            case TERC_ADRESOWY -> downloadTercAdr();
            case SIMC -> downloadSimc();
            case SIMC_ADRESOWY -> downloadSimcAdr();
            case SIMC_STATYSTYCZNY -> downloadSimcStat();
            case ULIC -> downloadUlic();
            case ULIC_ADRESOWY -> downloadUlicAdr();
            case ULIC_BEZ_DZIELNIC -> downloadUlicBezDzielnic();
            case NTS -> downloadNts();
            default -> throw new UnsupportedOperationException("Pobieranie katalogu " + type + " nie jest obsługiwane");
        };
    }

    private PlikKatalogu downloadTerc() {
        var response = (PobierzKatalogTERCResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogTERC(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogTERC"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogTERCResult().getValue());
    }

    private PlikKatalogu downloadTercAdr() {
        var response = (PobierzKatalogTERCAdrResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogTERCAdr(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogTERCAdr"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogTERCAdrResult().getValue());
    }

    private PlikKatalogu downloadSimc() {
        var response = (PobierzKatalogSIMCResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogSIMC(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogSIMC"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogSIMCResult().getValue());
    }

    private PlikKatalogu downloadSimcAdr() {
        var response = (PobierzKatalogSIMCAdrResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogSIMCAdr(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogSIMCAdr"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogSIMCAdrResult().getValue());
    }

    private PlikKatalogu downloadSimcStat() {
        var response = (PobierzKatalogSIMCStatResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogSIMCStat(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogSIMCStat"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogSIMCStatResult().getValue());
    }

    private PlikKatalogu downloadUlic() {
        var response = (PobierzKatalogULICResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogULIC(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogULIC"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogULICResult().getValue());
    }

    private PlikKatalogu downloadUlicAdr() {
        var response = (PobierzKatalogULICAdrResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogULICAdr(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogULICAdr"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogULICAdrResult().getValue());
    }

    private PlikKatalogu downloadUlicBezDzielnic() {
        var response = (PobierzKatalogULICBezDzielnicResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogULICBezDzielnic(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogULICBezDzielnic"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogULICBezDzielnicResult().getValue());
    }

    private PlikKatalogu downloadNts() {
        var response = (PobierzKatalogNTSResponse) webServiceTemplate.marshalSendAndReceive(
                new PobierzKatalogNTS(),
                new ActionCallback(URI.create(ACTION_BASE + "PobierzKatalogNTS"))
        );
        return mapToDto(response == null ? null : response.getPobierzKatalogNTSResult().getValue());
    }

    PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo) {
        if (type == null) {
            throw new IllegalArgumentException("RodzajKatalogu nie może być null");
        }
        return switch (type) {
            case TERC -> downloadZmianyTerc(stanOd, stanDo);
            case TERC_ADRESOWY -> downloadZmianyTercAdr(stanOd, stanDo);
            case SIMC -> downloadZmianySimc(stanOd, stanDo);
            case SIMC_ADRESOWY -> downloadZmianySimcAdr(stanOd, stanDo);
            case SIMC_STATYSTYCZNY -> downloadZmianySimcStat(stanOd, stanDo);
            case ULIC -> downloadZmianyUlic(stanOd, stanDo);
            case ULIC_ADRESOWY -> downloadZmianyUlicAdr(stanOd, stanDo);
            case NTS -> downloadZmianyNts(stanOd, stanDo);
            default -> throw new UnsupportedOperationException("Pobieranie zmian dla " + type + " nie jest obsługiwane");
        };
    }

    private PlikKatalogu downloadZmianyTerc(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianyTercUrzedowy();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianyTercUrzedowyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianyTercUrzedowy"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianyTercUrzedowyResult().getValue());
    }

    private PlikKatalogu downloadZmianyTercAdr(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianyTercAdresowy();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianyTercAdresowyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianyTercAdresowy"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianyTercAdresowyResult().getValue());
    }

    private PlikKatalogu downloadZmianySimc(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianySimcUrzedowy();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianySimcUrzedowyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianySimcUrzedowy"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianySimcUrzedowyResult().getValue());
    }

    private PlikKatalogu downloadZmianySimcAdr(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianySimcAdresowy();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianySimcAdresowyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianySimcAdresowy"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianySimcAdresowyResult().getValue());
    }

    private PlikKatalogu downloadZmianySimcStat(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianySimcStatystyczny();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianySimcStatystycznyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianySimcStatystyczny"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianySimcStatystycznyResult().getValue());
    }

    private PlikKatalogu downloadZmianyUlic(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianyUlicUrzedowy();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianyUlicUrzedowyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianyUlicUrzedowy"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianyUlicUrzedowyResult().getValue());
    }

    private PlikKatalogu downloadZmianyUlicAdr(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianyUlicAdresowy();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianyUlicAdresowyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianyUlicAdresowy"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianyUlicAdresowyResult().getValue());
    }

    private PlikKatalogu downloadZmianyNts(LocalDate stanOd, LocalDate stanDo) {
        var request = new PobierzZmianyNTS();
        request.setStanod(toXMLGregorianCalendar(stanOd));
        request.setStando(toXMLGregorianCalendar(stanDo));
        var response = (PobierzZmianyNTSResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create(ACTION_BASE + "PobierzZmianyNTS"))
        );
        return mapZmianyToDto(response == null ? null : response.getPobierzZmianyNTSResult().getValue());
    }

    List<PlikZmiany> getPlikZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return List.of();
    }

    <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return List.of();
    }

}
