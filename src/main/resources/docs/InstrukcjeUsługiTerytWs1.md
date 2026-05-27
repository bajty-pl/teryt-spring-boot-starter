# Instrukcja usługi TERYT ws1

> **OSTRZEŻENIE:** Treść pliku na potrzeby wewnętrzne bajty.pl nie jest oficjalną dokumentacją GUS TERYT Ws1 - stanowi
> jego kopię w formacie Markdown i może zawierać błędy

## Spis treści

* [1. Podstawowe informacje o usłudze](#1-podstawowe-informacje-o-usłudze)
* [2. Komunikacja z usługą](#2-komunikacja-z-usługą)
* [3. Procedura integracji](#3-procedura-integracji-z-usługą-teryt-ws1)
* [4. Zakres udostępnianych danych i podstawa prawna](#4-zakres-udostępnianych-danych-i-podstawa-prawna)
* [5. Regulamin korzystania z usługi](#5-regulamin-korzystania-z-usługi)
* [6. Gwarancja jakości usług](#6-gwarancja-jakości-usług)

## 1. Podstawowe informacje o usłudze

Rejestr TERYT gromadzi aktualne i archiwalne dane dotyczące obiektów terytorialnych takich jak:

- jednostki podziału terytorialnego,
- jednostki podziału statystycznego,
- miejscowości,
- ulice.

Jest on rejestrem referencyjnym w zakresie identyfikatorów w stosunku do innych rejestrów i ewidencji urzędowych i
systemów administracji publicznej. Tworzona usługa sieciowa ws1 w prosty sposób zapewni łatwy dostęp do danych rejestru
użytkownikom systemu. Udostępnia ona interfejs programistyczny – zbiór metod, dzięki którym możliwe jest pobieranie
danych z rejestru TERYT bezpośrednio do systemów komunikujących się z rejestrem. Zasadniczą funkcjonalnością usługi jest
udostępnianie danych osobom fizycznym, podmiotom komercyjnym oraz uprawnionym instytucjom publicznym.

## 2 Komunikacja z usługą

### 2.1 Interfejs programistyczny usługi Teryt ws1

W serwisie zaimplementowano metody zwracające dane z bazy danych. Poniżej przedstawiono listę metod wraz ze wskazaniem
parametrów wejściowych oraz ich funkcjonalnościami. Metody pobierające datę aktualnych katalogów. Bezparametrowe metody
z tej grupy, pobierają z bazy danych datę początkową aktualnego stanu wskazanego rejestru. Dzięki temu możliwe jest
określenie, czy dane posiadane przez użytkowników wymagają zaktualizowania.

| Wynik                      | Metoda                       | Parametry |
|----------------------------|------------------------------|-----------|
| Data początkowa stanu TERC | PobierzDateAktualnegoKatTerc | -         |
| Data początkowa stanu NTS  | PobierzDateAktualnegoKatNTS  | -         |
| Data początkowa stanu SIMC | PobierzDateAktualnegoKatSimc | -         |
| Data początkowa stanu ULIC | PobierzDateAktualnegoKatUlic | -         |

Zwracane wyniki są typu *DateTime*, data w formacie `YYYY-MM-DD`.

#### Listy danych.

Metody zwracają pewien podzbiór danych z określonych katalogów. Wspólnym parametrem jest *DataStanu*, czyli data, w
którym dany katalog jest aktualny. Zakres dat dla poszczególnych wersji katalogów przedstawia poniższa tabela.

| Katalog                         | Zbiór      | Plik zmian |
|---------------------------------|------------|------------|
| TERC – wersja urzędowa          | 01-01-1999 | 01-01-1999 |
| TERC_ADR – wersja adresowa      | 01-01-2006 | 01-01-2006 |
| NTS                             | 27-07-2000 | 27-07-2000 |
| SIMC – wersja urzędowa          | 01-01-1999 | 01-01-1999 |
| SIMC_ADR – wersja adresowa      | 01-10-2006 | 01-10-2006 |
| SIMC_STAT – wersja statystyczna | 01-01-1999 | 01-01-1999 |
| ULIC – wersja urzędowa          | 31-12-2006 | 31-12-2006 |
| ULIC_ADR – wersja adresowa      | 31-12-2006 | 31-12-2006 |

Różnica pomiędzy wersją urzędową i adresową polega na pominięciu w wersji adresowej danych, odnoszących się do miast:
Warszawa, Kraków, Łódź, Poznań, Wrocław, jako jednostek szczebla gminnego (identyfikatory gmin, dla których rodzaj
gminy = 1) oraz rekordów zawierających dane o gminach miejsko-wiejskich, jako całości (rodzaj gminy = 3).

Dane odnoszące się do zakresu rozszerzonego, obejmującego statystyczną część katalogu SIMC będą zawierały wszystkie
wymienione wyżej informacje z zakresu urzędowego oraz:

- numer miejscowości statystycznej w ramach gminy,
- numer miejscowości składowej w ramach miejscowości statystycznej,
- określenie miejscowości — dla miejscowości wiejskich:
    - 0 – miejscowość statystyczna,
    - 1 – miejscowość podstawowa,
    - 2 – integralna część miejscowości,
- dla miast:
    - 0 – miasto,
    - 1 – dzielnice m. st. Warszawy, delegatury w Krakowie, Łodzi, Poznaniu, Wrocławiu, części miast w pozostałych
      miastach,
    - 2 – części miasta w dzielnicach m. st. Warszawy i w delegaturach,
- identyfikator miejscowości statystycznej

#### Dane z katalogu TERC

Dane z systemu TERC, katalogu identyfikatorów i nazw jednostek podziału terytorialnego kraju, zwracają metody grupujące
dane według poziomu jednostek.

| Wynik                 | Metoda                 | Parametry           |
|-----------------------|------------------------|---------------------|
| Lista województw      | PobierzListeWojewodztw | DataStanu           |
| Lista powiatów        | PobierzListePowiatow   | Woj, DataStanu      |
| Lista gmin            | PobierzListeGmin       | Woj, Pow, DataStanu |
| Lista powiatów i gmin | PobierzGminyiPowDlaWoj | Woj, DataStanu      |

Metody zwracają listę obiektów klasy `JednostkaTerytorialna`. Klasa ta posiada właściwości:

| Nazwa pola  | Typ    | Opis                                       |
|-------------|--------|--------------------------------------------|
| `WOJ`       | string | dwuznakowy symbol województwa              |
| `POW`       | string | dwuznakowy symbol powiatu                  |
| `GMI`       | string | dwuznakowy symbol gminy                    |
| `RODZ`      | string | jednoznakowy symbol gminy                  |
| `NAZWA`     | string | nazwa jednostki                            |
| `NAZWA_DOD` | string | typ jednostki podziału terytorialnego      |
| `STAN_NA`   | string | określa datę katalogu dla wskazanego stanu |

Właściwości, w zależności od poziomu jednostki, mogą mieć wartość `null`. Tak będzie w przypadku województwa, dla
którego właściwości `POW`, `GMI`, `RODZ` będą miały wartość równą `null`.

#### Dane ze zbioru NTS

Dane ze zbioru NTS, wykazu symboli i nazw Nomenklatury Jednostek Terytorialnych do Celów Statystycznych, zwracają metody
grupujące dane według poziomu jednostek.

| Wynik                        | Metoda                           | Parametry              |
|------------------------------|----------------------------------|------------------------|
| Lista regionów               | PobierzListeRegionow             | DataStanu              |
| Lista województw w regionie  | PobierzListeWojewodztwWRegionie  | Reg, DataStanu         |
| Lista podregionów            | PobierzListePodregionow          | Woj, DataStanu         |
| Lista powiatów w podregionie | PobierzListePowiatowWPodregionie | Podreg, DataStanu      |
| Lista gmin w powiecie        | PobierzListeGminPowiecie         | Pow, Podreg, DataStanu |

Metody zwracają listy obiektów klasy `JednostkaNomenklaturyNTS`. Klasa ta posiada właściwości:

| Nazwa pola  | Typ    | Opis                                          |
|-------------|--------|-----------------------------------------------|
| `POZIOM`    | string | jednoznakowy symbol poziomu                   |
| `REGION`    | string | jednoznakowy symbol regionu                   |
| `WOJ`       | string | dwuznakowy symbol województwa                 |
| `PODREG`    | string | dwuznakowy symbol podregionu                  |
| `POW`       | string | dwuznakowy symbol powiatu                     |
| `GMI`       | string | dwuznakowy symbol gminy                       |
| `RODZ`      | string | jednoznakowy symbol gminy                     |
| `NAZWA`     | string | zawiera nazwę jednostki                       |
| `NAZWA_DOD` | string | zawiera typ jednostki podziału terytorialnego |
| `STAN_NA`   | string | określa datę katalogu dla wskazanego stanu    |

#### Dane z katalogu ULIC

Dane z Centralnego Katalogu Ulic, zwraca metoda:

| Wynik                     | Metoda                          | Parametry                                                       |
|---------------------------|---------------------------------|-----------------------------------------------------------------|
| Lista ulic w miejscowości | PobierzListeUlicDlaMiejscowosci | Woj, Pow, Gmi, Rodz, msc, czyWersjaUrz, czyWersjaAdr, DataStanu |

Metoda zwraca wynik dla wersji urzędowej katalogu, jak i adresowej. Aby uzyskać wyniki, należy określić jednostkę
podziału terytorialnego, identyfikator miejscowości, wskazać datę stanu katalogu oraz określić wersję katalogu.

- dla wersji urzędowej parametry powinny mieć wartość: `czyWersjaUrzedowa=true`, `czyWersjaAdresowa=false`,
- dla wersji adresowej: `czyWersjaUrzedowa=false`, `czyWersjaAdresowa=true`

Metoda zwraca listę obiektów klasy `UlicaDrzewo`. Klasa ta posiada właściwości:

| Nazwa pola                             | Typ    | Opis                                                            |
|----------------------------------------|--------|-----------------------------------------------------------------|
| `Woj`                                  | string | dwuznakowy symbol województwa                                   |
| `Pow`                                  | string | dwuznakowy symbol powiatu                                       |
| `Gmi`                                  | string | dwuznakowy symbol gminy                                         |
| `RodzGmi`                              | string | jednoznakowy symbol gminy                                       |
| `IdentyfikatorMiejscowosci`            | string | 7-znakowy identyfikator miejscowości                            |
| `IdentyfikatorMiejscowosciPodstawowej` | string | 7-znakowy identyfikator miejscowości podstawowej                |
| `SymbolUlicy`                          | string | 5-znakowy identyfikator ulicy                                   |
| `Cecha`                                | string | zawiera cechę ulicy                                             |
| `NazwaCechy`                           | string | zawiera nazwę cechy ulicy                                       |
| `Nazwa1`                               | string | zawiera pierwszą część nazwy ulicy                              |
| `Nazwa2`                               | string | zawiera drugą część nazwy ulicy                                 |
| `IndeksKlucza`                         | int    | wyznacza miejsce podziału pełnej nazwy ulicy na Nazwa1 i Nazwa2 |
| `StanNa`                               | string | określa datę katalogu dla wskazanego stanu                      |

#### Dane z katalogu SIMC

Dane ze zbioru SIMC, katalogu identyfikatorów i nazw miejscowości, zwracają metody:
Oto zestawienie metod wyszukiwania miejscowości w gminie dla podanych danych:

| Wynik / Opis                                                       | Metoda                                  | Parametry                                                                              |
|--------------------------------------------------------------------|-----------------------------------------|----------------------------------------------------------------------------------------|
| Lista miejscowości we wskazanej gminie (wyszukiwanie po nazwach)   | `PobierzListeMiejscowosciWGminie`       | `wojewodztwo`, `Powiat`, `Gmina`, `DataStanu` (format 'YYYY-MM-DD')                    |
| Lista miejscowości we wskazanej gminie (wyszukiwanie po symbolach) | `PobierzListeMiejscowosciWRodzajuGminy` | `symbolWoj`, `symbolPow`, `symbolGmi`, `symbolRodz`, `DataStanu` (format 'YYYY-MM-DD') |

Metody zwracają listy obiektów klasy `Miejscowosc`. Klasa ta posiada właściwości:

| Nazwa pola    | Typ    | Opis                                 |
|---------------|--------|--------------------------------------|
| `Nazwa`       | string | nazwa miejscowości                   |
| `Symbol`      | string | 7-znakowy identyfikator miejscowości |
| `Wojewodztwo` | string | nazwa województwa                    |
| `WojSymbol`   | string | dwuznakowy identyfikator województwa |
| `Powiat`      | string | nazwa powiatu                        |
| `PowSymbol`   | string | dwuznakowy identyfikator powiatu     |
| `Gmina`       | string | nazwa gminy                          |
| `GmiSymbol`   | string | dwuznakowy symbol gminy              |
| `GmiRodzaj`   | string | jednoznakowy symbol gminy            |

#### Słowniki

Poniższe metody wracają słownikowe dane dla katalogów w formacie listy obiektów typu string.

Oto tabela z kolejnymi metodami usług TERYT:

| Wynik / Opis                                       | Metoda                            | Parametry                         |
|----------------------------------------------------|-----------------------------------|-----------------------------------|
| Lista rodzajów jednostek podziału terytorialnego   | `PobierzSlownikRodzajowJednostek` | brak                              |
| Lista rodzajów miejscowości według wybranego stanu | `PobierzSlownikRodzajowSIMC`      | `DataStanu` (format 'YYYY-MM-DD') |
| Lista cech obiektów z katalogu ulic                | `PobierzSlownikCechULIC`          | brak                              |

#### Katalogi

Kolejną funkcjonalnością usługi, jest pobieranie pełnych zbiorów danych dla poszczególnych katalogów. Zbiory
te przekazywane są w plikach *XML* oraz *CSV*, które są skompresowane do formatu zip. Metody te zwracają obiekty klasy
`PlikKatalog`, posiadająca następujące właściwości:

| Nazwa pola       | Typ    | Opis                                         |
|------------------|--------|----------------------------------------------|
| `nazwa_pliku`    | string | sugerowana nazwa pliku                       |
| `plik_zawartosc` | string | treść pliku ZIP zakodowana w formacie Base64 |
| `opis`           | string | dodatkowy opis                               |

Metody te posiadają jeden parametr: `DataStanu` określający datę aktualności wskazanego katalogu.

| Wynik / Opis                                    | Metoda                  | Parametry                         |
|-------------------------------------------------|-------------------------|-----------------------------------|
| Dane z systemu TERC w wersji adresowej          | `PobierzKatalogTERCAdr` | `DataStanu` (format 'YYYY-MM-DD') |
| Dane z systemu TERC w wersji urzędowej          | `PobierzKatalogTERC`    | `DataStanu` (format 'YYYY-MM-DD') |
| Identyfikatory i nazwy jednostek NTS            | `PobierzKatalogNTS`     | `DataStanu` (format 'YYYY-MM-DD') |
| Dane o miejscowościach z SIMC (wersja adresowa) | `PobierzKatalogSIMCAdr` | `DataStanu` (format 'YYYY-MM-DD') |
| Dane o miejscowościach z SIMC (wersja urzędowa) | `PobierzKatalogSIMC`    | `DataStanu` (format 'YYYY-MM-DD') |

Dane o miejscowościach z systemu identyfikatorów SIMC z wybranego stanu katalogu w wersji statystycznej.

| Wynik / Opis                                                | Metoda                          | Parametry                         |
|-------------------------------------------------------------|---------------------------------|-----------------------------------|
| Dane o miejscowościach z systemu SIMC (wersja statystyczna) | `PobierzKatalogSIMCStat`        | `DataStanu` (format 'YYYY-MM-DD') |
| Katalog ulic (wersja urzędowa)                              | `PobierzKatalogULIC`            | `DataStanu` (format 'YYYY-MM-DD') |
| Katalog ulic (wersja adresowa)                              | `PobierzKatalogULICAdr`         | `DataStanu` (format 'YYYY-MM-DD') |
| Katalog ulic (wersja urzędowa, dla miast z delegaturami)    | `PobierzKatalogULICBezDzielnic` | `DataStanu` (format 'YYYY-MM-DD') |
| Katalog rodzajów miejscowości                               | `PobierzKatalogWMRODZ`          | `DataStanu` (format 'YYYY-MM-DD') |

#### Zmiany w katalogach.

Wszystkie katalogi w systemie są aktualizowane. Dan e w katalogu ULIC zazwyczaj codziennie (oprócz
świąt, sobót i niedziel), pozostałe zaś zazwyczaj raz do roku. Dla systemu TERC mamy następujące typy zmian: D –
dopisanie U – usunięcie M – modyfikacja identyfikatora lub/i nazwy Jako zmiana typu D oznaczone powinny być reko rdy
obejmujące utworzenie nowej jednostki, jako zmiana typu U – sytuacje zniesienia jedn ostki i jej dołączenia do innej
jednostki. Pozostałe przypadki będą określone , jako zmiany typu M. Dla korekt typu D wypełnione są wszystkie pola w
części 'po zmianie', w przypadku korekt typu M pola wypełniane tylko wtedy , gdy ich wartość jest różna od wartości tych
pól przed modyfikacją – wyjątek stanowi identyfikator terytorialny jednostki, w którym w przypadku zmiany któregokolwiek
z elementów po modyfikacji podawane powinny być wszystkie symbole wchodzące w jego skład. W części 'przed zmianą' dla
korekt typu U i M powinny być wypełnione wszystkie informacje wymagane dla danego poziomu podziału, dla korekt typu D –
pola pozostają niewypełnione.

Dla systemu SIMC przewiduje się udostępnianie 3 rodzajów plików aktualizacyjnych obejmujących:

- zmiany w części urzędowej katalogu miejscowości (SIMC urzędowy),
  zmiany w katalogu miejscowości z uwzględnieniem jego statystycznej części (SIMC rozszerzony/statystyczny),
- zmiany dotyczące katalogu miejscowości w module `TERYT_ADR` (SIMC adresowy).

Możliwe są następujące typy zmian:

- `D` – dopisanie nowej miejscowości,
- `U` – likwidacja istniejącej miejscowości,
- `Z` – zmiana atrybutów dla istniejącej miejscowości,
- `P` – przeniesienie miejscowości do innej jednostki administracyjnej: województwa, powiatu, gminy (z uwzględnieniem
  podziału na miasto i obszar wiejski w gminach miejsko-wiejskich).

Dla korekt typu `D` powinny być wypełnione wszystkie pola 'po modyfikacji, w przypadku korekt typu `Z` i `P` pola
wypełniane tylko wtedy, gdy ich wartość jest różna od wartości tych pól przed modyfikacją – wyjątek stanowi
identyfikator terytorialny gminy, w którym w przypadku zmiany któregokolwiek z elementów po modyfikacji podawane powinny
być wszystkie symbole wchodzące w jego skład. Dla korekt typu `U`, `Z` i `P`, w części 'przed modyfikacją' powinny być
wypełnione wszystkie informacje, dla korekt typu `D` – pola pozostają niewypełnione

Dla systemu ULIC możliwe są następujące typy zmian:

- `D` – dopisanie nowej ulicy,
- `M` – zmiana parametrów ulicy,
- `U` – usunięcie istniejącej ulicy,
- `Z` – zmiana podziału nazwy ulicy.

W części przed zmianą, dla zmian typu `M` i `U`, powinny być wypełnione wszystkie informacje, dla zmian typu `D` – pola
pozostają niewypełnione. W części ‘Po’ dla zmian typu `U` pola pozostają niewypełnione, dla zmian typu `D` powinny być
wypełnione wszystkie pola, w przypadku zmian typu `M` pola wypełniane tylko wtedy, gdy ich wartość jest różna od
wartości
tych pól przed modyfikacją – wyjątek stanowią:

- identyfikator terytorialny gminy, w którym w przypadku zmiany któregokolwiek z elementów po modyfikacji podawane
  powinny być wszystkie symbole wchodzące w jego skład,

- nazwy ulicy w podziale na pola, gdzie w przypadku zmiany jednej części podawane są wszystkie nowe wartości nazwy
  ulicy. Rekordy oznaczone typem zmiany Z zarówno przed zmianą jak i po zmianie nie będą miały wypełnionych pól
  dotyczących lokalizacji ulicy, ponieważ taka zmiana odnosi się do wszystkich lokalizacji ulicy. Metody realizujące
  powyższe funkcjonalności znajdują się w poniższej tabeli. Posiadają dwa parametry: `stanod` określający datę
  początkową oraz `stando` określający datę końcową okresu, w którym zachodzą zmiany.

| Wynik / Opis                                 | Metoda                          | Parametry                                |
|----------------------------------------------|---------------------------------|------------------------------------------|
| Zmiany w katalogu TERC (wersja urzędowa)     | `PobierzZmianyTercUrzedowy`     | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w katalogu TERC (wersja adresowa)     | `PobierzZmianyTercAdresowy`     | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w zbiorze NTS                         | `PobierzZmianyNTS`              | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w katalogu SIMC (wersja urzędowa)     | `PobierzZmianySimcUrzedowy`     | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w katalogu SIMC (wersja adresowa)     | `PobierzZmianySimcAdresowy`     | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w katalogu SIMC (wersja statystyczna) | `PobierzZmianySimcStatystyczny` | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w katalogu ULIC (wersja urzędowa)     | `PobierzZmianyUlicUrzedowy`     | `stanod`, `stando` (format 'YYYY-MM-DD') |
| Zmiany w katalogu ULIC (wersja adresowa)     | `PobierzZmianyUlicAdresowy`     | `stanod`, `stando` (format 'YYYY-MM-DD') |

Zmiany zapisane są w pliku *XML*, który skompresowany jest do formatu zip. Metody zwracają obiekty klasy `PlikZmiany`.

| Nazwa pola       | Typ    | Opis                                         |
|------------------|--------|----------------------------------------------|
| `nazwa_pliku`    | string | sugerowana nazwa pliku                       |
| `plik_zawartosc` | string | treść pliku ZIP zakodowana w formacie Base64 |
| `opis`           | string | dodatkowy opis                               |

#### Weryfikacja

Weryfikację danych umożliwiają poniższe metody zestawione poniżej. Istnieje możliwość zweryfikowania ich do poziomu
miejscowości oraz ulic. Weryfikacja przeprowadzana jest na danych z bieżących katalogów.

Do poziomu miejscowości realizują metody:

| Wynik / Opis                                              | Metoda                                  | Parametry                                                              |
|-----------------------------------------------------------|-----------------------------------------|------------------------------------------------------------------------|
| Weryfikacja obiektu (po identyfikatorze)                  | `WeryfikujAdresDlaMiejscowosci`         | `symbolMsc` (7 znaków)                                                 |
| Weryfikacja obiektu (po identyfikatorze, wersja adresowa) | `WeryfikujAdresDlaMiejscowosciAdresowy` | `symbolMsc` (7 znaków)                                                 |
| Weryfikacja obiektu (po nazwach)                          | `WeryfikujAdresWmiejscowosci`           | `Wojewodztwo`, `Powiat`, `Gmina`, `Miejscowosc`, `Rodzaj` (opcjonalny) |
| Weryfikacja obiektu (po nazwach, wersja adresowa)         | `WeryfikujAdresWmiejscowosciAdresowy`   | `Wojewodztwo`, `Powiat`, `Gmina`, `Miejscowosc`, `Rodzaj` (opcjonalny) |

Metody te zwracają obiekty klasy `ZweryfikowanyAdresBezUlic`:

| Nazwa pola                      | Typ    | Opis                                 |
|---------------------------------|--------|--------------------------------------|
| `NazwaMiejscowosci`             | string | określa nazwę miejscowości           |
| `RodzajMiejscowosci`            | string | określa rodzaj miejscowości          |
| `HistorycznyRodzajMiejscowosci` | string | poprzedni rodzaj miejscowości        |
| `SymbolMiejscowosci`            | string | 7-znakowy identyfikator miejscowości |
| `SymbolWoj`                     | string | dwuznakowy symbol województwa        |
| `NazwaWoj`                      | string | określa nazwę województwa            |
| `SymbolPow`                     | string | dwuznakowy symbol powiatu            |
| `NazwaPow`                      | string | określa nazwę powiatu                |
| `SymbolGmi`                     | string | dwuznakowy symbol gminy              |
| `NazwaGmi`                      | string | określa nazwę gminy                  |
| `RodzajGmi`                     | string | określa nazwę rodzaju gminy          |
| `SymbolRodzajuGmi`              | string | jednoznakowy symbol rodzaju gminy    |

Do poziomu ulic, weryfikacje realizują metody:

| Wynik / Opis                                                                                                       | Metoda                            | Parametry                                                                                                                                  |
|--------------------------------------------------------------------------------------------------------------------|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| Weryfikacja obiektu (po identyfikatorach, do poziomu miejscowości)                                                 | `WeryfikujAdresDlaUlic`           | `symbolMs` (7 znaków), `SymUl` (5 znaków)                                                                                                  |
| Weryfikacja obiektu (po identyfikatorach, wersja adresowa, do poziomu ulic)                                        | `WeryfikujAdresDlaUlicAdresowy`   | `symbolMs` (7 znaków), `SymUl` (5 znaków)                                                                                                  |
| Weryfikacja istnienia wskazanego obiektu w bazie TERYT do poziomu ulic za pomocą nazw.                             | `WeryfikujNazwaAdresUlic`         | `nazwaWoj` (string), `nazwaPow` (string), `nazwaGmi` (string), `nazwaMiejscowosc` (string), `rodzajMiejsc` (string), `nazwaUlicy` (string) |
| Weryfikacja istnienia wskazanego obiektu w bazie TERYT do poziomu ulic w wersji adresowej rejestru za pomocą nazw. | `WeryfikujNazwaAdresUlicAdresowy` | `nazwaWoj` (string), `nazwaPow` (string), `nazwaGmi` (string), `nazwaMiejscowosc` (string), `rodzajMiejsc` (string), `nazwaUlicy` (string) |

Metody zwracają obiekty klasy  `ZweryfikowanyAdres`:

| Nazwa pola                      | Typ    | Opis                                                                                                 |
|---------------------------------|--------|------------------------------------------------------------------------------------------------------|
| `NazwaCechy`                    | string | cecha ulicy                                                                                          |
| `Nazwa_2`                       | string | pozostała część nazwy ulicy                                                                          |
| `Nazwa_1`                       | string | część nazwy ulicy począwszy od słowa, które decyduje o pozycji w układzie alfabetycznym, aż do końca |
| `NazwaUlicyWPelnymBrzmieniu`    | string | pełna nazwa ulicy (złożona z cechy, nazwy_1 i nazwy_2)                                               |
| `SymUl`                         | string | identyfikator ulicy                                                                                  |
| `NazwaMiejscowosci`             | string | określa nazwę miejscowości                                                                           |
| `RodzajMiejscowosci`            | string | określa rodzaj miejscowości                                                                          |
| `HistorycznyRodzajMiejscowosci` | string | określa poprzedni rodzaj miejscowości                                                                |
| `SymbolMiejscowosci`            | string | 7-znakowy identyfikator miejscowości                                                                 |
| `SymbolWoj`                     | string | dwuznakowy symbol województwa                                                                        |
| `NazwaWoj`                      | string | określa nazwę województwa                                                                            |
| `SymbolPow`                     | string | dwuznakowy symbol powiatu                                                                            |
| `NazwaPow`                      | string | określa nazwę powiatu                                                                                |
| `SymbolGmi`                     | string | dwuznakowy symbol gminy                                                                              |
| `NazwaGmi`                      | string | określa nazwę gminy                                                                                  |
| `RodzajGmi`                     | string | określa nazwę rodzaju gminy                                                                          |
| `SymbolRodzajuGmi`              | string | jednoznakowy symbol rodzaju gminy                                                                    |

#### Wyszukiwanie

Proponowany poniżej sposób wyszukiwania danych z rejestru TERYT opiera się na idei kierowania zapytań do
bazy danych przez pojedynczych użytkowników rejestru, co zwiększa samodzielny udział użytkownika w pozyskiwaniu
interesujących go informacji i stanowi alternatywę dla pobierania plików z kompletem danych dla katalogów. Wyszukiwanie
obiektów realizowane jest przy użyciu identyfikatorów obiektów lub nazw. W przypadku nazw można posługiwać się nazwą
pełną lub częściową. W przypadku identyfikatorów zaś w przypadku podania niepełnej długości identyfikator jest
uzupełniany zerami z lewej strony.

Wyszukiwanie w bieżących katalogach realizują metody:

| Wynik / Opis                                                                                                          | Metoda                    | Parametry                                                                                                                         |
|-----------------------------------------------------------------------------------------------------------------------|---------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Zwraca listę znalezionych jednostek w katalogu TERC. Obiekty klasy `JednostkaPodzialuTerytorialnego`                  | `WyszukajJPT`             | `Nazwa` (string - nazwa jednostki podziału terytorialnego)                                                                        |
| Zwraca listę znalezionych miejscowości w katalogu SIMC. Obiekty klasy `Miejscowosc`                                   | `WyszukajMiejscowosc`     | `nazwaMiejscowosci` (string), `identyfikatorMiejscowosci` (string, 7 znaków)                                                      |
| Zwraca listę znalezionych miejscowości we wskazanej jednostce podziału terytorialnego. Obiekty klasy `Miejscowosc`    | `WyszukajMiejscowoscWJPT` | `nazwaWoj` (string), `nazwaPow` (string), `nazwaGmi` (string), `nazwaMiejscowosci` (string), `identyfikatorMiejscowosci` (string) |
| Wyszukuje wskazaną ulicę w katalogu ULIC. Wyszukiwanie odbywa się za pomocą nazw. Zwraca listę obiektów klasy `Ulica` | `WyszukajUlice`           | `nazwaulicy` (string), `cecha` (string), `nazwamiejscowosci` (string)                                                             |

W przypadku, gdy parametrami są jednocześnie nazwa miejscowości, jak i jej identyfikator wystarczy podać jeden z nich.

Klasa `JednostkaPodzialuTerytorialnego` posiada właściwości:

| Nazwa pola          | Typ    | Opis                          |
|---------------------|--------|-------------------------------|
| `GmiNazwa`          | string | określa nazwę gminy           |
| `GmiNazwaDodatkowa` | string | określa nazwę rodzaju gminy   |
| `GmiSymbol`         | string | dwuznakowy symbol gminy       |
| `GmiRodzaj`         | string | określa rodzaj gminy          |
| `Powiat`            | string | określa nazwę powiatu         |
| `PowSymbol`         | string | dwuznakowy symbol powiatu     |
| `Wojewodztwo`       | string | określa nazwę województwa     |
| `WojSymbol`         | string | dwuznakowy symbol województwa |

Właściwości klasy `Ulica`

| Nazwa pola                  | Typ    | Opis                               |
|-----------------------------|--------|------------------------------------|
| `Cecha`                     | string | określa cechę ulicy                |
| `Nazwa`                     | string | określa nazwę ulicy                |
| `IdentyfikatorUlicy`        | string | określa identyfikator ulicy        |
| `NazwaMiejscowosci`         | string | określa nazwę miejscowości         |
| `IdentyfikatorMiejscowosci` | string | określa identyfikator miejscowości |
| `Wojewodztwo`               | string | określa nazwę województwa          |
| `WojSymbol`                 | string | dwuznakowy symbol województwa      |
| `Powiat`                    | string | określa nazwę powiatu              |
| `PowSymbol`                 | string | dwuznakowy symbol powiatu          |
| `Gmina`                     | string | określa nazwę gminy                |
| `GmiSymbol`                 | string | dwuznakowy symbol gminy            |
| `GmiRodzaj`                 | string | określa rodzaj gminy               |

Wyszukiwanie z dodatkowymi zawężeniami umożliwiają dodatkowe metody:

| Wynik / Opis                                                                                                                                                | Metoda                          | Parametry                                                                                                                            |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| Zwraca listę znalezionych jednostek w katalogu TERC z uwzględnieniem daty katalogu. Obiekty klasy `JednostkaPodzialuTerytorialnego`                         | `WyszukajJednostkeWRejestrze`   | `Nazwa` (string), `identyfiks` (lista typu identyfikatory), `kategoria` (string), `DataStanu` (DateTime)                             |
| Zwraca listę znalezionych miejscowości we wskazanej jednostce podziału terytorialnego, z uwzględnieniem daty katalogu. Obiekty klasy `WyszukanaMiejscowosc` | `WyszukajMiejscowoscWRejestrze` | `nazwa` (string), `rodzajMiejscowosci` (string), `symbol` (string), `identyfiks` (lista typu identyfikatory), `DataStanu` (DateTime) |
| Wyszukuje wskazaną ulicę w katalogu ULIC, z uwzględnieniem daty katalogu. Obiekty klasy `WyszukanaUlica`                                                    | `WyszukajUliceWRejestrze`       | `nazwa` (string), `cecha` (string), `identyfikator` (string), `identyfiks` (lista typu identyfikatory), `DataStanu`                  |

Metody te wyszukują dane z katalogów, których aktualny stan określa parametr `DataStanu`. Jeżeli użytkownik chciałby
zawęzić wyniki do określonych jednostek podziału terytorialnego kraju, może wykorzystać parametr `identyfiks` klasy
identyfikatory, która posiada właściwości:

| Nazwa pola | Typ    | Opis                                                                                              |
|------------|--------|---------------------------------------------------------------------------------------------------|
| `terc`     | string | 7-znakowy identyfikator jednostki (złączenie symboli: województwo-2, powiat-2, gmina-2, rodzaj-1) |
| `simc`     | string | identyfikator miejscowości                                                                        |

W przypadku wyszukiwania obiektu w katalogu TERC identyfikator simc nie jest potrzebny i powinien mieć wartość `null`.
Parametr kategoria określa rodzaj wyszukiwanej jednostki. Możliwe są następujące wartości:

Pole `Kategoria` Znaczenie:

| Symbol | Opis jednostki                                     | Uwagi                          |
|--------|----------------------------------------------------|--------------------------------|
| `0`    | Wyszukiwanie wśród wszystkich rodzajów jednostek   | -                              |
| `1`    | Dla województw                                     | -                              |
| `2`    | Dla wszystkich powiatów                            | -                              |
| `21`   | Dla powiatów ziemskich                             | identyfikator powiatu: 01-60   |
| `22`   | Dla miast na prawach powiatu                       | identyfikator powiatu: 61-99   |
| `3`    | Dla gmin ogółem                                    | -                              |
| `31`   | Dla gmin miejskich                                 | identyfikator rodzaju gminy: 1 |
| `32`   | Dla dzielnic i delegatur                           | identyfikator rodzaju: 8 i 9   |
| `33`   | Dla gmin wiejskich                                 | identyfikator rodzaju: 2       |
| `34`   | Dla gmin miejsko-wiejskich                         | identyfikator rodzaju: 3       |
| `341`  | Dla miast w gminach miejsko-wiejskich              | identyfikator rodzaju: 4       |
| `342`  | Dla obszarów wiejskich w gminach miejsko-wiejskich | identyfikator rodzaju: 5       |
| `35`   | Dla miast ogółem                                   | identyfikatory: 1 i 4          |
| `36`   | Dla terenów wiejskich                              | identyfikatory: 2 i 5          |

Wyszukując miejscowości korzystając z metody `WyszukajMiejscowoscWRejestrze`, należy określić, jaki zakres miejscowości
nas interesuje.

Pole `rodzajMiejscowości`
Znaczenie

| Symbol | Opis                           |
|--------|--------------------------------|
| `000`  | Wszystkie                      |
| `001`  | Miejscowości podstawowe        |
| `002`  | Części integralne miejscowości |

Klasa `WyszukanaMiejscowosc` posiada właściwości:
Oto tabela z zestawieniem pól dotyczących miejscowości i jednostek podziału terytorialnego:

| Nazwa pola           | Typ    | Opis                                   |
|----------------------|--------|----------------------------------------|
| `Nazwa`              | string | nazwa miejscowości                     |
| `Symbol`             | string | identyfikator miejscowości             |
| `SymbolPodst`        | string | identyfikator miejscowości podstawowej |
| `Rm`                 | string | symbol rodzaju miejscowości            |
| `RodzajMiejscowosci` | string | nazwa rodzaju miejscowości             |
| `Wojewodztwo`        | string | nazwa województwa                      |
| `Woj`                | string | symbol województwa                     |
| `Powiat`             | string | nazwa powiatu                          |
| `Pow`                | string | symbol powiatu                         |
| `Gmina`              | string | nazwa gminy                            |
| `Gmi`                | string | symbol gminy                           |
| `RodzajGminy`        | string | symbol rodzaju gminy                   |
| `DataStanu`          | Data   | data stanu, dla której wyszukano dane  |

Właściwości klasy `WyszukanaUlica`

| Nazwa pola    | Typ    | Opis                                  |
|---------------|--------|---------------------------------------|
| `Nazwa`       | string | nazwa ulicy                           |
| `Cecha`       | string | nazwa cechy                           |
| `Symbol`      | string | identyfikator ulicy                   |
| `Miejscowosc` | string | nazwa miejscowości                    |
| `SymbolSimc`  | string | identyfikator miejscowości            |
| `Wojewodztwo` | string | nazwa województwa                     |
| `Woj`         | string | symbol województwa                    |
| `Powiat`      | string | nazwa powiatu                         |
| `Pow`         | string | symbol powiatu                        |
| `Gmina`       | string | nazwa gminy                           |
| `Gmi`         | string | symbol gminy                          |
| `RodzajGminy` | string | symbol rodzaju gminy                  |
| `DataStanu`   | string | data stanu, dla której wyszukano dane |

*(Uwaga: dla pola `DataStanu` nie było podanego typu w Twoim tekście, ale w programowaniu zazwyczaj będzie to
typ `DateTime`, `Date` lub `string`)*.

Schema XML wraz z przykładowymi dokumentami XML zwracanymi przez metody zawarte są w katalogu ‘Załączniki’ niniejszej
dokumentacji.

## 3. Procedura integracji z usługą Teryt ws1

### 3.1. Integracja ze środowiskiem testowym

Usługa oferuje dostęp do środowiska testowego:

- Adres usługi testowej: https://uslugaterytws1test.stat.gov.pl/terytws1.svc
- Adres dokumentu wsdl: https://uslugaterytws1test.stat.gov.pl/wsdl/terytws1.wsdl

Dla użytkowników testowych zostało utworzone konto, umożliwiające korzystanie z wymienionych powyżej funkcjonalności.

- Nazwa użytkownika testowego: TestPubliczny
- Hasło użytkownika testowego: 1234abcd

### 3.2. Integracja ze środowiskiem produkcyjnym

Aby móc korzystać z usługi, należy wysłać email na adres: teryt_ws1@stat.gov.pl podając następujące dane:

- Nazwa użytkownika
- Numer telefonu
- Adres email
- Podmiot komercyjny / Administracja publiczna/ Osoba prywatna

Informacja zwrotna do użytkownika zostanie przesłana zaraz po założeniu konta. Dla środowiska produkcyjnego adresy są
następujące:

- Adres usługi produkcyjnej: https://uslugaterytws1.stat.gov.pl/terytws1.svc
- Adres dokumentu wsdl: https://uslugaterytws1.stat.gov.pl/wsdl/terytws1.wsdl

### 3.3. Mechanizm uwierzytelniania

Po stronie serwera użyto trybu bezpieczeństwa warstwy transportowej i wymagane jest podanie nazwy użytkownika oraz jego
hasło. Aby aplikacja mogła pobierać dane, musi ona więc przekazywać do usługi informacje o użytkowniku.

Poniżej przedstawiono przykładowe rozwiązanie aplikacji klienckiej napisanej w języku C# z wykorzystaniem klasy
`ChannelFactory`.

```csharp
try 
{ 
    var proxy = new ChannelFactory<ServiceReferenceWCF.ITerytWs1>("custom"); 
    proxy.Credentials.UserName.UserName = login; 
    proxy.Credentials.UserName.Password = haslo; 
    
    var result = proxy.CreateChannel(); 
    var test = result.CzyZalogowany(); 
} 
catch (Exception ex) 
{ 
}
```

W przypadku poprawnie skonfiurowanego środowiska `CzyZalogowany` powinna zwrócić do klienta wartość `true`. Powyższy
przykład korzysta z ‘endpointa’ o nazwie `custom` zdefiniowanym w pliku konfiguracyjnym. Przykładowy fragment pliku
konfiguracyjnego dla klienta usługi:

```xml

<client>
    <endpoint address="https://uslugaterytws1.stat.gov.pl/TerytWs1.svc" binding="customBinding"
              bindingConfiguration="custom" contract="ServiceReference1.ITerytWs1" name="custom"/>
</client>

```

```xml

<bindings>
    <customBinding>
        <binding name="custom">
            <security defaultAlgorithmSuite="Default" authenticationMode="UserNameOverTransport"
                      requireDerivedKeys="true" includeTimestamp="true"
                      messageSecurityVersion="WSSecurity11WSTrustFebruary2005WSSecureConversationFebruar y2005WSSecurityPolicy11BasicSecurityProfile10">
                <localClientSettings detectReplays="false"/>
                <localServiceSettings detectReplays="false"/>
            </security>
            <textMessageEncoding messageVersion="Soap11WSAddressing10"/>
            <httpsTransport maxReceivedMessageSize="2147483647" maxBufferPoolSize="2147483647"/>
        </binding>
    </customBinding>
</bindings>
```

## 4. Zakres udostępnianych danych i podstawa prawna

Podstawa prawna Prowadzenie krajowego rejestru urzędowego podziału terytorialnego kraju (TERYT) ma swoje umocowanie
wart. 47 ust. 1 ustawy o statystyce publicznej (Dz. U. z 2012 r. poz. 591, z późn. zm.). Natomiast szczegółowe
zasady prowadzenia rejestru, zgodnie z art. 49 ustawy reguluje Rozporządzenie Rady Ministrów z dnia 15 grudnia 1998 r.
w sprawie szczegółowych zasad prowadzenia, stosowania i udostępniania krajowego rejestru urzędowego podziału
terytorialnego kraju oraz związanych z tym obowiązków organów administracji rządowej i jednostek samorządu
terytorialnego (Dz. U. z 1998 r. Nr 157, poz. 1031, z późn. zm.). Zakres udostępnianych danych Zgodnie z art. 48 ust. 1
ustawy o statystyce publicznej rejestr terytorialny jest jawny.Rozporządzenie w sprawie rejestru TERYT (§ 18) wskazuje
formy udostępniania danych gromadzonych w rejestrze, jako: -wyciągi ze zbiorów informatycznych z poszczególnych
systemów:

- identyfikatorów i nazw jednostek podziału terytorialnego (TERC),
- identyfikatorów i nazw miejscowości (SIMC),
- rejonów statystycznych i obwodów spisowych (BREC),
- identyfikacji adresowej ulic, nieruchomości, budynków i mieszkań (NOB C),
- centralnego katalogu ulic (ULIC). -odrysy z map przebiegu granic podziału na rejony statystyczne i obwody spisowe (w
  chwili obecnej jest to numeryczna warstwa granic jednostek podziału statystycznego). W ramach usługi
  TERYT ws1 udostępnianie są w pełnym zakresie dane z systemów TERC, SIMC i ULIC.

## 5. Regulamin korzystania z usługi

### 1. Definicje

1. Usługodawca — Główny Urząd Statystyczny, z siedzibą przy al. Niepodległości 208, 00-925 Warszawa.
2. Usługobiorca – Użytkownik uprawniony do dostępu do danych z rejestru TERYT.
3. Usługa udostępniania danych z rejestru TERYT (usługa TERYT ws1) - Oprogramowanie, usługa sieciowa, pozwalająca na
   pobieranie danych z rejestru TERYT bezpośrednio z poziomu zewnętrznych systemów teleinformatycznych.

### 2. Zasady korzystania z Usługi ws1

1. Korzystanie z usługi TERYT ws1, zwanej dalej Usługą, wiąże się z akceptacją niniejszego regulaminu (wraz z
   późniejszymi zmianami).

2. Dostęp do Usługi jest bezpłatny.

3. Metody udostępniane przez Usługę mogą być implementowane w dowolnych systemach teleinformatycznych, wytwarzanych
   przez usługobiorcę.

4. Niedozwolone są działania mogące doprowadzić do przeciążenia systemu bądź jego nieprawidłowego działania. W
   szczególności niedozwolone są następujące działania: - Wysyłanie do usługi bardzo dużej liczby żądań o dane w krótkim
   czasie. - Przełamywanie lub omijanie zabezpieczeń w postaci identyfikatora użytkownika.

### 3. Odpowiedzialność

1. Usługodawca zastrzega sobie prawo do wprowadzania modyfikacji do systemu, prowadzenia prac konserwacyjnych oraz
   innych działań mogących powodować czasową niedostępność lub utrudnienia w
   korzystaniu z Usługi.
2. Usługodawca nie ponosi odpowiedzialności z tytułu utraconych korzyści poniesionych przez Usługobiorcę lub osoby
   trzecie korzystające z Usługi.
3. Usługodawca nie ponosi odpowiedzialności za brak możliwości dostępu do usług wynikający z niezgodnego ze specyfikacją
   techniczną wykorzystywania Usługi.

### 4. Ochrona danych i prywatność

1. Usługobiorca w momencie rejestracji wyraża zgodę na przechowywanie i przetwarzanie danych osobowych przez
   Usługodawcę, na warunkach określonych w ustawie o świadczeniu usług drogą elektroniczną oraz ustawie o ochronie
   danych osobowych.

2. Usługodawca gromadzi, podane w trakcie rejestracji, informacje o Usługobiorcach wyłącznie w celu obsługi
   kontrolowania dostępu do Usługi.

3. Podczas komunikacji z usługą, system automatycznie odnotowuje dane techniczne Usługobiorcy takie jak: adres IP
   urządzenia, datę, czas i treść wysyłanych do Usługi żądań.

## 6. Gwarancja jakości usług

### 1. Definicje

1. Awaria — niezaplanowana niedostępność usługi TERYT ws1 przez czas dłuższy niż 15 minut.
2. Przerwa techniczna — zaplanowana niedostępność usługi TERYT ws1 związana z koniecznością przeprowadzenia prac
   konserwacyjnych.
3. Problem — zgłoszony telefonicznie lub za pośrednictwem poczty elektronicznej problem, lub zapytanie odnośnie
   funkcjonowania usługi TERYT ws1.

### 2. Zgłoszenie Awarii lub Problemu

Zgłoszeń Awarii lub Problemów należy dokonywać za pośrednictwem poczty elektronicznej, lub telefonicznie. - Na adres
email: teryt_support@stat.gov.pl W treści zgłoszenia należy czy dotyczy ono problemu/awarii, imię i nazwisko oraz
stacjonarny numer telefonu osoby do kontaktu. - Telefonicznie, pod numerem telefonu 42 683-90-67

### 3. Gwarancja dostępności usług

Zapewniana jest dostępność na poziomie: 99,0%. Maksymalny czas niedostępności w ciągu roku: 7 godzin.

### 4. Przerwy techniczne

Usługodawca informuje Usługobiorcę o planowanych przerwach technicznych z 24 godzinnym wyprzedzeniem. Informacje o
przerwach technicznych będą przekazywane na adres email osoby wskazanej przez Usługobiorcę w trakcie rejestracji.
Informacje będą wysyłane z adresu email teryt_noreply@stat.gov.pl

### 5. Wyjątki

Gwarancja jakości usług nie obejmuje następujących sytuacji:

1. Niedostępność usługi spowodowana jest działaniem siły wyższej,
2. Niedostępność usługi spowodowana jest awarią urządzeń niebędących częścią systemu teleinformatycznego GUS,
3. Niedostępność usługi spowodowana jest działaniem Usługobiorcy, w szczególności niestosowaniem się do Regulaminu
   korzystania z usługi bądź ustaleń porozumienia z GUS.
