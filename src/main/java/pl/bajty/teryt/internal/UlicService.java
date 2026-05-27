package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.Simc;
import pl.bajty.teryt.model.Terc;
import pl.bajty.teryt.model.Ulic;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UlicService {

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public List<pl.bajty.teryt.model.Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa) {
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

    public List<pl.bajty.teryt.model.Ulica> wyszukajUlice(String nazwa) {
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

    public List<pl.bajty.teryt.model.Ulica> wyszukajUlice(Ulic id) {
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

    public List<pl.bajty.teryt.model.Ulica> wyszukajUlice(String nazwa, Terc id) {
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
