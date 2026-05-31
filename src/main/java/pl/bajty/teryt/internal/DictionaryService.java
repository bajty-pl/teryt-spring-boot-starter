package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.interfaces.Slownik;

import java.util.Arrays;
import java.util.List;

@Service
class DictionaryService {
    List<Slownik> getSlownikRodzajowGmin() {
        return Arrays.asList(RodzajGminy.values());
    }

    List<Slownik> getSlownikPoziomowJednostekTerytorialnych() {
        return List.of();
    }

    List<Slownik> getSlownikRodzajowMiejscowosci() {
        return List.of();
    }

    List<Slownik> getSlownikRodzajowRaportow() {
        return List.of();
    }

    List<Slownik> getSlownikRodzajowPowiatow() {
        return List.of();
    }

    List<Slownik> getSlownikRodzajowKatalogow() {
        return List.of();
    }

    List<Slownik> getSlownikMakroregionow() {
        return List.of();
    }

    List<Slownik> getSlownikCechUlic() {
        return List.of();
    }
}
