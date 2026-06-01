package pl.bajty.teryt.internal;

import jakarta.xml.bind.JAXBElement;
import pl.bajty.teryt.internal.soap.generated.JednostkaNomenklaturyNTS;
import pl.bajty.teryt.internal.soap.generated.JednostkaTerytorialna;
import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.CechaUlicy;
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
                RodzajPowiatu.fromKod(unwrap(soap.getRODZ())),
                wojewodztwo,
                wojewodztwo.stanNa()
        );
    }

    public static Gmina toGmina(JednostkaTerytorialna soap) {
        Wojewodztwo wojewodztwo = toWojewodztwo(soap);
        String rodsGmi = unwrap(soap.getRODZ());

        String tercValue = unwrap(soap.getWOJ()) + unwrap(soap.getPOW()) + unwrap(soap.getGMI()) + (rodsGmi != null ? rodsGmi : EMPTY);
        if (tercValue.length() == 6 && rodsGmi == null) {
            throw new IllegalArgumentException("Brak rodzaju gminy (RODZ) dla jednostki: " + unwrap(soap.getNAZWA()));
        }

        return new Gmina(
                new Terc(tercValue),
                unwrap(soap.getNAZWA()),
                RodzajGminy.fromKod(rodsGmi),
                new Powiat(
                        new Terc(unwrap(soap.getWOJ()) + unwrap(soap.getPOW())),
                        null,
                        null,
                        wojewodztwo,
                        wojewodztwo.stanNa()
                ),
                wojewodztwo.stanNa()
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
                gmina
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
                RodzajMiejscowosci.fromKod(unwrap(soap.getRM())),
                symPodst != null ? new Simc(symPodst) : null,
                gmina
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
                gmina
        );

        return new Ulica(
                new Ulic(unwrap(soap.getIdentyfikatorUlicy())),
                unwrap(soap.getNazwa()),
                CechaUlicy.fromKod(unwrap(soap.getCecha())),
                miejscowosc
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
                gmina
        );

        String nazwa1 = unwrap(soap.getNazwa1());
        String nazwa2 = unwrap(soap.getNazwa2());
        String nazwaPelna = (nazwa2 != null && !nazwa2.isBlank()) ? nazwa2 + " " + nazwa1 : nazwa1;

        return new Ulica(
                new Ulic(unwrap(soap.getSymbolUlicy())),
                nazwaPelna,
                CechaUlicy.fromKod(unwrap(soap.getCecha())),
                miejscowosc
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
                gmina
        );

        return new Ulica(
                new Ulic(unwrap(soap.getSymbol())),
                unwrap(soap.getNazwa()),
                CechaUlicy.fromKod(unwrap(soap.getCecha())),
                miejscowosc
        );
    }

    private static Gmina toGmina(String woj, String wojNazwa, String pow, String powNazwa, String gmi, String gmiNazwa, String rodz) {
        Wojewodztwo wojewodztwo = null;
        if (woj != null && (woj.length() == 2 || woj.length() == 4 || woj.length() == 7)) {
            wojewodztwo = new Wojewodztwo(new Terc(woj), wojNazwa, null);
        }

        Powiat powiat = null;
        if (woj != null && pow != null) {
            String powTerc = woj + pow;
            if (powTerc.length() == 2 || powTerc.length() == 4 || powTerc.length() == 7) {
                powiat = new Powiat(new Terc(powTerc), powNazwa, null, wojewodztwo, null);
            }
        }

        if (woj != null && pow != null && gmi != null) {
            String rodsGmi = (rodz != null ? rodz : EMPTY);
            String gmiTerc = woj + pow + gmi + rodsGmi;
            if (gmiTerc.length() == 6 && rodsGmi.isEmpty()) {
                return null;
            }
            if (gmiTerc.length() == 2 || gmiTerc.length() == 4 || gmiTerc.length() == 7) {
                return new Gmina(new Terc(gmiTerc), gmiNazwa, RodzajGminy.fromKod(rodz), powiat, null);
            }
        }
        return null;
    }

    public static pl.bajty.teryt.model.dto.ZweryfikowanyAdres toZweryfikowanyAdres(pl.bajty.teryt.internal.soap.generated.ZweryfikowanyAdres soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getSymbolWoj()),
                unwrap(soap.getNazwaWoj()),
                unwrap(soap.getSymbolPow()),
                unwrap(soap.getNazwaPow()),
                unwrap(soap.getSymbolGmi()),
                unwrap(soap.getNazwaGmi()),
                unwrap(soap.getSymbolRodzajuGmi())
        );

        Miejscowosc miejscowosc = new Miejscowosc(
                new Simc(unwrap(soap.getSymbolMiejscowosci())),
                unwrap(soap.getNazwaMiejscowosci()),
                RodzajMiejscowosci.fromKod(unwrap(soap.getRodzajMiejscowosci())),
                null,
                gmina
        );

        Ulica ulica = null;
        if (unwrap(soap.getSymUl()) != null) {
            ulica = new Ulica(
                    new Ulic(unwrap(soap.getSymUl())),
                    unwrap(soap.getNazwaUlicyWPelnymBrzmieniu()),
                    CechaUlicy.fromKod(unwrap(soap.getNazwaCechy())),
                    miejscowosc
            );
        }

        return new pl.bajty.teryt.model.dto.ZweryfikowanyAdres(miejscowosc, ulica);
    }

    public static pl.bajty.teryt.model.dto.ZweryfikowanyAdres toZweryfikowanyAdres(pl.bajty.teryt.internal.soap.generated.ZweryfikowanyAdresBezUlic soap) {
        Gmina gmina = toGmina(
                unwrap(soap.getSymbolWoj()),
                unwrap(soap.getNazwaWoj()),
                unwrap(soap.getSymbolPow()),
                unwrap(soap.getNazwaPow()),
                unwrap(soap.getSymbolGmi()),
                unwrap(soap.getNazwaGmi()),
                unwrap(soap.getSymbolRodzajuGmi())
        );

        Miejscowosc miejscowosc = new Miejscowosc(
                new Simc(unwrap(soap.getSymbolMiejscowosci())),
                unwrap(soap.getNazwaMiejscowosci()),
                RodzajMiejscowosci.fromKod(unwrap(soap.getRodzajMiejscowosci())),
                null,
                gmina
        );

        return new pl.bajty.teryt.model.dto.ZweryfikowanyAdres(miejscowosc, null);
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

    public static Region toRegion(JednostkaNomenklaturyNTS soap) {
        return new Region(
                unwrap(soap.getREGION()),
                unwrap(soap.getNAZWA()),
                parseDate(unwrap(soap.getSTANNA()))
        );
    }

    public static Podregion toPodregion(JednostkaNomenklaturyNTS soap) {
        return new Podregion(
                unwrap(soap.getPODREG()),
                unwrap(soap.getNAZWA()),
                new Terc(unwrap(soap.getWOJ())),
                null,
                parseDate(unwrap(soap.getSTANNA()))
        );
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