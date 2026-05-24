package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.PlikKatalogu;
import pl.bajty.teryt.model.PlikZmiany;
import pl.bajty.teryt.model.RodzajKatalogu;
import pl.bajty.teryt.model.Zmiana;

import java.time.LocalDate;
import java.util.List;

@Service
class FilesService {
    LocalDate getCurrentDate(RodzajKatalogu type) {
        return LocalDate.now();
    }

    PlikKatalogu downloadCatalogFile(RodzajKatalogu type) {
        return null;
    }

    PlikKatalogu downloadZmianyFile(RodzajKatalogu type, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

    List<PlikZmiany> getPlikZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

    <T> List<Zmiana<T>> getZmiany(RodzajKatalogu rodzajKatalogu, LocalDate stanOd, LocalDate stanDo) {
        return null;
    }

}
