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

package com.eliasnogueira.datadriven.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
 * CONS WITH THIS APPROACH
 * The only problem about using an external method source is that the class and method might be show from your IDE
 * the 'is never used' alert message
 *
 * PROS WITH THIS APPROACH
 * All the data is withing the tests
 */
class JUnitInternalMethodSourceTest {

    @DisplayName("All products should be cheap")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} is cheap")
    @MethodSource("cheapProducts")
    void cheapProducts(String product, BigDecimal amount) {
        final BigDecimal maximumPrice = new BigDecimal("30.0");

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(maximumPrice);
    }

    @DisplayName("All products should be expensive")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} is expensive")
    @MethodSource("expensiveProducts")
    void expensiveProducts(String product, BigDecimal amount) {
        final BigDecimal minimumPrice = new BigDecimal("799");

        assertThat(product).isNotEmpty();
        assertThat(amount).isGreaterThanOrEqualTo(minimumPrice);
    }

    static Stream<Arguments> cheapProducts() {
        return Stream.of(
                arguments("Micro SD Card 16Gb", new BigDecimal("6.09")),
                arguments("JBL GO 2", new BigDecimal("22.37")),
                arguments("iPad Air Case", new BigDecimal("14.99"))
        );
    }

    static Stream<Arguments> expensiveProducts() {
        return Stream.of(
                arguments("iPhone 11 Pro", new BigDecimal("999.00")),
                arguments("MacBook Pro 16", new BigDecimal("2799.00")),
                arguments("Ipad Air Pro", new BigDecimal("799.00"))
        );
    }
}
