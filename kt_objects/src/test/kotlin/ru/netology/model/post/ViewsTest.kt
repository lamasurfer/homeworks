package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test

class ViewsTest {

    @Test
    fun test_views_defaults() {
        val views = Views()
        assertEquals(0L, views.count)
    }
}