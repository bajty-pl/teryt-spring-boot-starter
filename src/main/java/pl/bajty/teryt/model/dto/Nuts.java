package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.PoziomNuts;

import java.util.regex.Pattern;

/**
 * Reprezentuje kod NUTS (Nomenklatura Jednostek Terytorialnych do Celów Statystycznych).
 *
 * @param value Wartość kodu NUTS.
 */
public record Nuts(String value) {

    private static final Pattern NUTS_PATTERN = Pattern.compile("^PL\\d{1,3}$");

    private static final String BLANK_NUTS_MESSAGE = "NUTS code must not be blank.";
    private static final String INVALID_NUTS_FORMAT_MESSAGE = "Invalid NUTS code format. Must start with 'PL' followed by 1 to 3 digits.";
    private static final String UNREACHABLE_STATE_MESSAGE = "Unreachable NUTS state - length validated in constructor.";

    public Nuts {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BLANK_NUTS_MESSAGE);
        }

        value = value.trim().toUpperCase();

        if (!NUTS_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(INVALID_NUTS_FORMAT_MESSAGE);
        }
    }

    public PoziomNuts poziomNuts() {
        return switch (value.length()) {
            case 3 -> PoziomNuts.MAKROREGION_NUTS1;
            case 4 -> PoziomNuts.REGION_NUTS2;
            case 5 -> PoziomNuts.PODREGION_NUTS3;
            default -> throw new IllegalStateException(UNREACHABLE_STATE_MESSAGE);
        };
    }
}