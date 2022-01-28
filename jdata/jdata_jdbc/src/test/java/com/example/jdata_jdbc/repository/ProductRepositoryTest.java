package com.example.jdata_jdbc.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {

    @Test
    void read_readsSearchScriptProperly() {

        final String scriptFilename = "search.sql";
        final String expected = "SELECT productName\n" +
                "FROM orders\n" +
                "WHERE customer.name = BINARY(:name)";

        assertEquals(expected, ProductRepository.read(scriptFilename));
    }

    @Test
    void read_ifNoFile_throwsException() {
        final String wrongFilename = "wrong.sql";
        assertThrows(RuntimeException.class, () -> ProductRepository.read(wrongFilename));
    }
}