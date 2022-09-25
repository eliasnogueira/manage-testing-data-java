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

import com.eliasnogueira.datadriven.TestNGDataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * The dataProvider attribute on @Test annotation tries to find the method name ( cheapProducts or expensiveProducts )
 * on the dataProviderClass TestNGDataProvider.class
 */
public class TestNGExternalDataProviderTest {

    @Test(dataProvider = "cheapProducts", dataProviderClass = TestNGDataProvider.class)
    public void cheapProducts(String product, BigDecimal amount) {
        final BigDecimal maximumPrice = new BigDecimal("30.0");

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(maximumPrice);
    }

    @Test(dataProvider = "expensiveProducts", dataProviderClass = TestNGDataProvider.class)
    public void expensiveProducts(String product, BigDecimal amount) {
        final BigDecimal minimumPrice = new BigDecimal("799");

        assertThat(product).isNotEmpty();
        assertThat(amount).isGreaterThanOrEqualTo(minimumPrice);
    }
}
