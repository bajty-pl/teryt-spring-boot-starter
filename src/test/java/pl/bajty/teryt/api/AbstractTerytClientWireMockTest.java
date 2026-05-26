package pl.bajty.teryt.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Bazowa klasa testów WireMock dla {@link TerytClient}.
 * <p>
 * Zapewnia wspólną konfigurację WireMock (start/stop, reset między testami), rejestrację
 * dynamicznych właściwości Spring Boot oraz reużywalne helpery do stubowania i weryfikacji
 * żądań SOAP. Każdy konkretny serwis (Auth, Terc, Simc, Ulic, ...) powinien mieć własną
 * klasę testową dziedziczącą po tej bazie — dzięki temu pliki testowe pozostają krótkie
 * i łatwe w rozwoju.
 */
@SpringBootTest
public abstract class AbstractTerytClientWireMockTest {

    // ---------- Konfiguracja środowiska ----------
    protected static final String SERVICE_PATH = "/TerytWs1.svc";
    protected static final String USERNAME = "TestPubliczny";
    protected static final String PASSWORD = "1234abcd";
    protected static final String CONTENT_TYPE_SOAP = "text/xml; charset=utf-8";

    // ---------- Fragmenty XML / WS-Security ----------
    protected static final String WS_SECURITY_USERNAME_TOKEN = "UsernameToken";
    protected static final String SOAP_FAULT_TEMPLATE = "SoapFault.xml";

    protected static WireMockServer wireMockServer;

    @Autowired
    protected TerytClient terytClient;

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

    @AfterEach
    void resetWireMock() {
        wireMockServer.resetAll();
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("teryt.url", () -> "http://localhost:" + wireMockServer.port() + SERVICE_PATH);
        registry.add("teryt.username", () -> USERNAME);
        registry.add("teryt.password", () -> PASSWORD);
        registry.add("teryt.test-environment", () -> "false");
    }

    // =========================================================
    // Helpery — stubowanie i weryfikacja
    // =========================================================

    /**
     * Stub poprawnej odpowiedzi SOAP 200 dla wskazanej akcji, z body wczytanym z classpath.
     */
    protected static void stubSoapOk(String soapAction, String responseFile) {
        wireMockServer.stubFor(soapRequest(soapAction)
                .willReturn(soapResponse(200, loadResponse(responseFile))));
    }

    /**
     * Stub odpowiedzi z dowolnym statusem HTTP i ciałem.
     */
    protected static void stubSoapResponse(String soapAction, int httpStatus, String body) {
        wireMockServer.stubFor(soapRequest(soapAction)
                .willReturn(soapResponse(httpStatus, body)));
    }

    protected static MappingBuilder soapRequest(String soapAction) {
        return post(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing(soapAction));
    }

    protected static ResponseDefinitionBuilder soapResponse(int status, String body) {
        return aResponse()
                .withStatus(status)
                .withHeader("Content-Type", CONTENT_TYPE_SOAP)
                .withBody(body);
    }

    /**
     * Weryfikuje, że została wykonana prośba SOAP z daną akcją.
     */
    protected static RequestPatternBuilder verifySoapAction(String soapAction) {
        return postRequestedFor(urlEqualTo(SERVICE_PATH))
                .withRequestBody(containing(soapAction));
    }

    protected static String loadResponse(String fileName) {
        String path = "/wiremock/" + fileName;
        try (InputStream is = AbstractTerytClientWireMockTest.class.getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalStateException("Brak pliku odpowiedzi WireMock: " + path);
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Nie można wczytać pliku odpowiedzi: " + path, e);
        }
    }

    /**
     * Minimalny SOAP 1.1 Fault używany w czarnych scenariuszach. Szablon wczytywany z classpath.
     */
    protected static String soapFault(String faultcode, String faultstring) {
        return loadResponse(SOAP_FAULT_TEMPLATE).formatted(faultcode, faultstring);
    }
}
