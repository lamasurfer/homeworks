package ru.netology.model.post.donut

import org.junit.Assert.assertEquals
import org.junit.Test

class EditModeTest {

    @Test
    fun test_editMode_getValue_expected() {
        val editModes = EditMode.values()
        editModes.forEach {
            when (it) {
                EditMode.ALL -> assertEquals("all", EditMode.ALL.value)
                EditMode.DURATION -> assertEquals("duration", EditMode.DURATION.value)
            }
        }
    }
}