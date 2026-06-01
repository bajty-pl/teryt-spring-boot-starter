package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.enums.*;
import pl.bajty.teryt.model.interfaces.Slownik;

import java.util.Arrays;
import java.util.List;

@Service
public class DictionaryService {
    List<Slownik> getSlownikRodzajowGmin() {
        return Arrays.asList(RodzajGminy.values());
    }

    List<Slownik> getSlownikPoziomowJednostekTerytorialnych() {
        return Arrays.asList(PoziomJednostkiTerytorialnej.values());
    }

    List<Slownik> getSlownikRodzajowMiejscowosci() {
        return Arrays.asList(RodzajMiejscowosci.values());
    }

    List<Slownik> getSlownikRodzajowRaportow() {
        return Arrays.asList(RodzajRaportu.values());
    }

    List<Slownik> getSlownikRodzajowPowiatow() {
        return Arrays.asList(RodzajPowiatu.values());
    }

    List<Slownik> getSlownikRodzajowKatalogow() {
        return Arrays.asList(RodzajKatalogu.values());
    }

    List<Slownik> getSlownikMakroregionow() {
        return Arrays.asList(PoziomNuts.values());
    }

    List<Slownik> getSlownikCechUlic() {
        return Arrays.asList(CechaUlicy.values());
    }
}
