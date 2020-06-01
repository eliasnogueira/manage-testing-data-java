package com.eliasnogueira.datadriven.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/*
 * Limitation comparing to the JUnit 5
 *  - the @Parameters only accepts String as parameter
 *  - every parameter value should have a parameter related on the test methods
 *  - it should run only with the TestNG suite through XML file
 *  --- there's a XML file on src/test/resource called testng_data_parameter.xml that will run this class using data
 */
public class TestNGParametersTest {

    private static final String VALUE = "7";

    @Test(testName = "Values are greater than or equals to")
    @Parameters({"product", "amount"})
    public void fixedDataOnTestMethod(String product, String amount) {
        System.out.println("product = " + product);
        System.out.println("amount = " + amount);
    }
}
