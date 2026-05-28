package pl.bajty.teryt.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.dto.Miejscowosc;
import pl.bajty.teryt.model.dto.StanSimc;
import pl.bajty.teryt.model.dto.Terc;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("SimcService — Przeglądanie miejscowości (SIMC)")
class SimcServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_POBIERZ_LISTE_MIEJSCOWOSCI_W_GMINIE = "ITerytWs1/PobierzListeMiejscowosciWGminie";
    private static final String RESPONSE_POBIERZ_LISTE_MIEJSCOWOSCI_W_GMINIE = "PobierzListeMiejscowosciWGminieResponse.xml";

    private static final String ACTION_POBIERZ_LISTE_STANOW_SIMC = "ITerytWs1/PobierzListeStanowSimc";
    private static final String RESPONSE_POBIERZ_LISTE_STANOW_SIMC = "PobierzListeStanowSimcResponse.xml";

    @Test
    @DisplayName("getStanSimc() zwraca listę stanów")
    void getStanSimcShouldReturnList() {
        stubSoapOk(ACTION_POBIERZ_LISTE_STANOW_SIMC, RESPONSE_POBIERZ_LISTE_STANOW_SIMC);

        List<StanSimc> stany = terytClient.getStanSimc();

        assertThat(stany).hasSize(2);
        assertThat(stany).extracting(StanSimc::data)
                .containsExactlyInAnyOrder(
                        LocalDate.of(2024, 1, 1),
                        LocalDate.of(2024, 5, 15)
                );

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_STANOW_SIMC));
    }

    @Test
    @DisplayName("getMiejscowosci(gminaId) zwraca listę miejscowości")
    void getMiejscowosciShouldReturnList() {
        stubSoapOk(ACTION_POBIERZ_LISTE_MIEJSCOWOSCI_W_GMINIE, RESPONSE_POBIERZ_LISTE_MIEJSCOWOSCI_W_GMINIE);

        Terc gminaId = new Terc("1402011");
        List<Miejscowosc> miejscowosci = terytClient.getMiejscowosci(gminaId);

        assertThat(miejscowosci).hasSize(1);
        Miejscowosc m = miejscowosci.getFirst();
        assertThat(m.id().value()).isEqualTo("0910626");
        assertThat(m.nazwa()).isEqualTo("Ciechanów");
        assertThat(m.gmina().powiat().wojewodztwo().nazwa()).isEqualTo("MAZOWIECKIE");
        assertThat(m.gmina().nazwa()).isEqualTo("Ciechanów");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_MIEJSCOWOSCI_W_GMINIE)
                .withRequestBody(containing("14"))
                .withRequestBody(containing("02"))
                .withRequestBody(containing("01")));
    }
}
