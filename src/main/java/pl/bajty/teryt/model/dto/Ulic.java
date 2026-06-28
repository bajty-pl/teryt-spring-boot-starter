package pl.bajty.teryt.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import pl.bajty.teryt.model.interfaces.KodTeryt;

import java.util.regex.Pattern;

/**
 * Reprezentuje kod ULIC (System identyfikatorów i nazw ulic).
 * Kod ULIC składa się z 5 cyfr.
 *
 * @param value Wartość kodu ULIC.
 */
public record Ulic(String value) implements KodTeryt {

    private static final Pattern ULIC_PATTERN = Pattern.compile("^\\d{5}$");

    private static final String BLANK_ULIC_MESSAGE = "ULIC code must not be blank.";
    private static final String INVALID_ULIC_FORMAT_MESSAGE = "Invalid ULIC code format. Must be exactly 5 digits.";

    @JsonCreator
    public Ulic {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BLANK_ULIC_MESSAGE);
        }

        value = value.trim();

        if (!ULIC_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(INVALID_ULIC_FORMAT_MESSAGE);
        }
    }

    @JsonValue
    @Override
    public String value() {
        return value;
    }

    public static boolean isCorrectCode(String value) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return ULIC_PATTERN.matcher(value.trim()).matches();
    }
}