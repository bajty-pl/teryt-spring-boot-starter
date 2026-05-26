package pl.bajty.teryt.api;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.Wojewodztwo;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Testy WireMock dla operacji TERC (podział terytorialny — województwa).
 */
@DisplayName("TercService — PobierzListeWojewodztw")
class TercServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_POBIERZ_LISTE_WOJEWODZTW = "ITerytWs1/PobierzListeWojewodztw";
    private static final String RESPONSE_POBIERZ_LISTE_WOJEWODZTW = "PobierzListeWojewodztwResponse.xml";

    @Test
    @DisplayName("getWojewodztwa() używa bieżącej daty i zwraca listę")
    void getWojewodztwaShouldReturnListUsingCurrentDate() {
        stubSoapOk(ACTION_POBIERZ_LISTE_WOJEWODZTW, RESPONSE_POBIERZ_LISTE_WOJEWODZTW);

        List<Wojewodztwo> wojewodztwa = terytClient.getWojewodztwa();

        assertThat(wojewodztwa).hasSize(2);
        assertThat(wojewodztwa)
                .extracting(w -> w.id().value(), Wojewodztwo::nazwa)
                .containsExactlyInAnyOrder(
                        Tuple.tuple("14", "MAZOWIECKIE"),
                        Tuple.tuple("12", "MAŁOPOLSKIE")
                );

        String today = LocalDate.now().toString();
        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_WOJEWODZTW)
                .withRequestBody(containing(today)));
    }

    @Test
    @DisplayName("getWojewodztwa(date) przekazuje datę do serwisu")
    void getWojewodztwaWithDateShouldPassDateToService() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        stubSoapOk(ACTION_POBIERZ_LISTE_WOJEWODZTW, RESPONSE_POBIERZ_LISTE_WOJEWODZTW);

        List<Wojewodztwo> wojewodztwa = terytClient.getWojewodztwa(date);

        assertThat(wojewodztwa).hasSize(2);
        assertThat(wojewodztwa)
                .anyMatch(w -> "14".equals(w.id().value()) && "MAZOWIECKIE".equalsIgnoreCase(w.nazwa()))
                .allMatch(w -> w.stanNa() != null && w.stanNa().equals(date));

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_WOJEWODZTW)
                .withRequestBody(containing(date.toString())));
    }

    @Test
    @DisplayName("getWojewodztwa() rzuca wyjątek gdy serwis zwraca HTTP 500")
    void getWojewodztwaShouldThrowOnHttp500() {
        stubSoapResponse(ACTION_POBIERZ_LISTE_WOJEWODZTW, 500,
                soapFault("s:Server", "Service unavailable"));

        assertThatThrownBy(() -> terytClient.getWojewodztwa())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("getWojewodztwa() rzuca wyjątek dla niepoprawnego XML w odpowiedzi")
    void getWojewodztwaShouldThrowOnMalformedXml() {
        stubSoapResponse(ACTION_POBIERZ_LISTE_WOJEWODZTW, 200, "<broken><xml>");

        assertThatThrownBy(() -> terytClient.getWojewodztwa())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("getWojewodztwa() rzuca wyjątek dla HTTP 404 (brak endpointu)")
    void getWojewodztwaShouldThrowOnHttp404() {
        stubSoapResponse(ACTION_POBIERZ_LISTE_WOJEWODZTW, 404, "");

        assertThatThrownBy(() -> terytClient.getWojewodztwa())
                .isInstanceOf(RuntimeException.class);
    }
}
