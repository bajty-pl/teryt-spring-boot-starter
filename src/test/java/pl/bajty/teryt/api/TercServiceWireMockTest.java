package pl.bajty.teryt.api;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.dto.*;
import pl.bajty.teryt.model.enums.RodzajGminy;
import pl.bajty.teryt.model.enums.RodzajPowiatu;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Testy WireMock dla operacji TERC (podział terytorialny).
 */
@DisplayName("TercService — Przeglądanie struktury (TERC)")
class TercServiceWireMockTest extends AbstractTerytClientWireMockTest {

    private static final String ACTION_POBIERZ_KATALOG_TERC = "ITerytWs1/PobierzKatalogTERC";
    private static final String RESPONSE_POBIERZ_KATALOG_TERC = "PobierzKatalogTERCResponse.xml";

    private static final String ACTION_POBIERZ_LISTE_WOJEWODZTW = "ITerytWs1/PobierzListeWojewodztw";
    private static final String RESPONSE_POBIERZ_LISTE_WOJEWODZTW = "PobierzListeWojewodztwResponse.xml";

    private static final String ACTION_POBIERZ_LISTE_POWIATOW = "ITerytWs1/PobierzListePowiatow";
    private static final String RESPONSE_POBIERZ_LISTE_POWIATOW = "PobierzListePowiatowResponse.xml";

    private static final String ACTION_POBIERZ_LISTE_GMIN = "ITerytWs1/PobierzListeGmin";
    private static final String RESPONSE_POBIERZ_LISTE_GMIN = "PobierzListeGminResponse.xml";

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
    @DisplayName("getPowiaty(wojId, date) zwraca listę powiatów")
    void getPowiatyShouldReturnList() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        stubSoapOk(ACTION_POBIERZ_LISTE_POWIATOW, RESPONSE_POBIERZ_LISTE_POWIATOW);

        List<Powiat> powiaty = terytClient.getPowiaty(new Terc("14"), date);

        assertThat(powiaty).hasSize(1);
        Powiat p = powiaty.getFirst();
        assertThat(p.id().value()).isEqualTo("1402");
        assertThat(p.nazwa()).isEqualTo("ciechanowski");
        assertThat(p.rodzajPowiatu()).isEqualTo(RodzajPowiatu.POWIAT);
        assertThat(p.rodzajPowiatu().getKod()).isEqualTo("p");
        assertThat(p.rodzajPowiatu().getNazwa()).isEqualTo("Powiat");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_POWIATOW)
                .withRequestBody(containing("14"))
                .withRequestBody(containing(date.toString())));
    }

    @Test
    @DisplayName("getGminy(wojId, powId, date) zwraca listę gmin")
    void getGminyShouldReturnList() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        stubSoapOk(ACTION_POBIERZ_LISTE_GMIN, RESPONSE_POBIERZ_LISTE_GMIN);

        List<Gmina> gminy = terytClient.getGminy(new Terc("1402"), new Terc("14"), date);

        assertThat(gminy).hasSize(1);
        Gmina g = gminy.getFirst();
        assertThat(g.id().value()).isEqualTo("1402011");
        assertThat(g.nazwa()).isEqualTo("Ciechanów");
        assertThat(g.rodzajGminy()).isEqualTo(RodzajGminy.MIEJSKA);
        assertThat(g.rodzajGminy().getKod()).isEqualTo("1");
        assertThat(g.rodzajGminy().getNazwa()).isEqualTo("Gmina miejska");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_LISTE_GMIN)
                .withRequestBody(containing("14"))
                .withRequestBody(containing("02"))
                .withRequestBody(containing(date.toString())));
    }

    @Test
    @DisplayName("getStanTerc(date) zwraca PlikKatalogu")
    void getStanTercShouldReturnPlikKatalogu() {
        LocalDate date = LocalDate.of(2024, 5, 15);
        stubSoapOk(ACTION_POBIERZ_KATALOG_TERC, RESPONSE_POBIERZ_KATALOG_TERC);

        PlikKatalogu plik = terytClient.getStanTerc(date);

        assertThat(plik).isNotNull();
        assertThat(plik.nazwa()).isEqualTo("TERC_Urzedowy_2024-05-15.zip");
        assertThat(plik.opis()).isEqualTo("Katalog TERC stan na 2024-05-15");
        assertThat(plik.zawartosc()).isEqualTo("VGVzdG93YSB6YXdhcnRvxZvEhyBwbGlrdQ==");

        wireMockServer.verify(verifySoapAction(ACTION_POBIERZ_KATALOG_TERC)
                .withRequestBody(containing("2024-05-15")));
    }

    @Test
    @DisplayName("getWojewodztwa() rzuca wyjątek gdy serwis zwraca HTTP 500")
    void getWojewodztwaShouldThrowOnHttp500() {
        stubSoapResponse(ACTION_POBIERZ_LISTE_WOJEWODZTW, 500,
                soapFault("s:Server", "Service unavailable"));

        assertThatThrownBy(() -> terytClient.getWojewodztwa())
                .isInstanceOf(RuntimeException.class);
    }
}
