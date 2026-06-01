package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.enums.Makroregion;
import pl.bajty.teryt.model.dto.Terc;

@Service
public class RegionService {

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
