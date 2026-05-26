package pl.bajty.teryt.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Testy WireMock dla operacji autoryzacji/diagnostyki ({@code CzyZalogowany}).
 */
@DisplayName("AuthService — CzyZalogowany")
class AuthServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_CZY_ZALOGOWANY = "ITerytWs1/CzyZalogowany";
    private static final String RESPONSE_CZY_ZALOGOWANY = "CzyZalogowanyResponse.xml";

    @Test
    @DisplayName("isLoggedIn() zwraca true gdy serwis potwierdza zalogowanie")
    void isLoggedInShouldReturnTrueWhenServiceConfirmsLogin() {
        stubSoapOk(ACTION_CZY_ZALOGOWANY, RESPONSE_CZY_ZALOGOWANY);

        boolean result = terytClient.isLoggedIn();

        assertThat(result).isTrue();
        wireMockServer.verify(verifySoapAction(ACTION_CZY_ZALOGOWANY)
                .withRequestBody(containing(WS_SECURITY_USERNAME_TOKEN))
                .withRequestBody(containing(USERNAME)));
    }

    @Test
    @DisplayName("isLoggedIn() przekazuje hasło w nagłówku WS-Security")
    void isLoggedInShouldSendPasswordInWsSecurityHeader() {
        stubSoapOk(ACTION_CZY_ZALOGOWANY, RESPONSE_CZY_ZALOGOWANY);

        terytClient.isLoggedIn();

        wireMockServer.verify(verifySoapAction(ACTION_CZY_ZALOGOWANY)
                .withRequestBody(containing(PASSWORD)));
    }

    @Test
    @DisplayName("isLoggedIn() rzuca wyjątek gdy serwis zwraca HTTP 500")
    void isLoggedInShouldThrowOnHttp500() {
        stubSoapResponse(ACTION_CZY_ZALOGOWANY, 500, soapFault("s:Server", "Internal error"));

        assertThatThrownBy(() -> terytClient.isLoggedIn())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("isLoggedIn() rzuca wyjątek przy SOAP Fault (HTTP 500 + faultstring)")
    void isLoggedInShouldThrowOnSoapFault() {
        stubSoapResponse(ACTION_CZY_ZALOGOWANY, 500,
                soapFault("s:Client", "Nieprawidłowe dane uwierzytelniające"));

        assertThatThrownBy(() -> terytClient.isLoggedIn())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("isLoggedIn() rzuca wyjątek dla niepoprawnego XML w odpowiedzi")
    void isLoggedInShouldThrowOnMalformedXml() {
        stubSoapResponse(ACTION_CZY_ZALOGOWANY, 200, "<<<not-an-xml>>>");

        assertThatThrownBy(() -> terytClient.isLoggedIn())
                .isInstanceOf(RuntimeException.class);
    }
}
