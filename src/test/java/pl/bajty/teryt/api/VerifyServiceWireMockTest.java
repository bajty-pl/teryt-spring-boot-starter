package pl.bajty.teryt.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.dto.Simc;
import pl.bajty.teryt.model.dto.ZweryfikowanyAdres;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("VerifyService — Weryfikacja adresów")
class VerifyServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_WYSZUKAJ_MIEJSCOWOSC = "ITerytWs1/WyszukajMiejscowosc";
    private static final String RESPONSE_WYSZUKAJ_MIEJSCOWOSC = "WyszukajMiejscowoscResponse.xml";

    private static final String ACTION_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI = "ITerytWs1/WeryfikujAdresDlaMiejscowosci";
    private static final String RESPONSE_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI = "WeryfikujAdresDlaMiejscowosciResponse.xml";

    private static final String ACTION_WYSZUKAJ_ULICE = "ITerytWs1/WyszukajUlice";
    private static final String RESPONSE_WYSZUKAJ_ULICE = "WyszukajUliceResponse.xml";

    private static final String ACTION_WERYFIKUJ_ADRES_DLA_ULIC = "ITerytWs1/WeryfikujAdresDlaUlic";
    private static final String RESPONSE_WERYFIKUJ_ADRES_DLA_ULIC = "WeryfikujAdresDlaUlicResponse.xml";

    @Test
    @DisplayName("weryfikujAdresDlaMiejscowosci(nazwa) zwraca zweryfikowany adres")
    void weryfikujAdresDlaMiejscowosciShouldReturnList() {
        stubSoapOk(ACTION_WYSZUKAJ_MIEJSCOWOSC, RESPONSE_WYSZUKAJ_MIEJSCOWOSC);
        stubSoapOk(ACTION_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI, RESPONSE_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI);

        List<ZweryfikowanyAdres> adresy = terytClient.weryfikujAdresDlaMiejscowosci("Ciechanów");

        assertThat(adresy).hasSize(1);
        ZweryfikowanyAdres a = adresy.getFirst();
        assertThat(a.miejscowosc().nazwa()).isEqualTo("Ciechanów");
        assertThat(a.miejscowosc().id().value()).isEqualTo("0928525");

        wireMockServer.verify(verifySoapAction(ACTION_WYSZUKAJ_MIEJSCOWOSC).withRequestBody(containing("Ciechanów")));
        wireMockServer.verify(verifySoapAction(ACTION_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI).withRequestBody(containing("0928525")));
    }

    @Test
    @DisplayName("weryfikujAdresWMiejscowosci(nazwa, sym) zwraca zweryfikowany adres")
    void weryfikujAdresWMiejscowosciShouldReturnList() {
        stubSoapOk(ACTION_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI, RESPONSE_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI);

        List<ZweryfikowanyAdres> adresy = terytClient.weryfikujAdresWMiejscowosci("Ciechanów", new Simc("0928525"));

        assertThat(adresy).hasSize(1);
        assertThat(adresy.getFirst().miejscowosc().id().value()).isEqualTo("0928525");

        wireMockServer.verify(verifySoapAction(ACTION_WERYFIKUJ_ADRES_DLA_MIEJSCOWOSCI).withRequestBody(containing("0928525")));
    }

    @Test
    @DisplayName("weryfikujAdresDlaUlic(ulica, msc) zwraca zweryfikowany adres z ulicą")
    void weryfikujAdresDlaUlicShouldReturnList() {
        stubSoapOk(ACTION_WYSZUKAJ_ULICE, RESPONSE_WYSZUKAJ_ULICE);
        stubSoapOk(ACTION_WERYFIKUJ_ADRES_DLA_ULIC, RESPONSE_WERYFIKUJ_ADRES_DLA_ULIC);

        List<ZweryfikowanyAdres> adresy = terytClient.weryfikujAdresDlaUlic("Akacjowa", "Ciechanów");

        assertThat(adresy).hasSize(1);
        ZweryfikowanyAdres a = adresy.getFirst();
        assertThat(a.ulica().nazwa()).isEqualTo("Akacjowa");
        assertThat(a.ulica().id().value()).isEqualTo("00012");

        wireMockServer.verify(verifySoapAction(ACTION_WYSZUKAJ_ULICE).withRequestBody(containing("Akacjowa")));
        wireMockServer.verify(verifySoapAction(ACTION_WERYFIKUJ_ADRES_DLA_ULIC).withRequestBody(containing("00012")));
    }
}
