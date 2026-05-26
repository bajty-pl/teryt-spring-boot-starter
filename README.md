# TERYT Spring Boot Starter

![Status](https://img.shields.io/badge/Status-Work_in_Progress-orange.svg)
[![Java Version](https://img.shields.io/badge/Java-25-blue.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**TERYT Spring Boot Starter** to lekka biblioteka ułatwiająca integrację aplikacji Spring Boot z rejestrem TERYT
udostępnianym przez Główny Urząd Statystyczny (Usługa sieciowa TERYT ws1).

Zdejmuje z barków programisty konieczność ręcznej obsługi protokołu SOAP, generowania klas z WSDL oraz konfiguracji
nagłówków zabezpieczeń WS-Security, specyficznych ustawień certyfikatów i wielu innych trudności. Udostępnia czyste,
współczesne API oparte na rekordach i enumach. Minimum wysiłku.

## Główne cechy

* **Zero Boilerplate'u:** Podajesz swój login i hasło w `application.yml` i gotowe. Klient jest wstrzykiwany
  automatycznie.
* **Hermetyzacja:** Brzydkie klasy wygenerowane przez JAXB/CXF nigdy nie wyciekają do Twojego kodu biznesowego. API
  udostępnia wyłącznie czyste obiekty `Record` i `Enum`.
* **Lekkość:** Biblioteka nie ciągnie za sobą zbędnych zależności. Opiera się na natywnym
  `spring-boot-starter-webservices`. Nie potrzebujesz JAXB/CXF ani własnego mappera.
* **Prostota obsługi:** Przejdź do sekcji [Quick Start](#quick-start) i przekonaj się, że włożyliśmy w to wysiłek, abyś
  Ty nie musiał.
* **Język wszechobecny:** Świadomie zrezygnowaliśmy z tłumaczenia jednostek administracyjnych i innych oficjalnych nazw
  na język angielski. Zamiast tracić czas na domysły, czy gmina to w kodzie municipality, commune czy district (a
  województwo to voivodeship, state czy province), biblioteka używa pojęć prosto z oficjalnej dokumentacji GUS. W kodzie
  znajdziesz
  po prostu obiekty Wojewodztwo, Powiat, Gmina, Miejscowosc oraz Ulica.
* **Przyjazność dla testów**: Projektowanie z myślą o testowalności to priorytet. Dzięki architekturze opartej na
  interfejsach, bez trudu zamockujesz klienta w swoich testach (TerytClient mock = mock(TerytClient.class);). Dodatkowo
  biblioteka zawiera gotowe testy integracyjne, które możesz wykorzystać do weryfikacji połączenia z API Teryt w swoim
  środowisku.
* **Nowoczesność:** Wykorzystuje możliwości **Javy 25**.

## Wymagania

* Java 25+
* Spring Boot 4.0+

## Quick Start

### 1. Dodaj zależność

Do czasu opracowania wersji 1.0.0 biblioteka będzie hostowana tylko w GitHub Packages.

W celu uzyskania dostępu dodaj poniższą sekcję do swojego pliku pom.xml (lub settings.xml):

```xml

<repositories>
    <repository>
        <id>github-bajty</id>
        <name>GitHub Bajty Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/TWOJA_NAZWA_UZYTKOWNIKA/teryt-spring-boot-starter</url>
    </repository>
</repositories>
```

Do pliku `pom.xml` w swoim projekcie dodaj:

```xml

<dependency>
    <groupId>pl.bajty.teryt</groupId>
    <artifactId>teryt-spring-boot-starter</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```

### 2. W pliku application.yml (lub application.properties) Twojej aplikacji dodaj konfigurację połączenia z TERYT ws1:

```yaml
teryt:
  username: twoj_login_ws1
  password: twoje_haslo_ws1
```

### 3. Używaj API w kodzie, np.:

```java

@RestController
@RequestMapping("/api/teryt")
@RequiredArgsConstructor
class LocationController {

    private final TerytClient terytClient;

    @GetMapping("/wojewodztwa")
    public List<Wojewodztwo> getWojewodztwa() {
        return terytClient.getWojewodztwa();
    }
}
```

## Licencja

Projekt udostępniany jest na licencji MIT, co oznacza, że możesz go używać za darmo zarówno w projektach open-source,
jak i komercyjnych, z pewnymi zastrzeżeniami. Szczegóły w pliku LICENSE.

---

> **Uwaga:** Ten projekt jest niezależną inicjatywą open-source tworzoną przez [bajty.pl](https://bajty.pl) i
> **nie jest** oficjalnym oprogramowaniem Głównego Urzędu Statystycznego (GUS).

> 💡 **Wsparcie i kontakt:** Znalazłeś błąd lub masz propozycję nowej funkcji? Najszybszą drogą kontaktu jest utworzenie
> zgłoszenia w zakładce [GitHub Issues](https://github.com/bajty-pl/teryt-spring-boot-starter/issues). W pozostałych
> sprawach zapraszamy do kontaktu na adres [kontakt@bajty.pl](mailto:kontakt@bajty.pl).
