package ru.netology

import kotlin.math.roundToLong

enum class PaymentType(private val description: String) {
    MASTERCARD("Mastercard") {
        private val limit = 75_000_00L
        private val factor = 0.006
        private val fixedFee = 20_00L
        private val noFee = 0L
        override fun processPayment(previousAmount: Long, currentAmount: Long): Long {
            return if (previousAmount < limit) noFee else currentAmount.getPercentage(factor) + fixedFee
        }
    },
    MAESTRO("Maestro") {
        override fun processPayment(previousAmount: Long, currentAmount: Long): Long {
            return MASTERCARD.processPayment(previousAmount, currentAmount)
        }
    },
    VISA("Visa") {
        private val chargedAmount = 4_667_34L
        private val factor = 0.0075
        private val fixedFee = 35_00L
        override fun processPayment(previousAmount: Long, currentAmount: Long): Long {
            return if (currentAmount < chargedAmount) fixedFee else currentAmount.getPercentage(factor)
        }
    },
    MIR("Мир") {
        override fun processPayment(previousAmount: Long, currentAmount: Long): Long {
            return VISA.processPayment(previousAmount, currentAmount)
        }
    },
    VK_PAY("VK Pay") {
        private val noFee = 0L
        override fun processPayment(previousAmount: Long, currentAmount: Long): Long = noFee
    };

    abstract fun processPayment(previousAmount: Long, currentAmount: Long): Long
}

fun Long.getPercentage(factor: Double): Long = (this * factor).roundToLong()
