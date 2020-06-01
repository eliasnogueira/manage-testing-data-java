package com.eliasnogueira.properties.owner;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;
import org.junit.jupiter.api.Test;

public class PropertiesFileWithOwnerTest {

    private final PropertiesFile propertiesFile = PropertiesManager.getProperties();

    @Test
    void readPropertyTest() {

        String username = propertiesFile.user();
        String password = propertiesFile.password();

        assertThat(username).isEqualTo("admin");
        assertThat(password).isEqualTo("changeMe");
    }

    @Test
    void urlPlaceholderComposition() {
        final String HTTP = "http://";
        final String DOT = ".";
        final String COMMA = ":";

        String environment = propertiesFile.environmentName();
        String domain = propertiesFile.domain();
        int port = propertiesFile.port();
        URL endpoint = propertiesFile.endpoint();

        // the following method validate the values and the correct sequence of the URL placeholder composition
        assertThat(
            endpoint.toString()).
            containsSequence(
                HTTP,
                environment,
                DOT,
                domain,
                COMMA,
                String.valueOf(port));
    }
}
