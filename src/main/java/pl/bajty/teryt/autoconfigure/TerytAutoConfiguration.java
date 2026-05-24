package pl.bajty.teryt.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
@EnableConfigurationProperties(TerytProperties.class)
public class TerytAutoConfiguration {

    @Bean
    public Wss4jSecurityInterceptor terytSecurityInterceptor(TerytProperties properties) {
        Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();

        interceptor.setSecurementActions("UsernameToken");
        interceptor.setSecurementUsername(properties.username());
        interceptor.setSecurementPassword(properties.password());

        interceptor.setSecurementPasswordType(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText"
        );
        return interceptor;
    }

    @Bean
    public Jaxb2Marshaller terytMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("pl.bajty.teryt.internal.soap.generated");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate terytWebServiceTemplate(
            Jaxb2Marshaller terytMarshaller,
            Wss4jSecurityInterceptor terytSecurityInterceptor,
            TerytProperties properties) {

        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(terytMarshaller);
        template.setUnmarshaller(terytMarshaller);
        template.setDefaultUri(properties.url());

        template.setInterceptors(new ClientInterceptor[]{terytSecurityInterceptor});

        return template;
    }
}