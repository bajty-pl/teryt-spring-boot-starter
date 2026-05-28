package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.dto.Simc;
import pl.bajty.teryt.model.dto.Terc;
import pl.bajty.teryt.model.dto.Ulic;
import pl.bajty.teryt.model.dto.Ulica;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UlicService {

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa) {
        var request = new PobierzListeUlicDlaMiejscowosci();
        request.setMsc(objectFactory.createPobierzListeUlicDlaMiejscowosciMsc(miejscowoscId.value()));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListeUlicDlaMiejscowosciResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeUlicDlaMiejscowosci"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeUlicDlaMiejscowosciResponse::getPobierzListeUlicDlaMiejscowosciResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfUlicaDrzewo::getUlicaDrzewo)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toUlica)
                .toList();
    }

    public List<Ulica> wyszukajUlice(String nazwa) {
        var request = new WyszukajUlice();
        request.setNazwaulicy(objectFactory.createWyszukajUliceNazwaulicy(nazwa));

        var response = (WyszukajUliceResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajUlice"))
        );

        return Optional.ofNullable(response)
                .map(WyszukajUliceResponse::getWyszukajUliceResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfUlica::getUlica)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toUlica)
                .toList();
    }

    public List<Ulica> wyszukajUlice(Ulic id) {
        var request = new WyszukajUliceWRejestrze();
        request.setIdentyfikator(objectFactory.createWyszukajUliceWRejestrzeIdentyfikator(id.value()));

        var response = (WyszukajUliceWRejestrzeResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajUliceWRejestrze"))
        );

        return Optional.ofNullable(response)
                .map(WyszukajUliceWRejestrzeResponse::getWyszukajUliceWRejestrzeResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfWyszukanaUlica::getWyszukanaUlica)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toUlica)
                .toList();
    }

    public List<Ulica> wyszukajUlice(String nazwa, Terc id) {
        var request = new WyszukajUliceWRejestrze();
        request.setNazwa(objectFactory.createWyszukajUliceWRejestrzeNazwa(nazwa));

        var identyfiks = new ArrayOfidentyfikatory();
        var identyfikator = new Identyfikatory();
        identyfikator.setTerc(objectFactory.createIdentyfikatoryTerc(id.value()));
        identyfiks.getIdentyfikatory().add(identyfikator);

        request.setIdentyfiks(objectFactory.createWyszukajUliceWRejestrzeIdentyfiks(identyfiks));

        var response = (WyszukajUliceWRejestrzeResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajUliceWRejestrze"))
        );

        return Optional.ofNullable(response)
                .map(WyszukajUliceWRejestrzeResponse::getWyszukajUliceWRejestrzeResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfWyszukanaUlica::getWyszukanaUlica)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toUlica)
                .toList();
    }
}
