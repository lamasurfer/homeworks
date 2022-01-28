package ru.netology.model.post.attachment.video

import org.junit.Assert.assertEquals
import org.junit.Test

class VideoTypeTest {

    @Test
    fun test_videoType_getValue_expected() {
        val videoType = VideoType.values()
        videoType.forEach {
            when (it) {
                VideoType.VIDEO -> assertEquals("video", VideoType.VIDEO.value)
                VideoType.MUSIC_VIDEO -> assertEquals("music_video", VideoType.MUSIC_VIDEO.value)
                VideoType.MOVIE -> assertEquals("movie", VideoType.MOVIE.value)
            }
        }
    }
}