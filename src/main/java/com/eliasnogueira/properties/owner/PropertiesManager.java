package com.eliasnogueira.properties.owner;

import org.aeonbits.owner.ConfigCache;

public class PropertiesManager {

    private PropertiesManager() {}

    public static PropertiesFile getProperties() {
        return ConfigCache.getOrCreate(PropertiesFile.class);
    }
}
