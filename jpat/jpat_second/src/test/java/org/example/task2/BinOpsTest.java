package org.example.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinOpsTest {

    private final BinOps binOps = new BinOps();

    @Test
    void sum_validArgument_expectedResult() {
        String term1 = "1000000"; //64
        String term2 = "1000001"; //65
        String expected = "10000001"; // 129
        Assertions.assertEquals(expected, binOps.sum(term1, term2));
    }

    @Test
    void sum_nullArgument_throwsException() {
        Assertions.assertThrows(NullPointerException.class, () -> binOps.sum(null, "0"));
        Assertions.assertThrows(NullPointerException.class, () -> binOps.sum("0", null));
    }

    @Test
    void sum_emptyArgument_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> binOps.sum("", "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> binOps.sum("0", ""));
    }

    @Test
    void sum_invalidArgument_throwsException() {
        Assertions.assertThrows(NumberFormatException.class, () -> binOps.sum("zzzz", "0"));
        Assertions.assertThrows(NumberFormatException.class, () -> binOps.sum("0", "zzzz"));
    }

    @Test
    void mult_validArgument_expectedResult() {
        String term1 = "1000000"; //64
        String term2 = "1000001"; //65
        String expected = "1000001000000"; //4160

        Assertions.assertEquals(expected, binOps.mult(term1, term2));
    }

    @Test
    void mult_nullArgument_throwsException() {
        Assertions.assertThrows(NullPointerException.class, () -> binOps.mult(null, "0"));
        Assertions.assertThrows(NullPointerException.class, () -> binOps.mult("0", null));
    }

    @Test
    void mult_emptyArgument_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> binOps.mult("", "0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> binOps.mult("0", ""));
    }

    @Test
    void mult_invalidArgument_throwsException() {
        Assertions.assertThrows(NumberFormatException.class, () -> binOps.mult("zzzz", "0"));
        Assertions.assertThrows(NumberFormatException.class, () -> binOps.mult("0", "zzzz"));
    }
}