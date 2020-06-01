package com.eliasnogueira.datadriven.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnitValueSourceTest {

    private static final int VALUE = 7;

    @DisplayName("Values are greater than or equals to")
    @ParameterizedTest(name = "{0} is greater than or equals to " + VALUE)
    @ValueSource(ints = {7, 10, 12, 40})
    void fixedDataOnTestMethod(int value) {
        Assertions.assertThat(value).isGreaterThanOrEqualTo(VALUE);
    }
}
