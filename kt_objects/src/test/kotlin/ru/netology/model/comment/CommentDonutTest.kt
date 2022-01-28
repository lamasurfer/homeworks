package ru.netology.model.comment

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.model.post.donut.Placeholder

class CommentDonutTest {

    @Test
    fun test_commentDonut_defaults() {
        val commentDonut = CommentDonut()
        assertEquals(false, commentDonut.isDon)
        assertEquals(Placeholder(), commentDonut.placeholder)
    }
}