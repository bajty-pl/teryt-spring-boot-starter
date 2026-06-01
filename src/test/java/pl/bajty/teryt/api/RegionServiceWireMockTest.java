package pl.bajty.teryt.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.dto.Podregion;
import pl.bajty.teryt.model.dto.Region;
import pl.bajty.teryt.model.dto.Terc;
import pl.bajty.teryt.model.enums.Makroregion;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RegionService — Regiony i Podregiony (NUTS)")
class RegionServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_POBIERZ_LISTE_REGIONOW = "ITerytWs1/PobierzListeRegionow";
    private static final String RESPONSE_POBIERZ_LISTE_REGIONOW = "PobierzListeRegionowResponse.xml";

    private static final String ACTION_POBIERZ_LISTE_PODREGIONOW = "ITerytWs1/PobierzListePodregionow";
    private static final String RESPONSE_POBIERZ_LISTE_PODREGIONOW = "PobierzListePodregionowResponse.xml";

    @Test
    @DisplayName("getRegiony(stanNa) zwraca listę regionów")
    void getRegionyShouldReturnList() {
        stubSoapOk(ACTION_POBIERZ_LISTE_REGIONOW, RESPONSE_POBIERZ_LISTE_REGIONOW);

        List<Region> regiony = terytClient.getRegiony(LocalDate.of(2024, 1, 1));

        assertThat(regiony).hasSize(1);
        assertThat(regiony.getFirst().nazwa()).isEqualTo("REGION CENTRALNY");
        assertThat(regiony.getFirst().id()).isEqualTo("1");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_REGIONOW));
    }

    @Test
    @DisplayName("getPodregiony(wojId, stanNa) zwraca listę podregionów")
    void getPodregionyShouldReturnList() {
        stubSoapOk(ACTION_POBIERZ_LISTE_PODREGIONOW, RESPONSE_POBIERZ_LISTE_PODREGIONOW);

        List<Podregion> podregiony = terytClient.getPodregiony(new Terc("14"), LocalDate.of(2024, 1, 1));

        assertThat(podregiony).hasSize(1);
        assertThat(podregiony.getFirst().nazwa()).isEqualTo("Podregion ciechanowski");
        assertThat(podregiony.getFirst().id()).isEqualTo("1402");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_PODREGIONOW)
                .withRequestBody(containing("14")));
    }

    @Test
    @DisplayName("getMakroregion(wojId) zwraca makroregion na podstawie kodu TERC")
    void getMakroregionShouldReturnEnum() {
        Makroregion makroregion = terytClient.getMakroregion(new Terc("14"));
        assertThat(makroregion).isEqualTo(Makroregion.WOJEWODZTWO_MAZOWIECKIE);

        makroregion = terytClient.getMakroregion(new Terc("12"));
        assertThat(makroregion).isEqualTo(Makroregion.POLUDNIOWY);
    }
}
