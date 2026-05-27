package pl.bajty.teryt.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bajty.teryt.model.RodzajKatalogu;
import pl.bajty.teryt.model.Wojewodztwo;

import java.time.LocalDate;
import java.util.List;

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
        var wojId = new pl.bajty.teryt.model.Terc("14"); // Mazowieckie

        List<pl.bajty.teryt.model.Powiat> powiaty = terytClient.getPowiaty(wojId, safeDate);

        assertThat(powiaty)
                .isNotNull()
                .isNotEmpty();

        assertThat(powiaty.getFirst().wojewodztwo().id().value()).isEqualTo("14");
    }

    @Test
    void shouldFetchGminyForPowiat() {
        LocalDate safeDate = LocalDate.of(2024, 1, 1);
        var wojId = new pl.bajty.teryt.model.Terc("14");
        var powId = new pl.bajty.teryt.model.Terc("1402"); // ciechanowski

        List<pl.bajty.teryt.model.Gmina> gminy = terytClient.getGminy(powId, wojId, safeDate);

        assertThat(gminy)
                .isNotNull()
                .isNotEmpty();

        assertThat(gminy.getFirst().powiat().id().value()).isEqualTo("1402");
    }
}
