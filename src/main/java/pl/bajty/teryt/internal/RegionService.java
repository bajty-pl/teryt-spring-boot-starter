package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.*;
import pl.bajty.teryt.model.dto.Podregion;
import pl.bajty.teryt.model.dto.Region;
import pl.bajty.teryt.model.dto.Terc;
import pl.bajty.teryt.model.enums.Makroregion;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RegionService {

    private final WebServiceTemplate webServiceTemplate;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public List<Region> getRegiony(LocalDate stanNa) {
        var request = new PobierzListeRegionow();
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListeRegionowResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListeRegionow"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListeRegionowResponse::getPobierzListeRegionowResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaNomenklaturyNTS::getJednostkaNomenklaturyNTS)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toRegion)
                .toList();
    }

    public List<Podregion> getPodregiony(Terc wojewodztwoId, LocalDate stanNa) {
        var request = new PobierzListePodregionow();
        request.setWoj(objectFactory.createPobierzListePodregionowWoj(wojewodztwoId.value()));
        request.setDataStanu(TerytMapper.toXmlGregorianCalendar(stanNa));

        var response = (PobierzListePodregionowResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/PobierzListePodregionow"))
        );

        return Optional.ofNullable(response)
                .map(PobierzListePodregionowResponse::getPobierzListePodregionowResult)
                .map(JAXBElement::getValue)
                .map(ArrayOfJednostkaNomenklaturyNTS::getJednostkaNomenklaturyNTS)
                .orElse(Collections.emptyList())
                .stream()
                .map(TerytMapper::toPodregion)
                .toList();
    }

    public List<Podregion> getPodregiony(pl.bajty.teryt.model.dto.Wojewodztwo wojewodztwo, LocalDate stanNa) {
        return getPodregiony(wojewodztwo.id(), stanNa);
    }

    public Makroregion getMakroregion(Terc id) {
        if (id == null) {
            return null;
        }

        String wojewodztwoIdValue = id.value().substring(0, 2);

        return switch (wojewodztwoIdValue) {
            case "12", "24" -> Makroregion.POLUDNIOWY;
            case "30", "32", "08" -> Makroregion.POLNOCNO_ZACHODNI;
            case "02", "16" -> Makroregion.POLUDNIOWO_ZACHODNI;
            case "04", "28", "22" -> Makroregion.POLNOCNY;
            case "10", "26" -> Makroregion.CENTRALNY;
            case "06", "18", "20" -> Makroregion.WSCHODNI;
            case "14" -> Makroregion.WOJEWODZTWO_MAZOWIECKIE;
            default -> throw new IllegalArgumentException("Nieobsługiwany TERC: " + wojewodztwoIdValue);
        };
    }
}
