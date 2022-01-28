package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
internal class TransfersKtParametrizedTest(
    private val paymentType: PaymentType,
    private val previousAmount: Long,
    private val currentAmount: Long,
    private val expected: Long,
) {

    @Test
    fun test_getFee_withArguments_expectedBehaviour() {
        assertEquals(expected, getFee(paymentType, previousAmount, currentAmount))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun payments() = listOf(
            arrayOf(PaymentType.MASTERCARD, 75000_00L - 1, 5000_00, 0),
            arrayOf(PaymentType.MASTERCARD, 75000_00L, 5000_00, 50_00),
            arrayOf(PaymentType.MAESTRO, 75000_00L - 1, 5000_00, 0),
            arrayOf(PaymentType.MAESTRO, 75000_00L, 5000_00, 50_00),
            arrayOf(PaymentType.VISA, 0, 4667_33L, 35_00),
            arrayOf(PaymentType.VISA, 0, 4667_33L + 1, 35_01),
            arrayOf(PaymentType.MIR, 0, 4667_33L, 35_00),
            arrayOf(PaymentType.MIR, 0, 4667_33L + 1, 35_01),
            arrayOf(PaymentType.VK_PAY, 0, 5000_00, 0),
        )
    }
}