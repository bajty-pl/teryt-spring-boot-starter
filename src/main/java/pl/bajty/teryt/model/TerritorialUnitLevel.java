package pl.bajty.teryt.model;

import lombok.Getter;

@Getter
public enum TerritorialUnitLevel {
    WOJEWODZTWO(2),
    POWIAT(4),
    GMINA(7);

    private final int codeLength;

    TerritorialUnitLevel(int codeLength) {
        this.codeLength = codeLength;
    }

}
