package com.eliasnogueira.datadriven.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CsvSourceTest {
    private static final String MAXIMUM_PRICE = "30.0";

    @DisplayName("Products should not exceed the maximum price")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} does not exceeds $" + MAXIMUM_PRICE)
    @CsvSource({
            "Micro SD Card 16Gb, 6.09",
            "JBL GO 2, 22.37",
            "iPad Air Case, 14.99",

    })
    void productsLassThan(String product, BigDecimal amount) {

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(new BigDecimal(MAXIMUM_PRICE));
    }
}
