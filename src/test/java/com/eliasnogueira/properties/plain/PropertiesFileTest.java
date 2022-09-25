/*
 * MIT License
 *
 * Copyright (c) 2020 Elias Nogueira
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

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PropertiesFileTest {

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
        assertThat(ReadProperties.getInstance().getValue("propertyDoesNotExists")).isNullOrEmpty();
    }
}
