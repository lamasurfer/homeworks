package ru.netology.model.post.attachment.link

import org.junit.Assert.assertEquals
import org.junit.Test

class ButtonActionTypeTest {

    @Test
    fun test_buttonType_getValue_expected() {
        val buttonActionType = ButtonActionType.values()
        buttonActionType.forEach {
            when (it) {
                ButtonActionType.OPEN_URL -> assertEquals("open_url", ButtonActionType.OPEN_URL.value)
            }
        }
    }
}