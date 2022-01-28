package ru.netology

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TransfersKtTest {

    @Test
    fun test_main_expectedBehaviour() {
        assertDoesNotThrow { -> main() }
    }

    @Test
    fun test_getFee_withDefaults_expectedBehaviour() {
        val defaultPaymentType = PaymentType.VK_PAY
        val defaultPreviousAmount = 0L
        val currentAmount = 5000_00L
        mockkObject(defaultPaymentType)
        every { defaultPaymentType.processPayment(defaultPreviousAmount, currentAmount) } answers { 0L }

        val expected = 0L
        assertEquals(expected, getFee(currentAmount = currentAmount))
        verify() { defaultPaymentType.processPayment(defaultPreviousAmount, currentAmount) }
    }

    @ParameterizedTest
    @MethodSource("payments")
    fun test_getFee_withArguments_expectedBehaviour(
        paymentType: PaymentType, previousAmount: Long,
        currentAmount: Long,
        expected: Long,
    ) {
        assertEquals(expected, getFee(paymentType, previousAmount, currentAmount))
    }

    companion object {
        @JvmStatic
        fun payments() = listOf(
            Arguments.of(PaymentType.MASTERCARD, 75000_00L - 1, 5000_00, 0),
            Arguments.of(PaymentType.MASTERCARD, 75000_00L, 5000_00, 50_00),
            Arguments.of(PaymentType.MAESTRO, 75000_00L - 1, 5000_00, 0),
            Arguments.of(PaymentType.MAESTRO, 75000_00L, 5000_00, 50_00),
            Arguments.of(PaymentType.VISA, 0, 4667_33L, 35_00),
            Arguments.of(PaymentType.VISA, 0, 4667_33L + 1, 35_01),
            Arguments.of(PaymentType.MIR, 0, 4667_33L, 35_00),
            Arguments.of(PaymentType.MIR, 0, 4667_33L + 1, 35_01),
            Arguments.of(PaymentType.VK_PAY, 0, 5000_00, 0),
        )
    }
}