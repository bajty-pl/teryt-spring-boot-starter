package pl.bajty.teryt.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.assertj.core.api.Assertions.assertThat;

class TerytAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TerytAutoConfiguration.class));

    @Test
    void shouldLoadConfiguration() {
        contextRunner
                .withPropertyValues(
                        "teryt.username=test",
                        "teryt.password=test",
                        "teryt.url=http://example.com"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(TerytAutoConfiguration.class);
                    assertThat(context).hasSingleBean(WebServiceTemplate.class);
                });
    }
}
