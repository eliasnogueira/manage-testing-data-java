package com.eliasnogueira.datadriven;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ProductsDataArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
            arguments("Micro SD Card 16Gb", new BigDecimal("6.09")),
            arguments("JBL GO 2", new BigDecimal("22.37")),
            arguments("iPad Air Case", new BigDecimal("14.99"))
        );
    }
}
