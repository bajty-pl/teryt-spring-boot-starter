package pl.bajty.teryt.model;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Simc {
    private final String value;

    private static final Pattern SIMC_PATTERN = Pattern.compile("\\d{7}");
    private static final String BLANK_SIMC_MESSAGE = "SIMC code must not be blank.";
    private static final String INVALID_SIMC_FORMAT_MESSAGE = "Invalid SIMC code format.";

    public Simc(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BLANK_TERC_MESSAGE);
        }

        if (!TERC_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(INVALID_TERC_FORMAT_MESSAGE);
        }

        this.value = value;
    }
}
