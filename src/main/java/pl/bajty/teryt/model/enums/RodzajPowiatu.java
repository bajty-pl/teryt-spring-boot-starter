package pl.bajty.teryt.model.enums;

import lombok.Getter;

@Getter
public enum RodzajPowiatu {
    POWIAT("p"),
    MIASTO_NA_PRAWACH_POWIATU("m");

    private final String value;

    RodzajPowiatu(String value) {
        this.value = value;
    }

    public static RodzajPowiatu fromValue(String value) {
        for (RodzajPowiatu r : RodzajPowiatu.values()) {
            if (r.value.equalsIgnoreCase(value)) {
                return r;
            }
        }
        return null;
    }
}
