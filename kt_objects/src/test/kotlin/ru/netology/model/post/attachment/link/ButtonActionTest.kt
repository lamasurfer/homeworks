package ru.netology.model.post.attachment.link

import org.junit.Assert.assertEquals
import org.junit.Test

class ButtonActionTest {

    @Test
    fun test_buttonAction_defaults() {
        val buttonAction = ButtonAction()
        assertEquals(ButtonActionType.OPEN_URL, buttonAction.type)
        assertEquals("", buttonAction.url)
    }
}