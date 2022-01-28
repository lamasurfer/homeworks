package ru.netology.model.post.attachment.video

import org.junit.Assert.assertEquals
import org.junit.Test

class VideoImageTest {

    @Test
    fun test_videoImage_defaults() {
        val videoImage = VideoImage()
        assertEquals(0, videoImage.height)
        assertEquals("", videoImage.url)
        assertEquals(0, videoImage.width)
        assertEquals(false, videoImage.withPadding)
    }
}