package com.eliasnogueira.properties.owner;

import java.net.URL;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:data.properties"})
public interface PropertiesFile extends Config {

    String user();

    String password();

    @Key("environment.name")
    String environmentName();

    String domain();

    int port();

    URL endpoint();

}
