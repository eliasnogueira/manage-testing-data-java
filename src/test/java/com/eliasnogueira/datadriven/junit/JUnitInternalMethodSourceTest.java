package com.eliasnogueira.datadriven.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
 * CONS WITH THIS APPROACH
 * The only problem about using an external method source is that the class and method might be show from your IDE
 * the 'is never used' alert message
 *
 * PROS WITH THIS APPROACH
 * All the data is withing the tests
 */
public class JUnitInternalMethodSourceTest {

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
