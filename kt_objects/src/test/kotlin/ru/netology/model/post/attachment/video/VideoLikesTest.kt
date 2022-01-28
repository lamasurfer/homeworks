package ru.netology.model.post.attachment.video

import org.junit.Assert.assertEquals
import org.junit.Test

class VideoLikesTest {

    @Test
    fun test_likes_defaults() {
        val videoLikes = VideoLikes()
        assertEquals(0L, videoLikes.count)
        assertEquals(false, videoLikes.userLikes)
    }
}