package com.eliasnogueira.datadriven.junit;

import static org.assertj.core.api.Assertions.assertThat;

import com.eliasnogueira.datadriven.ProductsDataArgumentProvider;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

/*
 * CONS WITH THIS APPROACH
 * Only one test per data
 *
 * PROS WITH THIS APPROACH
 * Single data class responsibility
 */
public class JUnitArgumentProviderTest {

    private static final String MAXIMUM_PRICE = "30.0";

    @DisplayName("Products should not exceed the maximum price")
    @ParameterizedTest(name = "product ''{0}'' of amount ${1} does not exceeds $" + MAXIMUM_PRICE)
    @ArgumentsSource(ProductsDataArgumentProvider.class)
    void cheapProducts(String product, BigDecimal amount) {
        final BigDecimal maximumPrice = new BigDecimal("30.0");

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(new BigDecimal(MAXIMUM_PRICE));
    }
}
