package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.RodzajZmiany;

public record Zmiana<T>(
        RodzajZmiany rodzajZmiany,
        T stanPrzed,
        T stanPo
) {
}
