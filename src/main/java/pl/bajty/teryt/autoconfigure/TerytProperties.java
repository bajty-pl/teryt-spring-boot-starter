package pl.bajty.teryt.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@ConfigurationProperties(prefix = "teryt")
public record TerytProperties(
        String url,
        String username,
        String password,
        boolean testEnvironment
) {
    private static final String PRODUCTION_URL = "https://uslugaterytws1.stat.gov.pl/TerytWs1.svc";
    private static final String TEST_URL = "https://uslugaterytws1test.stat.gov.pl/TerytWs1.svc";
    private static final String TEST_USERNAME = "TestPubliczny";
    private static final String TEST_PASSWORD = "1234abcd";

    public TerytProperties {
        if (testEnvironment) {
            log.info("TERYT test environment is enabled. Using public test credentials.");
            username = TEST_USERNAME;
            password = TEST_PASSWORD;
        } else {
            if (isBlank(username) || isBlank(password)) {
                throw new IllegalStateException(
                        "TERYT username and password must be configured unless teryt.test-environment=true."
                );
            }
        }

        if (isBlank(url)) {
            url = testEnvironment ? TEST_URL : PRODUCTION_URL;
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}