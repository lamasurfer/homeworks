package org.example.task2;

import java.util.Objects;

public class BinOps {

    public String sum(String a, String b) {
        checkArguments(a, b);
        int term1 = Integer.parseInt(a, 2);
        int term2 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(term1 + term2);
    }

    public String mult(String a, String b) {
        checkArguments(a, b);
        int factor1 = Integer.parseInt(a, 2);
        int factor2 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(factor1 * factor2);
    }

    private void checkArguments(String argument1, String argument2) {
        Objects.requireNonNull(argument1, "В качестве аргумента передан null!");
        Objects.requireNonNull(argument2, "В качестве аргумента передан null!");
        if (argument1.isEmpty() || argument2.isEmpty()) {
            throw new IllegalArgumentException("В качестве аргумента передана пустая строка!");
        }
    }
}