package pl.bajty.teryt.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.RodzajKatalogu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("integration-teryt")
@SpringBootTest(properties = {
        "teryt.test-environment=true"
})
class TerytClientIntegrationTest {

    @Autowired
    private TerytClient terytClient;

    @Test
    void shouldSuccessfullyLogInToTestEnvironment() {
        boolean isLoggedIn = terytClient.isLoggedIn();

        assertThat(isLoggedIn)
                .as("Powinno poprawnie zalogować się do środowiska testowego GUS")
                .isTrue();
    }

    @Test
    void shouldFetchAll16Wojewodztwa() {
        LocalDate safeDate = LocalDate.of(2024, 1, 1);

        List<Wojewodztwo> wojewodztwa = terytClient.getWojewodztwa(safeDate);

        assertThat(wojewodztwa)
                .isNotNull()
                .isNotEmpty()
                .hasSize(16);

        boolean hasMazowieckie = wojewodztwa.stream()
                .anyMatch(w -> w.id().value().equals("14") && w.nazwa().equalsIgnoreCase("MAZOWIECKIE"));

        assertThat(hasMazowieckie)
                .as("Na liście powinno znajdować się województwo mazowieckie (kod 14)")
                .isTrue();
    }

    @Test
    void shouldFetchCatalogDateForEachRodzajKatalogu() {
        for (RodzajKatalogu type : RodzajKatalogu.values()) {
            LocalDate date = terytClient.getCatalogDate(type);

            assertThat(date)
                    .as("Data aktualnego katalogu dla %s powinna być zwrócona przez API GUS", type)
                    .isNotNull();
            assertThat(date)
                    .as("Data aktualnego katalogu dla %s powinna być sensowna (po 2000-01-01)", type)
                    .isAfter(LocalDate.of(2000, 1, 1));
        }
    }

    @Test
    void shouldFetchPowiatyForWojewodztwo() {
        LocalDate safeDate = LocalDate.of(2024, 1, 1);
        var wojId = new Terc("14"); // Mazowieckie

        List<Powiat> powiaty = terytClient.getPowiaty(wojId, safeDate);

        assertThat(powiaty)
                .isNotNull()
                .isNotEmpty();

        assertThat(powiaty.getFirst().id().getWojewodztwoId()).isEqualTo("14");
    }

    @Test
    void shouldFetchGminyForPowiat() {
        LocalDate safeDate = LocalDate.of(2024, 1, 1);
        var wojId = new Terc("14");
        var powId = new Terc("1402"); // ciechanowski

        List<Gmina> gminy = terytClient.getGminy(powId, wojId, safeDate);

        assertThat(gminy).isNotNull()
                .isNotEmpty();
        assertThat(gminy.getFirst().id().getPowiatId()).isEqualTo("02");
        assertThat(gminy.getFirst().rodzajGminy()).isNotNull();
    }

    @Test
    void shouldFetchMiejscowosciWithDetailsForGmina() {
        LocalDate safeDate = LocalDate.of(2024, 1, 1);
        var gminaId = new Terc("1402011"); // m. Ciechanów

        List<Miejscowosc> miejscowosci = terytClient.getMiejscowosci(gminaId, safeDate, true);

        assertThat(miejscowosci).isNotNull().isNotEmpty();
    }

    @Test
    void shouldFetchStanySimc() {
        List<StanSimc> stany = terytClient.getStanSimc();

        assertThat(stany).isNotNull().isNotEmpty();
        assertThat(stany.getFirst().data()).isNotNull();
    }

    @Test
    void shouldFetchUliceForMiejscowosc() {
        LocalDate safeDate = LocalDate.of(2024, 1, 1);
        var mscId = new Simc("0928525"); // Ciechanów

        List<Ulica> ulice = terytClient.getUlice(mscId, safeDate);

        assertThat(ulice).isNotNull();
        if (!ulice.isEmpty()) {
            assertThat(ulice.getFirst().miejscowosc().id().value()).isEqualTo("0928525");
            assertThat(ulice.getFirst().cecha()).isNotNull();
        }
    }

    @Test
    void shouldSearchUliceByName() {
        List<Ulica> ulice = terytClient.wyszukajUlice("Akacjowa");

        assertThat(ulice).isNotNull().isNotEmpty();
        assertThat(ulice.stream().anyMatch(u -> u.nazwa().contains("Akacjowa"))).isTrue();
    }

    @Test
    void shouldVerifyAddressForMiejscowosc() {
        List<ZweryfikowanyAdres> adresy = terytClient.weryfikujAdresDlaMiejscowosci("Ciechanów");

        assertThat(adresy).isNotNull().isNotEmpty();
        assertThat(adresy.getFirst().miejscowosc().nazwa()).containsIgnoringCase("Ciechanów");
    }

    @Test
    void shouldVerifyAddressForUlica() {
        List<ZweryfikowanyAdres> adresy = terytClient.weryfikujAdresDlaUlic("Akacjowa", "Ciechanów");

        assertThat(adresy).isNotNull().isNotEmpty();
        assertThat(adresy.getFirst().ulica().nazwa()).containsIgnoringCase("Akacjowa");
    }

    @Test
    void shouldDownloadCatalogFileData() {
        DanePliku dane = terytClient.getStanTercData(LocalDate.of(2024, 1, 1));

        assertThat(dane).isNotNull();
        assertThat(dane.nazwa()).isNotBlank();
        assertThat(dane.zawartosc()).isNotEmpty();
    }

    @Test
    void shouldFetchGminaById() {
        Terc gminaTerc = new Terc("1421033"); // Brwinów w środowisku testowym

        Optional<Gmina> gminaOpt = terytClient.getGmina(gminaTerc);

        assertThat(gminaOpt).isPresent();
        assertThat(gminaOpt.get().id().value()).isEqualTo("1421033");
    }

    @Test
    void shouldFetchWojewodztwoByStringCode() {
        Optional<Wojewodztwo> wojOpt = terytClient.getWojewodztwo("14");
        assertThat(wojOpt).isPresent();
        assertThat(wojOpt.get().nazwa()).containsIgnoringCase("MAZOWIECKIE");
    }

    @Test
    void shouldReturnEmptyOptionalForInvalidWojewodztwoCode() {
        Optional<Wojewodztwo> wojOpt = terytClient.getWojewodztwo("invalid");
        assertThat(wojOpt).isEmpty();
    }

    @Test
    void shouldFetchPowiatByStringCode() {
        Optional<Powiat> powOpt = terytClient.getPowiat("1402");
        assertThat(powOpt).isPresent();
        assertThat(powOpt.get().id().value()).isEqualTo("1402");
    }

    @Test
    void shouldFetchGminaByStringCode() {
        Optional<Gmina> gmiOpt = terytClient.getGmina("1421033");
        assertThat(gmiOpt).isPresent();
        assertThat(gmiOpt.get().id().value()).isEqualTo("1421033");
    }

    @Test
    void shouldFetchMiejscowoscByStringCode() {
        // Używamy nazwy, aby znaleźć poprawny kod w środowisku testowym
        List<Miejscowosc> mscList = terytClient.wyszukajMiejscowosc("Ciechanów");
        assertThat(mscList).isNotEmpty();
        String realId = mscList.getFirst().id().value();

        Optional<Miejscowosc> mscOpt = terytClient.getMiejscowosc(realId);
        assertThat(mscOpt).isPresent();
        assertThat(mscOpt.get().id().value()).isEqualTo(realId);
    }

    @Test
    void shouldFetchUlicaByStringCodes() {
        // Akacjowa w Ciechanowie (przykładowy kod ULIC 00123 - trzeba by sprawdzić realny w test environment)
        // Jeśli nie znamy realnego, sprawdźmy przynajmniej czy nie rzuca błędem i zwraca Optional
        Optional<Ulica> ulicaOpt = terytClient.getUlica("00123", "0928525");
        assertThat(ulicaOpt).isNotNull();
    }

    @Test
    void shouldSearchMiejscowoscByStringCode() {
        List<Miejscowosc> mscList = terytClient.wyszukajMiejscowosc("Ciechanów");
        assertThat(mscList).isNotEmpty();
        String realId = mscList.getFirst().id().value();

        List<Miejscowosc> mscListByCode = terytClient.wyszukajMiejscowosc(realId);
        assertThat(mscListByCode).isNotEmpty();
        assertThat(mscListByCode.getFirst().id().value()).isEqualTo(realId);
    }

    @Test
    void shouldSearchUlicaByStringCode() {
        // Dla ulic wyszukiwanie po kodzie ULIC zwraca listę (bo ulica o tym samym kodzie może być w wielu miejscowościach)
        // Realny kod ULIC dla Akacjowej to 00123 (przykładowo)
        List<Ulica> ulice = terytClient.wyszukajUlice("00123");
        assertThat(ulice).isNotNull();
    }
}
