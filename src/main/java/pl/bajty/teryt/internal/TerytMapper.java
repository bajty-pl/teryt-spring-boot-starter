package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import pl.bajty.teryt.internal.soap.generated.JednostkaTerytorialna;
import pl.bajty.teryt.model.Terc;
import pl.bajty.teryt.model.Wojewodztwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private static LocalDate parseDate(String date) {
        return (date == null) ? null : LocalDate.parse(date, DATE_FORMATTER);
    }
}