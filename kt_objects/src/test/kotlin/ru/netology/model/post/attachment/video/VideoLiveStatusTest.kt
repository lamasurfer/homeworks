package ru.netology.model.post.attachment.video

import org.junit.Assert.assertEquals
import org.junit.Test

class VideoLiveStatusTest {

    @Test
    fun test_videoLiveStatus_getValue_expected() {
        val videoLiveStatus = VideoLiveStatus.values()
        videoLiveStatus.forEach {
            when (it) {
                VideoLiveStatus.WAITING -> assertEquals("waiting", VideoLiveStatus.WAITING.value)
                VideoLiveStatus.STARTED -> assertEquals("started", VideoLiveStatus.STARTED.value)
                VideoLiveStatus.FINISHED -> assertEquals("finished", VideoLiveStatus.FINISHED.value)
                VideoLiveStatus.FAILED -> assertEquals("failed", VideoLiveStatus.FAILED.value)
                VideoLiveStatus.UPCOMING -> assertEquals("upcoming", VideoLiveStatus.UPCOMING.value)
            }
        }
    }
}