package org.example.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntsCalculatorTest {

    private final Ints calc = new IntsCalculator();

    @Test
    void sum() {
        int a = 1;
        int b = 1;
        int expected = 2;
        Assertions.assertEquals(expected, calc.sum(a, b));
    }

    @Test
    void mult() {
        int a = 2;
        int b = 2;
        int expected = 4;
        Assertions.assertEquals(expected, calc.mult(a, b));
    }

    @Test
    void pow() {
        int a = 2;
        int b = 3;
        int expected = 8;
        Assertions.assertEquals(expected, calc.pow(a, b));
    }
}