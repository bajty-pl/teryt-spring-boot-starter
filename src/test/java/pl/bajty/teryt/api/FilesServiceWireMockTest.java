package pl.bajty.teryt.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import pl.bajty.teryt.model.enums.RodzajKatalogu;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Testy WireMock dla operacji plików katalogowych (FilesService).
 */
@DisplayName("FilesService — PobierzDateAktualnegoKat*")
class FilesServiceWireMockTest extends AbstractTerytClientWireMockTest {

    static Stream<Arguments> catalogDateScenarios() {
        return Stream.of(
                Arguments.of(RodzajKatalogu.TERC, "ITerytWs1/PobierzDateAktualnegoKatTerc",
                        "PobierzDateAktualnegoKatTercResponse.xml", LocalDate.of(2024, 5, 15)),
                Arguments.of(RodzajKatalogu.TERC_ADRESOWY, "ITerytWs1/PobierzDateAktualnegoKatTerc",
                        "PobierzDateAktualnegoKatTercResponse.xml", LocalDate.of(2024, 5, 15)),
                Arguments.of(RodzajKatalogu.SIMC, "ITerytWs1/PobierzDateAktualnegoKatSimc",
                        "PobierzDateAktualnegoKatSimcResponse.xml", LocalDate.of(2024, 6, 10)),
                Arguments.of(RodzajKatalogu.SIMC_ADRESOWY, "ITerytWs1/PobierzDateAktualnegoKatSimc",
                        "PobierzDateAktualnegoKatSimcResponse.xml", LocalDate.of(2024, 6, 10)),
                Arguments.of(RodzajKatalogu.SIMC_STATYSTYCZNY, "ITerytWs1/PobierzDateAktualnegoKatSimc",
                        "PobierzDateAktualnegoKatSimcResponse.xml", LocalDate.of(2024, 6, 10)),
                Arguments.of(RodzajKatalogu.ULIC, "ITerytWs1/PobierzDateAktualnegoKatUlic",
                        "PobierzDateAktualnegoKatUlicResponse.xml", LocalDate.of(2024, 7, 20)),
                Arguments.of(RodzajKatalogu.ULIC_ADRESOWY, "ITerytWs1/PobierzDateAktualnegoKatUlic",
                        "PobierzDateAktualnegoKatUlicResponse.xml", LocalDate.of(2024, 7, 20)),
                Arguments.of(RodzajKatalogu.ULIC_BEZ_DZIELNIC, "ITerytWs1/PobierzDateAktualnegoKatUlic",
                        "PobierzDateAktualnegoKatUlicResponse.xml", LocalDate.of(2024, 7, 20)),
                Arguments.of(RodzajKatalogu.ULIC_STARY, "ITerytWs1/PobierzDateAktualnegoKatUlic",
                        "PobierzDateAktualnegoKatUlicResponse.xml", LocalDate.of(2024, 7, 20)),
                Arguments.of(RodzajKatalogu.NTS, "ITerytWs1/PobierzDateAktualnegoKatNTS",
                        "PobierzDateAktualnegoKatNTSResponse.xml", LocalDate.of(2024, 8, 25))
        );
    }

    @ParameterizedTest(name = "getCatalogDate({0}) używa akcji {1} i zwraca {3}")
    @MethodSource("catalogDateScenarios")
    void getCatalogDateShouldReturnDateForType(RodzajKatalogu type, String soapAction,
                                               String responseFile, LocalDate expected) {
        stubSoapOk(soapAction, responseFile);

        LocalDate result = terytClient.getCatalogDate(type);

        assertThat(result).isEqualTo(expected);
        wireMockServer.verify(verifySoapAction(soapAction));
    }

    @Test
    @DisplayName("getCatalogDate() rzuca wyjątek gdy serwis zwraca HTTP 500")
    void getCatalogDateShouldThrowOnHttp500() {
        stubSoapResponse("ITerytWs1/PobierzDateAktualnegoKatTerc", 500,
                soapFault("s:Server", "Service unavailable"));

        assertThatThrownBy(() -> terytClient.getCatalogDate(RodzajKatalogu.TERC))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("getCatalogDate(null) rzuca IllegalArgumentException")
    void getCatalogDateShouldThrowOnNullType() {
        assertThatThrownBy(() -> terytClient.getCatalogDate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
