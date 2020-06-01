package com.eliasnogueira.datadriven.testng;

import static org.assertj.core.api.Assertions.assertThat;

import com.eliasnogueira.datadriven.TestNGDataProvider;
import java.math.BigDecimal;
import org.testng.annotations.Test;

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
