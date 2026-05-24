package pl.bajty.teryt.model;

public record TercCode(String value, TerritorialUnitLevel level) {

    public TercCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Kod TERC nie może być pusty.");
        }

        if (value.length() != level.getCodeLength()) {
            throw new IllegalArgumentException(
                    String.format("Dla szczebla %s kod musi mieć %d cyfr, a podano: %d",
                            level, level.getCodeLength(), value.length())
            );
        }

        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException("Kod TERC musi zawierać tylko cyfry.");
        }
    }

    public static TercCode wojewodztwo(String kod) {
        return new TercCode(kod, TerritorialUnitLevel.WOJEWODZTWO);
    }

    public static TercCode powiat(String kod) {
        return new TercCode(kod, TerritorialUnitLevel.POWIAT);
    }

    public static TercCode gmina(String kod) {
        return new TercCode(kod, TerritorialUnitLevel.GMINA);
    }
}