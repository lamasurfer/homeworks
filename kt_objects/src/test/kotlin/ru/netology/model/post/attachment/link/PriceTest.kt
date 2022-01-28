package ru.netology.model.post.attachment.link

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class PriceTest {

    @Test
    fun test_price_defaults() {
        val price = Price()
        assertEquals(0L, price.amount)
        assertEquals(Currency.getInstance(Locale("ru", "RU")), price.currency)
        assertEquals("", price.text)
    }
}