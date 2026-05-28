package pl.bajty.teryt.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.dto.Simc;
import pl.bajty.teryt.model.dto.Ulica;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("UlicService — Przeglądanie ulic (ULIC)")
class UlicServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_POBIERZ_LISTE_ULIC_DLA_MIEJSCOWOSCI = "ITerytWs1/PobierzListeUlicDlaMiejscowosci";
    private static final String RESPONSE_POBIERZ_LISTE_ULIC_DLA_MIEJSCOWOSCI = "PobierzListeUlicDlaMiejscowosciResponse.xml";

    private static final String ACTION_WYSZUKAJ_ULICE = "ITerytWs1/WyszukajUlice";
    private static final String RESPONSE_WYSZUKAJ_ULICE = "WyszukajUliceResponse.xml";

    private static final String ACTION_POBIERZ_SLOWNIK_CECH_ULIC = "ITerytWs1/PobierzSlownikCechULIC";
    private static final String RESPONSE_POBIERZ_SLOWNIK_CECH_ULIC = "PobierzSlownikCechULICResponse.xml";

    @Test
    @DisplayName("getSlownikCechULIC() zwraca listę cech")
    void getSlownikCechULICShouldReturnList() {
        stubSoapOk(ACTION_POBIERZ_SLOWNIK_CECH_ULIC, RESPONSE_POBIERZ_SLOWNIK_CECH_ULIC);

        var cechy = terytClient.getSlownikCechULIC();

        assertThat(cechy).isNotEmpty();
        assertThat(cechy.stream().map(s -> s.getNazwa())).contains("ul.", "al.", "pl.", "skwer");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_SLOWNIK_CECH_ULIC));
    }

    @Test
    @DisplayName("getUlice(mscId, stanNa) zwraca listę ulic")
    void getUliceShouldReturnList() {
        stubSoapOk(ACTION_POBIERZ_LISTE_ULIC_DLA_MIEJSCOWOSCI, RESPONSE_POBIERZ_LISTE_ULIC_DLA_MIEJSCOWOSCI);

        Simc mscId = new Simc("0928525");
        List<Ulica> ulice = terytClient.getUlice(mscId, LocalDate.of(2024, 1, 1));

        assertThat(ulice).hasSize(1);
        Ulica u = ulice.getFirst();
        assertThat(u.id().value()).isEqualTo("00012");
        assertThat(u.nazwa()).isEqualTo("Akacjowa");
        assertThat(u.miejscowosc().id().value()).isEqualTo("0928525");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_ULIC_DLA_MIEJSCOWOSCI)
                .withRequestBody(containing("0928525")));
    }

    @Test
    @DisplayName("wyszukajUlice(nazwa) zwraca listę ulic")
    void wyszukajUliceShouldReturnList() {
        stubSoapOk(ACTION_WYSZUKAJ_ULICE, RESPONSE_WYSZUKAJ_ULICE);

        List<Ulica> ulice = terytClient.wyszukajUlice("Akacjowa");

        assertThat(ulice).hasSize(1);
        Ulica u = ulice.getFirst();
        assertThat(u.nazwa()).isEqualTo("Akacjowa");
        assertThat(u.id().value()).isEqualTo("00012");

        wireMockServer.verify(verifySoapAction(ACTION_WYSZUKAJ_ULICE)
                .withRequestBody(containing("Akacjowa")));
    }
}
