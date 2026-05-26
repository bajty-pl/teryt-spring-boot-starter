package pl.bajty.teryt.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import pl.bajty.teryt.model.Wojewodztwo;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TerytClientWireMockTest {

    private static final String SERVICE_PATH = "/TerytWs1.svc";
    private static WireMockServer wireMockServer;

    @Autowired
    private TerytClient terytClient;

    @BeforeAll
    static void startWireMock() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().dynamicPort());
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
    }

    @AfterAll
    static void stopWireMock() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("teryt.url", () -> "http://localhost:" + wireMockServer.port() + SERVICE_PATH);
        registry.add("teryt.username", () -> "TestPubliczny");
        registry.add("teryt.password", () -> "1234abcd");
        registry.add("teryt.test-environment", () -> "false");
    }

    @Test
    void isLoggedInShouldReturnTrueWhenServiceConfirmsLogin() {
        wireMockServer.stubFor(post(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing("ITerytWs1/CzyZalogowany"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(loadResponse("CzyZalogowanyResponse.xml"))));

        boolean result = terytClient.isLoggedIn();

        assertThat(result).isTrue();
        wireMockServer.verify(WireMock.postRequestedFor(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing("ITerytWs1/CzyZalogowany"))
                .withRequestBody(containing("UsernameToken"))
                .withRequestBody(containing("TestPubliczny")));
    }

    @Test
    void getWojewodztwaShouldReturnListUsingCurrentDate() {
        wireMockServer.stubFor(post(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing("ITerytWs1/PobierzListeWojewodztw"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(loadResponse("PobierzListeWojewodztwResponse.xml"))));

        List<Wojewodztwo> wojewodztwa = terytClient.getWojewodztwa();

        assertThat(wojewodztwa).hasSize(2);
        assertThat(wojewodztwa)
                .extracting(w -> w.id().value(), Wojewodztwo::nazwa)
                .containsExactlyInAnyOrder(
                        org.assertj.core.groups.Tuple.tuple("14", "MAZOWIECKIE"),
                        org.assertj.core.groups.Tuple.tuple("12", "MAŁOPOLSKIE")
                );

        String today = LocalDate.now().toString();
        wireMockServer.verify(WireMock.postRequestedFor(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing("ITerytWs1/PobierzListeWojewodztw"))
                .withRequestBody(containing(today)));
    }

    @Test
    void getWojewodztwaWithDateShouldPassDateToService() {
        LocalDate date = LocalDate.of(2024, 1, 1);

        wireMockServer.stubFor(post(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing("ITerytWs1/PobierzListeWojewodztw"))
                .withRequestBody(containing("2024-01-01"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(loadResponse("PobierzListeWojewodztwResponse.xml"))));

        List<Wojewodztwo> wojewodztwa = terytClient.getWojewodztwa(date);

        assertThat(wojewodztwa).hasSize(2);
        assertThat(wojewodztwa)
                .anyMatch(w -> "14".equals(w.id().value()) && "MAZOWIECKIE".equalsIgnoreCase(w.nazwa()))
                .allMatch(w -> w.stanNa() != null && w.stanNa().equals(date));

        wireMockServer.verify(WireMock.postRequestedFor(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing("ITerytWs1/PobierzListeWojewodztw"))
                .withRequestBody(containing("2024-01-01")));
    }

    private static String loadResponse(String fileName) {
        try (var is = TerytClientWireMockTest.class.getResourceAsStream("/wiremock/" + fileName)) {
            if (is == null) {
                throw new IllegalStateException("Brak pliku odpowiedzi WireMock: " + fileName);
            }
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        } catch (java.io.IOException e) {
            throw new IllegalStateException("Nie można wczytać pliku odpowiedzi: " + fileName, e);
        }
    }
}
