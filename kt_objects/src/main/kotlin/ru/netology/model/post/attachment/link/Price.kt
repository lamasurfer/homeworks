package ru.netology.model.post.attachment.link

import java.util.*

data class Price(
    // amount
    val amount: Long = 0L,
    // currency
    val currency: Currency = Currency.getInstance(Locale("ru", "RU")),
    // text
    val text: String = "",
)
