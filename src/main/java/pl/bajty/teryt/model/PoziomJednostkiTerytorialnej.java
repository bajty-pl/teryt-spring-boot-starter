package pl.bajty.teryt.model;

import lombok.Getter;

@Getter
public enum PoziomJednostkiTerytorialnej {
    WOJEWODZTWO(2),
    POWIAT(4),
    GMINA(7);

    private final int codeLength;

    PoziomJednostkiTerytorialnej(int codeLength) {
        this.codeLength = codeLength;
    }

}
