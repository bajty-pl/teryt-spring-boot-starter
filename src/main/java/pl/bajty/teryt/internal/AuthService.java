package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import pl.bajty.teryt.internal.soap.generated.CzyZalogowany;
import pl.bajty.teryt.internal.soap.generated.CzyZalogowanyResponse;

import java.net.URI;

@RequiredArgsConstructor
public class AuthService {

    private final WebServiceTemplate webServiceTemplate;

    boolean isLoggedIn() {
        var request = new CzyZalogowany();

        var response = (CzyZalogowanyResponse) webServiceTemplate.marshalSendAndReceive(
                request,
                new ActionCallback(URI.create("http://tempuri.org/ITerytWs1/CzyZalogowany"))
        );

        if (response == null) {
            throw new IllegalStateException("Failed to receive response from GUS service");
        }

        return response.isCzyZalogowanyResult();
    }
}