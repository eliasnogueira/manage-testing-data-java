package com.eliasnogueira.datadriven;


import static org.junit.jupiter.params.provider.Arguments.*;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class JUnitExternalData {

    private JUnitExternalData() {}

    public static Stream<Arguments> cheapProducts() {
        return Stream.of(
            arguments("Micro SD Card 16Gb", new BigDecimal("6.09")),
            arguments("JBL GO 2", new BigDecimal("22.37")),
            arguments("iPad Air Case", new BigDecimal("14.99"))
        );
    }

    public static Stream<Arguments> expensiveProducts() {
        return Stream.of(
            arguments("iPhone 11 Pro", new BigDecimal("999.00")),
            arguments("MacBook Pro 16", new BigDecimal("2799.00")),
            arguments("Ipad Air Pro", new BigDecimal("799.00"))
        );
    }
}
