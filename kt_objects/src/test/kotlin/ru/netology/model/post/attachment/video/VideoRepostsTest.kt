package ru.netology.model.post.attachment.video

import org.junit.Assert.assertEquals
import org.junit.Test

class VideoRepostsTest {

    @Test
    fun test_videoReposts_defaults() {
        val videoReposts = VideoReposts()
        assertEquals(0L, videoReposts.count)
        assertEquals(0L, videoReposts.wallCount)
        assertEquals(0L, videoReposts.mailCount)
        assertEquals(false, videoReposts.userReposted)
    }
}