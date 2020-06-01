package com.eliasnogueira.datadriven.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/*
 * CONS WITH THIS APPROACH
 * The only problem about using an external method source is that the class and method might be show from your IDE
 * the 'is never used' alert message
 *
 * PROS WITH THIS APPROACH
 * You can have all the data methods in one class
 */
public class JUnitExternalMethodSourceTest {

    private final String CHEAP_PRODUCTS = "com.eliasnogueira.datadriven.JUnitExternalData#cheapProducts";
    private final String EXPENSIVE_PRODUCTS = "com.eliasnogueira.datadriven.JUnitExternalData#expensiveProducts";

    @DisplayName("All products should be cheap")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} is cheap")
    @MethodSource(value = CHEAP_PRODUCTS)
    void cheapProducts(String product, BigDecimal amount) {
        final BigDecimal maximumPrice = new BigDecimal("30.0");

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(maximumPrice);
    }

    @DisplayName("All products should be expensive")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} is expensive")
    @MethodSource(value = EXPENSIVE_PRODUCTS)
    void expensiveProducts(String product, BigDecimal amount) {
        final BigDecimal minimumPrice = new BigDecimal("799");

        assertThat(product).isNotEmpty();
        assertThat(amount).isGreaterThanOrEqualTo(minimumPrice);
    }
}
