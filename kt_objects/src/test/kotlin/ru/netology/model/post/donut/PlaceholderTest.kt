package ru.netology.model.post.donut

import org.junit.Assert.assertEquals
import org.junit.Test

class PlaceholderTest {

    @Test
    fun test_placeholder_defaults() {
        val placeholder = Placeholder()
        assertEquals("", placeholder.value)
    }
}