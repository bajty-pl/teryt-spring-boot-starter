module teryt.spring.boot.starter {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires jakarta.xml.bind;
    requires jakarta.xml.ws;
    requires java.logging;

    exports pl.bajty.teryt.api;
    exports pl.bajty.teryt.model;
}