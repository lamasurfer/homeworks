package ru.netology

fun main() {
    val amount = 5_999_00L
    val fee = getFee(currentAmount = amount)
    println("Сумма перевода: $amount коп., комиссия: $fee коп.")
}

fun getFee(
    paymentType: PaymentType = PaymentType.VK_PAY,
    previousAmount: Long = 0L,
    currentAmount: Long,
): Long {
    return paymentType.processPayment(previousAmount, currentAmount)
}