package pl.bajty.teryt.internal;

import org.springframework.stereotype.Service;
import pl.bajty.teryt.model.dto.Simc;
import pl.bajty.teryt.model.dto.ZweryfikowanyAdres;

import java.util.List;

@Service
class VerifyService {
    List<ZweryfikowanyAdres> weryfikujAdresDlaMiejscowosci(String nazwaMiejscowosci) {
        return List.of();
    }

    List<ZweryfikowanyAdres> weryfikujAdresWMiejscowosci(String nazwaMiejscowosci, Simc symMiejscowosci) {
        return List.of();
    }

    List<ZweryfikowanyAdres> weryfikujAdresDlaUlic(String nazwaUlicy, String nazwaMiejscowosci) {
        return List.of();
    }

}
