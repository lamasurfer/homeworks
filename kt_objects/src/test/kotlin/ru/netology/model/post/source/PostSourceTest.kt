package ru.netology.model.post.source

import org.junit.Assert.assertEquals
import org.junit.Test

class PostSourceTest {

    @Test
    fun test_donut_defaults() {
        val source = PostSource()
        assertEquals(PostSourceType.VK, source.type)
        assertEquals("", source.platform)
        assertEquals("", source.data)
        assertEquals("", source.url)
    }
}