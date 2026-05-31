package pl.bajty.teryt.model.dto;

import pl.bajty.teryt.model.enums.PoziomJednostkiTerytorialnej;
import pl.bajty.teryt.model.interfaces.KodTeryt;

import java.util.regex.Pattern;

public record Terc(String value) implements KodTeryt {

    private static final Pattern TERC_PATTERN = Pattern.compile("\\d{2}|\\d{4}|\\d{7}");
    private static final String BLANK_TERC_MESSAGE = "TERC code must not be blank.";
    private static final String INVALID_TERC_FORMAT_MESSAGE = "Invalid TERC code format.";
    private static final String UNREACHABLE_STATE_MESSAGE = "Unreachable TERC state - length validated in constructor.";

    public Terc {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BLANK_TERC_MESSAGE);
        }
        if (!TERC_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(INVALID_TERC_FORMAT_MESSAGE);
        }
    }

    public PoziomJednostkiTerytorialnej poziomJednostkiTerytorialnej() {
        return switch (value.length()) {
            case 2 -> PoziomJednostkiTerytorialnej.WOJEWODZTWO;
            case 4 -> PoziomJednostkiTerytorialnej.POWIAT;
            case 7 -> PoziomJednostkiTerytorialnej.GMINA;
            default -> throw new IllegalStateException(UNREACHABLE_STATE_MESSAGE);
        };
    }

    public String getWojewodztwoId() {
        return value.substring(0, 2);
    }

    public String getPowiatId() {
        return value.length() >= 4 ? value.substring(2, 4) : null;
    }

    public String getGminaId() {
        return value.length() >= 6 ? value.substring(4, 6) : null;
    }

    public String getRodzajGminyId() {
        return value.length() >= 7 ? value.substring(6, 7) : null;
    }
}