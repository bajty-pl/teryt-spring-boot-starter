package pl.bajty.teryt.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
