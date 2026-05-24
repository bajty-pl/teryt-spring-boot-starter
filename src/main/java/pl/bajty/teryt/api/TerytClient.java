package pl.bajty.teryt.api;

import pl.bajty.teryt.model.Wojewodztwo;

import java.time.LocalDate;
import java.util.List;

public interface TerytClient {
    List<Wojewodztwo> getWojewodztwa(LocalDate date);
}
