package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test

class LikesTest {

    @Test
    fun test_likes_defaults() {
        val likes = Likes()
        assertEquals(0L, likes.count)
        assertEquals(false, likes.userLikes)
        assertEquals(false, likes.canLike)
        assertEquals(false, likes.canPublish)
    }
}