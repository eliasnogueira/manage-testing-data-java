package com.eliasnogueira.datadriven;

import java.math.BigDecimal;
import org.testng.annotations.DataProvider;

public class TestNGDataProvider {

    @DataProvider(name = "cheapProducts")
    public Object[][] cheapProducts() {
        return new Object[][]{
            {"Micro SD Card 16Gb", new BigDecimal("6.09")},
            {"JBL GO 2", new BigDecimal("22.37")},
            {"iPad Air Case", new BigDecimal("14.99")},
        };
    }

    @DataProvider(name = "expensiveProducts")
    public Object[][] expensiveProducts() {
        return new Object[][]{
            {"iPhone 11 Pro", new BigDecimal("999.00")},
            {"MacBook Pro 16", new BigDecimal("2799.00")},
            {"Ipad Air Pro", new BigDecimal("799.00")},
        };
    }
}
