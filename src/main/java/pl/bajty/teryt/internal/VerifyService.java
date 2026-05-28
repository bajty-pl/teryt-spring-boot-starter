package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.dto.Simc;
import pl.bajty.teryt.model.dto.ZweryfikowanyAdres;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerifyService {

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public List<ZweryfikowanyAdres> weryfikujAdresDlaMiejscowosci(String nazwaMiejscowosci) {
        var request = new WyszukajMiejscowosc();
        request.setNazwaMiejscowosci(objectFactory.createWyszukajMiejscowoscNazwaMiejscowosci(nazwaMiejscowosci));

        var response = (WyszukajMiejscowoscResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajMiejscowosc"))
        );

        var miejscowosci = Optional.ofNullable(response)
                .map(WyszukajMiejscowoscResponse::getWyszukajMiejscowoscResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfMiejscowosc::getMiejscowosc)
                .orElse(Collections.emptyList());

        if (miejscowosci.isEmpty()) {
            return Collections.emptyList();
        }

        var msc = miejscowosci.getFirst();
        var verifyRequest = new WeryfikujAdresDlaMiejscowosci();
        verifyRequest.setSymbolMsc(objectFactory.createWeryfikujAdresDlaMiejscowosciSymbolMsc(msc.getSymbol().getValue()));

        var verifyResponse = (WeryfikujAdresDlaMiejscowosciResponse) webServiceTemplate.marshalSendAndReceive(
                verifyRequest,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WeryfikujAdresDlaMiejscowosci"))
        );

        return Optional.ofNullable(verifyResponse)
                .map(WeryfikujAdresDlaMiejscowosciResponse::getWeryfikujAdresDlaMiejscowosciResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfZweryfikowanyAdresBezUlic::getZweryfikowanyAdresBezUlic)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toZweryfikowanyAdres)
                .toList();
    }

    public List<ZweryfikowanyAdres> weryfikujAdresWMiejscowosci(String nazwaMiejscowosci, Simc symMiejscowosci) {
        var request = new WeryfikujAdresDlaMiejscowosci();
        request.setSymbolMsc(objectFactory.createWeryfikujAdresDlaMiejscowosciSymbolMsc(symMiejscowosci.value()));

        var response = (WeryfikujAdresDlaMiejscowosciResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WeryfikujAdresDlaMiejscowosci"))
        );

        return Optional.ofNullable(response)
                .map(WeryfikujAdresDlaMiejscowosciResponse::getWeryfikujAdresDlaMiejscowosciResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfZweryfikowanyAdresBezUlic::getZweryfikowanyAdresBezUlic)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toZweryfikowanyAdres)
                .toList();
    }

    public List<ZweryfikowanyAdres> weryfikujAdresDlaUlic(String nazwaUlicy, String nazwaMiejscowosci) {
        var request = new WyszukajUlice();
        request.setNazwaulicy(objectFactory.createWyszukajUliceNazwaulicy(nazwaUlicy));
        request.setNazwamiejscowosci(objectFactory.createWyszukajUliceNazwamiejscowosci(nazwaMiejscowosci));

        var response = (WyszukajUliceResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WyszukajUlice"))
        );

        var ulice = Optional.ofNullable(response)
                .map(WyszukajUliceResponse::getWyszukajUliceResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfUlica::getUlica)
                .orElse(Collections.emptyList());

        if (ulice.isEmpty()) {
            return Collections.emptyList();
        }

        var ulica = ulice.getFirst();
        var verifyRequest = new WeryfikujAdresDlaUlic();
        verifyRequest.setSymbolMsc(objectFactory.createWeryfikujAdresDlaUlicSymbolMsc(ulica.getIdentyfikatorMiejscowosci().getValue()));
        verifyRequest.setSymUl(objectFactory.createWeryfikujAdresDlaUlicSymUl(ulica.getIdentyfikatorUlicy().getValue()));

        var verifyResponse = (WeryfikujAdresDlaUlicResponse) webServiceTemplate.marshalSendAndReceive(
                verifyRequest,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/WeryfikujAdresDlaUlic"))
        );

        return Optional.ofNullable(verifyResponse)
                .map(WeryfikujAdresDlaUlicResponse::getWeryfikujAdresDlaUlicResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfZweryfikowanyAdres::getZweryfikowanyAdres)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toZweryfikowanyAdres)
                .toList();
    }
}
