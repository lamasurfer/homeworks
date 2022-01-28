package ru.netology.model.post.attachment.link

import org.junit.Assert.assertEquals
import org.junit.Test

class LinkProductTest {

    @Test
    fun test_product_defaults() {
        val linkProduct = LinkProduct()
        assertEquals(Price(), linkProduct.price)
    }
}