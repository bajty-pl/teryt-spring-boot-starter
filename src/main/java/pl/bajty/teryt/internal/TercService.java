package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.PobierzListeWojewodztw;
import pl.bajty.teryt.internal.soap.generated.PobierzListeWojewodztwResponse;
import pl.bajty.teryt.model.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class TercService {

    private final WebServiceTemplate webServiceTemplate;

    List<StanTerc> getStanTerc(LocalDate stanNa) {
        return List.of();
    }

    List<Wojewodztwo> getWojewodztwa(LocalDate date) {
        var request = new PobierzListeWojewodztw();
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(date));

        var response = (PobierzListeWojewodztwResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeWojewodztw"))
        );

        if (response == null || response.getPobierzListeWojewodztwResult() == null || response.getPobierzListeWojewodztwResult().isNil()) {
            return List.of();
        }

        var resultValue = response.getPobierzListeWojewodztwResult().getValue();

        if (resultValue == null || resultValue.getJednostkaTerytorialna() == null) {
            return List.of();
        }

        return resultValue.getJednostkaTerytorialna().stream()
                .map(TerytMapper::toWojewodztwo)
                .toList();
    }

    List<Wojewodztwo> getWojewodztwa(Region region, LocalDate stanNa) {
        return List.of();
    }

    List<Powiat> getPowiaty() {
        return List.of();
    }

    List<Powiat> getPowiaty(LocalDate stanNa) {
        return List.of();
    }

    List<Powiat> getPowiaty(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return List.of();
    }

    List<Powiat> getPowiaty(Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa) {
        return List.of();
    }

    List<Powiat> getPowiaty(String podregionId, LocalDate stanNa) {
        return List.of();
    }

    List<Gmina> getGminy() {
        return List.of();
    }

    List<Gmina> getGminy(LocalDate stanNa) {
        return List.of();
    }

    List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return List.of();
    }

    List<Gmina> getGminy(Wojewodztwo wojewodztwo) {
        return List.of();
    }

    List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    List<Gmina> getGminy(Terc wojewodztwoId) {
        return List.of();
    }

    List<Gmina> getGminy(Powiat powiat, LocalDate stanNa) {
        return List.of();
    }

    List<Gmina> getGminy(Powiat powiat) {
        return List.of();
    }

    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId, LocalDate stanNa) {
        return List.of();
    }

    List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId) {
        return List.of();
    }
}
