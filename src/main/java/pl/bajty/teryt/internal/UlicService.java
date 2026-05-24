package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.*;

import java.time.LocalDate;
import java.util.List;

@Service
class UlicService {
    List<StanUlic> getStanUlic(LocalDate stanNa) {
        return List.of();
    }

    List<Ulica> getUlice(Miejscowosc miejscowosc, LocalDate stanNa) {
        return List.of();
    }

    List<Ulica> getUlice(Simc miejscowoscId, LocalDate stanNa) {
        return List.of();
    }

    List<Ulica> wyszukajUlice(String nazwa) {
        return List.of();
    }

    List<Ulica> wyszukajUlice(Ulic id) {
        return List.of();
    }

    List<Ulica> wyszukajUlice(String nazwa, Terc id) {
        return List.of();
    }

}
