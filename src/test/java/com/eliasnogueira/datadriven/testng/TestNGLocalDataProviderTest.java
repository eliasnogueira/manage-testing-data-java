package com.eliasnogueira.datadriven.testng;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.testng.annotations.Test;

public class TestNGLocalDataProviderTest {

    private static final String MAXIMUM_PRICE = "30.0";

    @Test(dataProvider = "cheapProducts")
    void cheapProducts(String product, BigDecimal amount) {
        final BigDecimal maximumPrice = new BigDecimal(MAXIMUM_PRICE);

        assertThat(product).isNotEmpty();
        assertThat(amount).isLessThanOrEqualTo(maximumPrice);
    }

}
