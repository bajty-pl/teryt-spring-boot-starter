package pl.bajty.teryt.model.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TercSerializationRegressionTest {

    @Test
    void shouldSerializeGminaWithoutInfiniteRecursion() {
        Wojewodztwo woj = new Wojewodztwo(new Terc("02"), "DOLNOŚLĄSKIE", null);
        Powiat pow = new Powiat(new Terc("0201"), "bolesławiecki", null, woj, null);
        Gmina gmina = new Gmina(new Terc("0201011"), "Bolesławiec", null, pow, null);

        ObjectMapper mapper = new ObjectMapper();
        
        assertDoesNotThrow(() -> {
            String json = mapper.writeValueAsString(gmina);
            if (!json.contains("\"value\":\"0201011\"")) {
                throw new RuntimeException("Missing value in JSON");
            }
            if (json.length() > 2000) {
                throw new RuntimeException("JSON too long, possible recursion");
            }
        });
    }
}
