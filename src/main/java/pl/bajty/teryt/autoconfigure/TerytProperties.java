package pl.bajty.teryt.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "teryt")
public record TerytProperties(
        String url,
        String username,
        String password,
        boolean testEnvironment
) {
    private static final Logger log = LoggerFactory.getLogger(TerytProperties.class);

    private static final String PRODUCTION_URL = "https://uslugaterytws1.stat.gov.pl/TerytWs1.svc";
    private static final String TEST_URL = "https://uslugaterytws1test.stat.gov.pl/TerytWs1.svc";
    private static final String TEST_USERNAME = "TestPubliczny";
    private static final String TEST_PASSWORD = "1234abcd";

    public TerytProperties {
        if (isBlank(url) && isBlank(username) && isBlank(password) && !testEnvironment) {
            log.warn("TERYT credentials are not set. Auto-enabling test environment. Set your credentials or 'teryt.test-environment=true' to hide this warning.");
            testEnvironment = true;
        }

        if (testEnvironment) {
            if (isBlank(username)) username = TEST_USERNAME;
            if (isBlank(password)) password = TEST_PASSWORD;
            log.info("TERYT test environment is active.");
        } else {
            if (isBlank(username) || isBlank(password)) {
                throw new IllegalStateException(
                        "TERYT username and password must be configured unless 'teryt.test-environment=true' is set."
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