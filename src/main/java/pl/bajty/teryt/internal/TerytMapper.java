package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import pl.bajty.teryt.internal.soap.generated.JednostkaTerytorialna;
import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.enums.RodzajMiejscowosci;
import pl.bajty.teryt.model.enums.RodzajPowiatu;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.regex.Pattern;

public class TerytMapper {

    private static final String EMPTY = "";
    private static final String DATE_SEPARATOR_T = "T";
    private static final String DATE_SEPARATOR_SPACE = " ";
    private static final String DATE_SEPARATOR_SLASH = "/";
    private static final String GUS_DATE_PATTERN = "M/d/yyyy";

    private static final Pattern ISO_DATE_PREFIX_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}.*");

    private static final DateTimeFormatter WEIRD_GUS_FORMATTER = DateTimeFormatter.ofPattern(GUS_DATE_PATTERN, Locale.US);

    public static Wojewodztwo toWojewodztwo(JednostkaTerytorialna soap) {
        return new Wojewodztwo(
                new Terc(unwrap(soap.getWOJ())),
                unwrap(soap.getNAZWA()),
                parseDate(unwrap(soap.getSTANNA()))
        );
    }

    public static Powiat toPowiat(JednostkaTerytorialna soap) {
        Wojewodztwo wojewodztwo = toWojewodztwo(soap);
        return new Powiat(
                new Terc(unwrap(soap.getWOJ()) + unwrap(soap.getPOW())),
                unwrap(soap.getNAZWA()),
                RodzajPowiatu.fromValue(unwrap(soap.getRODZ())),
                wojewodztwo,
                wojewodztwo.stanNa()
        );
    }

    public static Gmina toGmina(JednostkaTerytorialna soap) {
        Powiat powiat = toPowiat(soap);
        String rodz = unwrap(soap.getRODZ());

        return new Gmina(
                new Terc(powiat.id().value() + unwrap(soap.getGMI()) + (rodz != null ? rodz : EMPTY)),
                unwrap(soap.getNAZWA()),
                RodzajGminy.fromValue(rodz),
                powiat,
                powiat.wojewodztwo(),
                powiat.stanNa()
        );
    }

    public static Miejscowosc toMiejscowosc(pl.bajty.teryt.internal.soap.generated.Miejscowosc soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getWojSymbol()),
                unwrap(soap.getWojewodztwo()),
                unwrap(soap.getPowSymbol()),
                unwrap(soap.getPowiat()),
                unwrap(soap.getGmiSymbol()),
                unwrap(soap.getGmina()),
                unwrap(soap.getGmiRodzaj())
        );

        return new Miejscowosc(
                new Simc(unwrap(soap.getSymbol())),
                unwrap(soap.getNazwa()),
                null,
                null,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );
    }

    public static Miejscowosc toMiejscowosc(pl.bajty.teryt.internal.soap.generated.MiejscowoscPelna soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getWojSymbol()),
                unwrap(soap.getWojewodztwo()),
                unwrap(soap.getPowSymbol()),
                unwrap(soap.getPowiat()),
                unwrap(soap.getGmiSymbol()),
                unwrap(soap.getGmina()),
                unwrap(soap.getGmiRodzaj())
        );

        String symPodst = unwrap(soap.getSymbolPodst());

        return new Miejscowosc(
                new Simc(unwrap(soap.getSymbol())),
                unwrap(soap.getNazwa()),
                RodzajMiejscowosci.fromValue(unwrap(soap.getRM())),
                symPodst != null ? new Simc(symPodst) : null,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );
    }

    public static Ulica toUlica(pl.bajty.teryt.internal.soap.generated.Ulica soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getWojSymbol()),
                unwrap(soap.getWojewodztwo()),
                unwrap(soap.getPowSymbol()),
                unwrap(soap.getPowiat()),
                unwrap(soap.getGmiSymbol()),
                unwrap(soap.getGmina()),
                unwrap(soap.getGmiRodzaj())
        );

        Miejscowosc miejscowosc = new Miejscowosc(
                new Simc(unwrap(soap.getIdentyfikatorMiejscowosci())),
                unwrap(soap.getNazwaMiejscowosci()),
                null,
                null,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );

        return new Ulica(
                new Ulic(unwrap(soap.getIdentyfikatorUlicy())),
                unwrap(soap.getNazwa()),
                unwrap(soap.getCecha()),
                miejscowosc,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );
    }

    public static Ulica toUlica(pl.bajty.teryt.internal.soap.generated.UlicaDrzewo soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getWoj()),
                null,
                unwrap(soap.getPow()),
                null,
                unwrap(soap.getGmi()),
                null,
                unwrap(soap.getRodzGmi())
        );

        Miejscowosc miejscowosc = new Miejscowosc(
                new Simc(unwrap(soap.getIdentyfikatorMiejscowosci())),
                null,
                null,
                null,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );

        String nazwa1 = unwrap(soap.getNazwa1());
        String nazwa2 = unwrap(soap.getNazwa2());
        String nazwaPelna = (nazwa2 != null && !nazwa2.isBlank()) ? nazwa2 + " " + nazwa1 : nazwa1;

        return new Ulica(
                new Ulic(unwrap(soap.getSymbolUlicy())),
                nazwaPelna,
                unwrap(soap.getCecha()),
                miejscowosc,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );
    }

    public static Ulica toUlica(pl.bajty.teryt.internal.soap.generated.WyszukanaUlica soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getWoj()),
                unwrap(soap.getWojewodztwo()),
                unwrap(soap.getPow()),
                unwrap(soap.getPowiat()),
                unwrap(soap.getGmi()),
                unwrap(soap.getGmina()),
                unwrap(soap.getRodzajGminy())
        );

        Miejscowosc miejscowosc = new Miejscowosc(
                new Simc(unwrap(soap.getSymbolSimc())),
                unwrap(soap.getMiejscowosc()),
                null,
                null,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );

        return new Ulica(
                new Ulic(unwrap(soap.getSymbol())),
                unwrap(soap.getNazwa()),
                unwrap(soap.getCecha()),
                miejscowosc,
                gmina,
                gmina != null ? gmina.powiat() : null,
                gmina != null ? gmina.wojewodztwo() : null
        );
    }

    private static Gmina toGmina(String woj, String wojNazwa, String pow, String powNazwa, String gmi, String gmiNazwa, String rodz) {
        Wojewodztwo wojewodztwo = woj != null ? new Wojewodztwo(new Terc(woj), wojNazwa, null) : null;
        Powiat powiat = (woj != null && pow != null) ? new Powiat(new Terc(woj + pow), powNazwa, null, wojewodztwo, null) : null;
        return (woj != null && pow != null && gmi != null) ? new Gmina(new Terc(woj + pow + gmi + (rodz != null ? rodz : EMPTY)), gmiNazwa, RodzajGminy.fromValue(rodz), powiat, wojewodztwo, null) : null;
    }

    public static pl.bajty.teryt.model.dto.ZweryfikowanyAdres toZweryfikowanyAdres(pl.bajty.teryt.internal.soap.generated.ZweryfikowanyAdres soap) {
        return new pl.bajty.teryt.model.dto.ZweryfikowanyAdres(
                unwrap(soap.getNazwaWoj()),
                unwrap(soap.getSymbolWoj()),
                unwrap(soap.getNazwaPow()),
                unwrap(soap.getSymbolPow()),
                unwrap(soap.getNazwaGmi()),
                unwrap(soap.getSymbolGmi()),
                unwrap(soap.getRodzajGmi()),
                unwrap(soap.getSymbolRodzajuGmi()),
                unwrap(soap.getNazwaMiejscowosci()),
                unwrap(soap.getSymbolMiejscowosci()),
                unwrap(soap.getRodzajMiejscowosci()),
                unwrap(soap.getHistorycznyRodzajMiejscowosci()),
                unwrap(soap.getNazwaUlicyWPelnymBrzmieniu()),
                unwrap(soap.getSymUl()),
                unwrap(soap.getNazwaCechy())
        );
    }

    public static pl.bajty.teryt.model.dto.ZweryfikowanyAdres toZweryfikowanyAdres(pl.bajty.teryt.internal.soap.generated.ZweryfikowanyAdresBezUlic soap) {
        return new pl.bajty.teryt.model.dto.ZweryfikowanyAdres(
                unwrap(soap.getNazwaWoj()),
                unwrap(soap.getSymbolWoj()),
                unwrap(soap.getNazwaPow()),
                unwrap(soap.getSymbolPow()),
                unwrap(soap.getNazwaGmi()),
                unwrap(soap.getSymbolGmi()),
                unwrap(soap.getRodzajGmi()),
                unwrap(soap.getSymbolRodzajuGmi()),
                unwrap(soap.getNazwaMiejscowosci()),
                unwrap(soap.getSymbolMiejscowosci()),
                unwrap(soap.getRodzajMiejscowosci()),
                unwrap(soap.getHistorycznyRodzajMiejscowosci()),
                null,
                null,
                null
        );
    }

    public static String unwrap(JAXBElement<String> element) {
        return (element == null || element.isNil()) ? null : element.getValue();
    }

    public static LocalDate parseDate(String rawDate) {
        if (rawDate == null || rawDate.isBlank()) {
            return null;
        }

        String trimmedDate = rawDate.trim();

        try {
            if (ISO_DATE_PREFIX_PATTERN.matcher(trimmedDate).matches()) {
                String dateOnly = trimmedDate.contains(DATE_SEPARATOR_T) ? trimmedDate.split(DATE_SEPARATOR_T)[0] : trimmedDate;
                return LocalDate.parse(dateOnly, DateTimeFormatter.ISO_LOCAL_DATE);
            }

            if (trimmedDate.contains(DATE_SEPARATOR_SLASH)) {
                String dateOnly = trimmedDate.split(DATE_SEPARATOR_SPACE)[0];
                return LocalDate.parse(dateOnly, WEIRD_GUS_FORMATTER);
            }

        } catch (DateTimeParseException e) {
            throw new IllegalStateException("Nieznany format daty zwrócony przez API GUS: " + rawDate, e);
        }

        throw new IllegalStateException("Nieobsługiwany wzorzec daty z API GUS: " + rawDate);
    }

    public static XMLGregorianCalendar toXmlGregorianCalendar(LocalDate date) {
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