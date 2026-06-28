package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.RodzajPowiatu;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TercService {

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public PlikKatalogu getStanTerc(LocalDate stanNa) {
        var request = new PobierzKatalogTERC();
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzKatalogTERCResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzKatalogTERC"))
        );

        return Optional.ofNullable(response)
                .map(PobierzKatalogTERCResponse::getPobierzKatalogTERCResult)
                .map(JAXBElement::getValue)
                .map(plik -> new PlikKatalogu(
                        TerytMapper.unwrap(plik.getNazwaPliku()),
                        TerytMapper.unwrap(plik.getPlikZawartosc()),
                        TerytMapper.unwrap(plik.getOpis())
                ))
                .orElse(null);
    }

    public List<Wojewodztwo> getWojewodztwa(LocalDate date) {
        var request = new PobierzListeWojewodztw();
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(date));

        var response = (PobierzListeWojewodztwResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeWojewodztw"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeWojewodztwResponse::getPobierzListeWojewodztwResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaTerytorialna::getJednostkaTerytorialna)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toWojewodztwo)
                .toList();
    }

    public List<Wojewodztwo> getWojewodztwa(Region region, LocalDate stanNa) {
        var request = new PobierzListeWojewodztwWRegionie();
        request.setReg(objectFactory.createPobierzListeWojewodztwWRegionieReg(region.id()));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListeWojewodztwWRegionieResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeWojewodztwWRegionie"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeWojewodztwWRegionieResponse::getPobierzListeWojewodztwWRegionieResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaNomenklaturyNTS::getJednostkaNomenklaturyNTS)
                .orElse(Collections.emptyList())
                .stream()
                .map(nts -> new Wojewodztwo(
                        new Terc(TerytMapper.unwrap(nts.getWOJ())),
                        TerytMapper.unwrap(nts.getNAZWA()),
                        TerytMapper.parseDate(TerytMapper.unwrap(nts.getSTANNA()))
                ))
                .toList();
    }

    public List<Powiat> getPowiaty(LocalDate stanNa) {
        return getPowiatyInternal(null, stanNa);
    }

    public List<Powiat> getPowiaty() {
        return getPowiaty(LocalDate.now());
    }

    public List<Powiat> getPowiaty(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return getPowiatyInternal(wojewodztwo.id().value(), stanNa);
    }

    public List<Powiat> getPowiaty(Terc wojewodztwoId, LocalDate stanNa) {
        return getPowiatyInternal(wojewodztwoId.value(), stanNa);
    }

    private List<Powiat> getPowiatyInternal(String wojId, LocalDate stanNa) {
        var request = new PobierzListePowiatow();
        request.setWoj(objectFactory.createPobierzListePowiatowWoj(wojId));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListePowiatowResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListePowiatow"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListePowiatowResponse::getPobierzListePowiatowResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaTerytorialna::getJednostkaTerytorialna)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toPowiat)
                .toList();
    }

    public List<Powiat> getPowiaty(Podregion podregion, LocalDate stanNa) {
        return getPowiaty(podregion.id(), stanNa);
    }

    public List<Powiat> getPowiaty(String podregionId, LocalDate stanNa) {
        var request = new PobierzListePowiatowWPodregionie();
        request.setPodreg(objectFactory.createPobierzListePowiatowWPodregioniePodreg(podregionId));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListePowiatowWPodregionieResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListePowiatowWPodregionie"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListePowiatowWPodregionieResponse::getPobierzListePowiatowWPodregionieResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaNomenklaturyNTS::getJednostkaNomenklaturyNTS)
                .orElse(Collections.emptyList())
                .stream()
                .map(nts -> new Powiat(
                        new Terc(TerytMapper.unwrap(nts.getWOJ()) + TerytMapper.unwrap(nts.getPOW())),
                        TerytMapper.unwrap(nts.getNAZWA()),
                        RodzajPowiatu.fromKod(TerytMapper.unwrap(nts.getRODZ())),
                        new Wojewodztwo(new Terc(TerytMapper.unwrap(nts.getWOJ())), null, null),
                        TerytMapper.parseDate(TerytMapper.unwrap(nts.getSTANNA()))
                ))
                .toList();
    }

    public List<Gmina> getGminy() {
        return getGminy(LocalDate.now());
    }

    public List<Gmina> getGminy(LocalDate stanNa) {
        return getGminyInternal(null, null, stanNa);
    }

    public List<Gmina> getGminy(Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return getGminyInternal(wojewodztwo.id().value(), null, stanNa);
    }

    public List<Gmina> getGminy(Wojewodztwo wojewodztwo) {
        return getGminy(wojewodztwo, LocalDate.now());
    }

    public List<Gmina> getGminy(Terc wojewodztwoId, LocalDate stanNa) {
        return getGminyInternal(wojewodztwoId.value(), null, stanNa);
    }

    public List<Gmina> getGminy(Terc wojewodztwoId) {
        return getGminy(wojewodztwoId, LocalDate.now());
    }

    public List<Gmina> getGminy(Powiat powiat, LocalDate stanNa) {
        return getGminyInternal(powiat.id().getWojewodztwoId(), powiat.id().getPowiatId(), stanNa);
    }

    public List<Gmina> getGminy(Powiat powiat) {
        return getGminy(powiat, LocalDate.now());
    }

    public List<Gmina> getGminy(Terc wojewodztwoId, Terc powiatId, LocalDate stanNa) {
        return getGminyInternal(
                wojewodztwoId != null ? wojewodztwoId.value() : null,
                powiatId != null ? powiatId.value().substring(2) : null,
                stanNa
        );
    }

    public List<Gmina> getGminyInternal(String wojId, String powId, LocalDate stanNa) {
        var request = new PobierzListeGmin();
        request.setWoj(objectFactory.createPobierzListeGminWoj(wojId));
        request.setPow(objectFactory.createPobierzListeGminPow(powId));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListeGminResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeGmin"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeGminResponse::getPobierzListeGminResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaTerytorialna::getJednostkaTerytorialna)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toGmina)
                .toList();
    }

    public List<Gmina> getGminy(Terc powiatId, Terc wojewodztwoId) {
        return getGminy(wojewodztwoId, powiatId, LocalDate.now());
    }
}
