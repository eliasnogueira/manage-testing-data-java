/*
 * MIT License
 *
 * Copyright (c) 2023 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.eliasnogueira.properties.plain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private static final String PROPERTIES_RESOURCE = "/data.properties";
    private static final Logger LOGGER = LogManager.getLogger(ReadProperties.class.getName());

    private static ReadProperties instance = null;
    private final Properties properties;

    private ReadProperties() {
        properties = new Properties();

        try (InputStream inputStream = ReadProperties.class.getResourceAsStream(PROPERTIES_RESOURCE)) {
            if (inputStream == null) {
                String message = "Properties resource was not found: " + PROPERTIES_RESOURCE;
                LOGGER.error(message);
                throw new IllegalStateException(message);
            }

            properties.load(inputStream);
        } catch (IOException e) {
            String message = "Unable to load properties resource: " + PROPERTIES_RESOURCE;
            LOGGER.error(message, e);
            throw new IllegalStateException(message, e);
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
