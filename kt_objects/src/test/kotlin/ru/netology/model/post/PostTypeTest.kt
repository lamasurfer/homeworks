package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test

class PostTypeTest {

    @Test
    fun test_postType_getValue_expected() {
        val postTypes = PostType.values()
        postTypes.forEach {
            when (it) {
                PostType.POST -> assertEquals("post", PostType.POST.value)
                PostType.COPY -> assertEquals("copy", PostType.COPY.value)
                PostType.REPLY -> assertEquals("reply", PostType.REPLY.value)
                PostType.POSTPONE -> assertEquals("postpone", PostType.POSTPONE.value)
                PostType.SUGGEST -> assertEquals("suggest", PostType.SUGGEST.value)
            }
        }
    }
}