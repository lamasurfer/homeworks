package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PaymentTypeKtTest {

    @Test
    fun test_getPercentageExtensionFunction_expectedBehaviour() {
        val factor = 0.0075
        val value = 5777_00L
        val expected = 4333L
        assertEquals(expected, value.getPercentage(factor))
    }
}