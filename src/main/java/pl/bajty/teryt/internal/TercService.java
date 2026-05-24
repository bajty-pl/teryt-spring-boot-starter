package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.*;

import java.time.LocalDate;
import java.util.List;

@Service
class TercService {
    List<StanTerc> getStanTerc(LocalDate stanNa) {
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
