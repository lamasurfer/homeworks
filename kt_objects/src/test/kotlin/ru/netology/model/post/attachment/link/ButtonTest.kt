package ru.netology.model.post.attachment.link

import org.junit.Assert.assertEquals
import org.junit.Test

class ButtonTest {

    @Test
    fun test_button() {
        val button = Button()
        assertEquals("", button.title)
        assertEquals(ButtonAction(), button.action)
    }
}