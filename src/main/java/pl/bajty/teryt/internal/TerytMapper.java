package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import pl.bajty.teryt.internal.soap.generated.JednostkaTerytorialna;
import pl.bajty.teryt.model.Terc;
import pl.bajty.teryt.model.Wojewodztwo;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

class TerytMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    static Wojewodztwo toWojewodztwo(JednostkaTerytorialna soap) {
        return new Wojewodztwo(
                new Terc(unwrap(soap.getWOJ())),
                unwrap(soap.getNAZWA()),
                parseDate(unwrap(soap.getSTANNA()))
        );
    }

    private static String unwrap(JAXBElement<String> element) {
        return (element == null || element.isNil()) ? null : element.getValue();
    }

    static LocalDate parseDate(String rawDate) {
        if (rawDate == null || rawDate.isBlank()) {
            return null;
        }

        String trimmedDate = rawDate.trim();

        try {
            if (trimmedDate.matches("^\\d{4}-\\d{2}-\\d{2}.*")) {
                String dateOnly = trimmedDate.contains("T") ? trimmedDate.split("T")[0] : trimmedDate;
                return LocalDate.parse(dateOnly, DateTimeFormatter.ISO_LOCAL_DATE);
            }

            if (trimmedDate.contains("/")) {
                DateTimeFormatter weirdGusFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a", Locale.US);
                return LocalDate.parse(trimmedDate, weirdGusFormatter);
            }

        } catch (DateTimeParseException e) {
            throw new IllegalStateException("Nieznany format daty zwrócony przez API GUS: " + rawDate, e);
        }

        throw new IllegalStateException("Nieobsługiwany wzorzec daty z API GUS: " + rawDate);
    }

    static XMLGregorianCalendar toXmlGregorianCalendar(LocalDate date) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    date.getYear(),
                    date.getMonthValue(),
                    date.getDayOfMonth(),
                    0, 0, 0,
                    DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED
            );
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException("Krytyczny błąd konfiguracji parsera dat XML", e);
        }
    }
}