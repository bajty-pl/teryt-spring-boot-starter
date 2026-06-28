package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.interfaces.KodTeryt;

import java.util.regex.Pattern;

/**
 * Reprezentuje kod SIMC (System identyfikatorów i nazw miejscowości).
 * Kod SIMC składa się z 7 cyfr.
 *
 * @param value Wartość kodu SIMC.
 */
public record Simc(String value) implements KodTeryt {

    private static final Pattern SIMC_PATTERN = Pattern.compile("^\\d{7}$");
    private static final String BLANK_SIMC_MESSAGE = "SIMC code must not be blank.";
    private static final String INVALID_SIMC_FORMAT_MESSAGE = "Invalid SIMC code format. Must be exactly 7 digits.";

    public Simc {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BLANK_SIMC_MESSAGE);
        }

        value = value.trim();

        if (!SIMC_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(INVALID_SIMC_FORMAT_MESSAGE);
        }
    }

    public static boolean isCorrectCode(String value) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return SIMC_PATTERN.matcher(value.trim()).matches();
    }
}