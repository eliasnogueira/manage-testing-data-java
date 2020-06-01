package com.eliasnogueira.properties.plain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PropertiesFileTest {

    /**
     * The main point with this approach is that the property value returns as a String object We must apply a type
     * conversion later
     */
    @Test
    void userLogin() {
        String username = ReadProperties.getInstance().getValue("user");
        String password = ReadProperties.getInstance().getValue("password");
        String environment = ReadProperties.getInstance().getValue("environment.name");
        String domain = ReadProperties.getInstance().getValue("domain");
        String port = ReadProperties.getInstance().getValue("port");
        String endpoint = ReadProperties.getInstance().getValue("endpoint");

        assertThat(username).isEqualTo("admin");
        assertThat(password).isEqualTo("changeMe");
        assertThat(environment).isEqualTo("eliasnogueira");
        assertThat(domain).isEqualTo("com");
        assertThat(port).isEqualTo("80");

        // plain java class to get a property value does not a placeholder
        assertThat(endpoint).isNotEmpty();
    }

    @Test
    void propertyNotFound() {
        assertThat(
            ReadProperties.getInstance().getValue("propertyDoesNotExists")).
            isNullOrEmpty();
    }
}
