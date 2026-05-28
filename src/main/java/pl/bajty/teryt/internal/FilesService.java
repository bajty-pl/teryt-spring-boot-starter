package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatNTS;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatNTSResponse;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatSimc;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatSimcResponse;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatTerc;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatTercResponse;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatUlic;
import pl.bajty.teryt.internal.soap.generated.PobierzDateAktualnegoKatUlicResponse;
import pl.bajty.teryt.model.dto.PlikKatalogu;
import pl.bajty.teryt.model.dto.PlikZmiany;
import pl.bajty.teryt.model.enums.RodzajKatalogu;
import pl.bajty.teryt.model.dto.Zmiana;

import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class FilesService {

    private static final String ACTION_BASE = "http://tempuri.org/ITerytWs1/";

    private final WebServiceTemplate webServiceTemplate;

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

    PlikKatalogu downloadCatalogFile(RodzajKatalogu type) {
        return null;
    }

    PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

    List<PlikZmiany> getPlikZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

    <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

}
