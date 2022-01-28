package ru.netology.model.post.donut

import org.junit.Assert.assertEquals
import org.junit.Test

class DonutTest {

    @Test
    fun test_donut_defaults() {
        val donut = Donut()
        assertEquals(false, donut.isDonut)
        assertEquals(0L, donut.paidDuration)
        assertEquals(Placeholder(), donut.placeholder)
        assertEquals(false, donut.canPublishFreeCopy)
        assertEquals(EditMode.ALL, donut.editMode)
    }
}