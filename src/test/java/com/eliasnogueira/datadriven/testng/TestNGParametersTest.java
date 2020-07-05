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

package com.eliasnogueira.datadriven.testng;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/*
 * Limitation comparing to the JUnit 5
 *  - the @Parameters only accepts String as parameter
 *  - every parameter value should have a parameter related on the test methods
 *  - it should run only with the TestNG suite through XML file
 *  --- there's a XML file on src/test/resource called testng_data_parameter.xml that will run this class using data
 *
 * It's better to use this approach when you need to get a value as a configuration.
 */
public class TestNGParametersTest {

    private static final String VALUE = "7.00";

    @Test(testName = "Getting data from xml test suite")
    @Parameters({"product", "amount"})
    public void getDataFromXmlSuite(String product, String amount) {
        final String expectedProduct = "Micro SD Card 16Gb";
        final String expectedAmount = "7.00";

        assertThat(product).isEqualTo(expectedProduct);
        assertThat(amount).isEqualTo(expectedAmount);
    }
}
