package pl.bajty.teryt.model;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Ulic {

    private final String value;

    private static final Pattern ULIC_PATTERN = Pattern.compile("\\d{7}");
    private static final String BLANK_ULIC_MESSAGE = "ULIC code must not be blank.";
    private static final String INVALID_ULIC_FORMAT_MESSAGE = "Invalid SIMC code format.";

    public Ulic(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BLANK_ULIC_MESSAGE);
        }

        if (!ULIC_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(INVALID_ULIC_FORMAT_MESSAGE);
        }

        this.value = value;
    }

    static boolean isCorrectCode(String value) {
        return ULIC_PATTERN.matcher(value).matches();
    }
}
