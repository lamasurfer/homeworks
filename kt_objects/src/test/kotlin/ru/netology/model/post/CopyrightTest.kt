package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test

class CopyrightTest {

    @Test
    fun test_copyright_defaults() {
        val copyright = Copyright()
        assertEquals(0L, copyright.id)
        assertEquals("", copyright.link)
        assertEquals("", copyright.name)
        assertEquals("", copyright.type)
    }
}