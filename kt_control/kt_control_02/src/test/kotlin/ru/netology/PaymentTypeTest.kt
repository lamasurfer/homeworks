package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class PaymentTypeTest {

    @Test
    fun test_processPayment_Mastercard_underLimit_returnsZero() {
        val limit = 75000_00L
        val previousAmount = limit - 1L
        val currentAmount = 5000_00L
        val expected = 0L
        assertEquals(expected, PaymentType.MASTERCARD.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Mastercard_aboveLimit_returnsFee() {
        val previousAmount = 75000_00L
        val currentAmount = 5000_00L
        val expected = 5000L
        assertEquals(expected, PaymentType.MASTERCARD.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Maestro_underLimit_returnsZero() {
        val limit = 75000_00L
        val previousAmount = limit - 1L
        val currentAmount = 5000_00L
        val expected = 0L
        assertEquals(expected, PaymentType.MAESTRO.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Maestro_aboveLimit_returnsFee() {
        val previousAmount = 75000_00L
        val currentAmount = 5000_00L
        val expected = 5000L
        assertEquals(expected, PaymentType.MAESTRO.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Visa_underFixed_returnsFixedFee() {
        val previousAmount = Random.nextLong() // yet not important
        val currentAmount = 4667_33L
        val expected = 3500L
        assertEquals(expected, PaymentType.VISA.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Visa_aboveFixed_returnsCalculatedFee() {
        val previousAmount = Random.nextLong() // yet not important
        val currentAmount = 4667_34L
        val expected = 3501L
        assertEquals(expected, PaymentType.VISA.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Mir_underFixed_returnsFixedFee() {
        val previousAmount = Random.nextLong() // yet not important
        val currentAmount = 4667_33L
        val expected = 3500L
        assertEquals(expected, PaymentType.MIR.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_Mir_aboveFixed_returnsCalculatedFee() {
        val previousAmount = Random.nextLong() // yet not important
        val currentAmount = 4667_34L
        val expected = 3501L
        assertEquals(expected, PaymentType.MIR.processPayment(previousAmount, currentAmount))
    }

    @Test
    fun test_processPayment_VKPay_expected() {
        val previousAmount = Random.nextLong()
        val currentAmount = 5000_00L
        val expected = 0L
        assertEquals(expected, PaymentType.VK_PAY.processPayment(previousAmount, currentAmount))
    }
}