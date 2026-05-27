package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.Gmina;
import pl.bajty.teryt.model.RodzajGminy;
import pl.bajty.teryt.model.StanSimc;
import pl.bajty.teryt.model.Terc;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SimcService {

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public List<StanSimc> getStanSimc() {
        var request = new PobierzListeStanowSimc();

        var response = (PobierzListeStanowSimcResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeStanowSimc"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeStanowSimcResponse::getPobierzListeStanowSimcResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfstring::getString)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::parseDate)
                .map(StanSimc::new)
                .toList();
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Gmina gmina) {
        return getMiejscowosci(gmina.id(), LocalDate.now(), false);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa) {
        return getMiejscowosci(gmina.id(), stanNa, false);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Gmina gmina, boolean zSymbolem) {
        return getMiejscowosci(gmina.id(), LocalDate.now(), zSymbolem);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Gmina gmina, LocalDate stanNa, boolean zSymbolem) {
        return getMiejscowosci(gmina.id(), stanNa, zSymbolem);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Terc gminaId) {
        return getMiejscowosci(gminaId, LocalDate.now(), false);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa) {
        return getMiejscowosci(gminaId, stanNa, false);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Terc gminaId, boolean zSymbolem) {
        return getMiejscowosci(gminaId, LocalDate.now(), zSymbolem);
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(Terc gminaId, LocalDate stanNa, boolean zSymbolem) {
        if (zSymbolem) {
            var request = new PobierzListeMiejscowosciWGminieZSymbolem();
            request.setWoj(objectFactory.createPobierzListeMiejscowosciWGminieZSymbolemWoj(gminaId.getWojewodztwoId()));
            request.setPow(objectFactory.createPobierzListeMiejscowosciWGminieZSymbolemPow(gminaId.getPowiatId()));
            request.setGmi(objectFactory.createPobierzListeMiejscowosciWGminieZSymbolemGmi(gminaId.getGminaId()));
            request.setRodz(objectFactory.createPobierzListeMiejscowosciWGminieZSymbolemRodz(gminaId.getRodzajGminyId()));
            request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

            var response = (PobierzListeMiejscowosciWGminieZSymbolemResponse) webServiceTemplate.marshalSendAndReceive(
                    request,
                    new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeMiejscowosciWGminieZSymbolem"))
            );

            return Optional.ofNullable(response)
                    .map(PobierzListeMiejscowosciWGminieZSymbolemResponse::getPobierzListeMiejscowosciWGminieZSymbolemResult)
                    .map(JAXBElement::getValue)
                    .map(ArrayOfMiejscowoscPelna::getMiejscowoscPelna)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(TerytMapper::toMiejscowosc)
                    .toList();
        } else {
            var request = new PobierzListeMiejscowosciWGminie();
            request.setWojewodztwo(objectFactory.createPobierzListeMiejscowosciWGminieWojewodztwo(gminaId.getWojewodztwoId()));
            request.setPowiat(objectFactory.createPobierzListeMiejscowosciWGminiePowiat(gminaId.getPowiatId()));
            request.setGmina(objectFactory.createPobierzListeMiejscowosciWGminieGmina(gminaId.getGminaId()));
            request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

            var response = (PobierzListeMiejscowosciWGminieResponse) webServiceTemplate.marshalSendAndReceive(
                    request,
                    new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeMiejscowosciWGminie"))
            );

            return Optional.ofNullable(response)
                    .map(PobierzListeMiejscowosciWGminieResponse::getPobierzListeMiejscowosciWGminieResult)
                    .map(JAXBElement::getValue)
                    .map(ArrayOfMiejscowosc::getMiejscowosc)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(TerytMapper::toMiejscowosc)
                    .toList();
        }
    }

    List<pl.bajty.teryt.model.Miejscowosc> getMiejscowosci(RodzajGminy rodzajGminy, LocalDate stanNa) {
        var request = new PobierzListeMiejscowosciWRodzajuGminy();
        request.setSymbolRodz(objectFactory.createPobierzListeMiejscowosciWRodzajuGminySymbolRodz(rodzajGminy.getValue()));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListeMiejscowosciWRodzajuGminyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeMiejscowosciWRodzajuGminy"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeMiejscowosciWRodzajuGminyResponse::getPobierzListeMiejscowosciWRodzajuGminyResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfMiejscowosc::getMiejscowosc)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toMiejscowosc)
                .toList();
    }

    List<pl.bajty.teryt.model.Miejscowosc> wyszukajMiejscowosc(String nazwa) {
        var request = new WyszukajMiejscowosc();
        request.setNazwaMiejscowosci(objectFactory.createWyszukajMiejscowoscNazwaMiejscowosci(nazwa));

        var response = (WyszukajMiejscowoscResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajMiejscowosc"))
        );

        return Optional.ofNullable(response)
                .map(WyszukajMiejscowoscResponse::getWyszukajMiejscowoscResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfMiejscowosc::getMiejscowosc)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toMiejscowosc)
                .toList();
    }

    List<pl.bajty.teryt.model.Miejscowosc> wyszukajMiejscowosc(Terc id) {
        var request = new WyszukajMiejscowosc();
        request.setIdentyfikatorMiejscowosci(objectFactory.createWyszukajMiejscowoscIdentyfikatorMiejscowosci(id.value()));

        var response = (WyszukajMiejscowoscResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajMiejscowosc"))
        );

        return Optional.ofNullable(response)
                .map(WyszukajMiejscowoscResponse::getWyszukajMiejscowoscResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfMiejscowosc::getMiejscowosc)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toMiejscowosc)
                .toList();
    }

    List<pl.bajty.teryt.model.Miejscowosc> wyszukajMiejscowosc(String nazwa, Terc id) {
        var request = new WyszukajMiejscowoscWJPT();
        request.setNazwaMiejscowosci(objectFactory.createWyszukajMiejscowoscWJPTNazwaMiejscowosci(nazwa));
        request.setNazwaWoj(objectFactory.createWyszukajMiejscowoscWJPTNazwaWoj(id.getWojewodztwoId()));
        request.setNazwaPow(objectFactory.createWyszukajMiejscowoscWJPTNazwaPow(id.getPowiatId()));

        var response = (WyszukajMiejscowoscWJPTResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajMiejscowoscWJPT"))
        );

        return Optional.ofNullable(response)
                .map(WyszukajMiejscowoscWJPTResponse::getWyszukajMiejscowoscWJPTResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfMiejscowosc::getMiejscowosc)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toMiejscowosc)
                .toList();
    }
}
