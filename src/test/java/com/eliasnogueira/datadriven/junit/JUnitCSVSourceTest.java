package com.eliasnogueira.datadriven.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class JUnitCSVSourceTest {

    private static final String MAXIMUM_PRICE = "30.0";

    @DisplayName("Products should not exceed the maximum price")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} does not exceeds $" + MAXIMUM_PRICE)
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void productsLassThan(String product, BigDecimal amount) {

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(new BigDecimal(MAXIMUM_PRICE));
    }
}
