/*
 * MIT License
 *
 * Copyright (c) 2020 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.eliasnogueira.datadriven;

import org.testng.annotations.DataProvider;

import java.math.BigDecimal;

public class TestNGDataProvider {

    private TestNGDataProvider(){
    }

    @DataProvider(name = "cheapProducts")
    public static Object[][] cheapProducts() {
        return new Object[][]{
                {"Micro SD Card 16Gb", new BigDecimal("6.09")},
                {"JBL GO 2", new BigDecimal("22.37")},
                {"iPad Air Case", new BigDecimal("14.99")},
        };
    }

    @DataProvider(name = "expensiveProducts")
    public static Object[][] expensiveProducts() {
        return new Object[][]{
                {"iPhone 11 Pro", new BigDecimal("999.00")},
                {"MacBook Pro 16", new BigDecimal("2799.00")},
                {"Ipad Air Pro", new BigDecimal("799.00")},
        };
    }
}
