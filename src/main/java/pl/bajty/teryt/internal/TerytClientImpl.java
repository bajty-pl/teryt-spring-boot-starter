package pl.bajty.teryt.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.WebServiceTemplate;
import pl.bajty.teryt.api.TerytClient;
import pl.bajty.teryt.model.Wojewodztwo;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
class TerytClientImpl implements TerytClient {
    private final WebServiceTemplate webServiceTemplate;

    @Override
    public List<Wojewodztwo> getWojewodztwa(LocalDate date) {
        // TODO: Wywołanie SOAP i mapowanie
        return List.of();
    }
}
