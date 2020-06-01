package com.eliasnogueira.properties.plain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadProperties {

    private static final Logger LOGGER = LogManager.getLogger(ReadProperties.class.getName());

    private static ReadProperties instance = null;
    private final Properties properties;

    private ReadProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/data.properties"));
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static synchronized ReadProperties getInstance() {
        if (instance == null) instance = new ReadProperties();
        return instance;
    }

    public String getValue(String propertyName) {
        return this.properties.getProperty(propertyName);
    }
}
