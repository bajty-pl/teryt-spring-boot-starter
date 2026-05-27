package pl.bajty.teryt.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;
import pl.bajty.teryt.api.TerytClient;
import pl.bajty.teryt.internal.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(TerytProperties.class)
public class TerytAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Wss4jSecurityInterceptor terytSecurityInterceptor(TerytProperties properties) {
        Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();

        interceptor.setSecurementActions("UsernameToken");
        interceptor.setSecurementUsername(properties.username());
        interceptor.setSecurementPassword(properties.password());
        interceptor.setSecurementPasswordType("PasswordText");

        return interceptor;
    }

    @Bean
    @ConditionalOnMissingBean
    public Jaxb2Marshaller terytMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("pl.bajty.teryt.internal.soap.generated");
        return marshaller;
    }

    @Bean
    @ConditionalOnMissingBean
    public WebServiceTemplate terytWebServiceTemplate(
            Jaxb2Marshaller terytMarshaller,
            Wss4jSecurityInterceptor terytSecurityInterceptor,
            TerytProperties properties) {

        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(terytMarshaller);
        template.setUnmarshaller(terytMarshaller);
        template.setDefaultUri(properties.url());

        template.setInterceptors(new ClientInterceptor[]{terytSecurityInterceptor});

        if (properties.testEnvironment()) {
            log.warn("Using test environment with relaxed SSL validation");
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new javax.net.ssl.X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            try {
                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new SecureRandom());

                HttpsUrlConnectionMessageSender messageSender =
                        new HttpsUrlConnectionMessageSender();

                messageSender.setSslSocketFactory(sc.getSocketFactory());
                messageSender.setHostnameVerifier((_, _) -> true);

                template.setMessageSender(messageSender);
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                throw new IllegalStateException("Failed to initialize SSLContext", e);
            }
        }

        return template;
    }

    @Bean
    public TerytClient terytClient(WebServiceTemplate webServiceTemplate) {
        AuthService authService = new AuthService(webServiceTemplate);
        TercService tercService = new TercService(webServiceTemplate);
        SimcService simcService = new SimcService(webServiceTemplate);
        FilesService filesService = new FilesService(webServiceTemplate);

        return new TerytClientImpl(authService, tercService, simcService, filesService);
    }
}