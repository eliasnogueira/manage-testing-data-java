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
package com.eliasnogueira.datadriven.junit;

import com.eliasnogueira.datadriven.ProductsDataArgumentProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * CONS WITH THIS APPROACH
 * Only one test per data
 *
 * PROS WITH THIS APPROACH
 * Single data class responsibility
 */
class ArgumentProviderTest {

    private static final String MAXIMUM_PRICE = "30.0";

    @DisplayName("Products should not exceed the maximum price")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} does not exceeds $" + MAXIMUM_PRICE)
    @ArgumentsSource(ProductsDataArgumentProvider.class)
    void cheapProducts(String product, BigDecimal amount) {
        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(new BigDecimal(MAXIMUM_PRICE));
    }
}
