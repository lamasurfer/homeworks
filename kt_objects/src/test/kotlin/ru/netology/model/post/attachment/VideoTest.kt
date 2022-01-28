package ru.netology.model.post.attachment

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.model.post.attachment.video.*

class VideoTest {

    @Test
    fun test_video_defaults() {
        val video = Video()
        assertEquals(0L, video.id)
        assertEquals(0L, video.ownerId)
        assertEquals("", video.title)
        assertEquals("", video.description)
        assertEquals(0L, video.duration)
        assertEquals(arrayListOf<VideoImage>(), video.image)
        assertEquals(arrayListOf<VideoImage>(), video.firstFrame)
        assertEquals(0L, video.date)
        assertEquals(0L, video.addingDate)
        assertEquals(0L, video.views)
        assertEquals(0L, video.localViews)
        assertEquals(0L, video.comments)
        assertEquals("", video.player)
        assertEquals("", video.platform)
        assertEquals(false, video.canAdd)
        assertEquals(false, video.isPrivate)
        assertEquals("", video.accessKey)
        assertEquals(false, video.processing)
        assertEquals(false, video.isFavorite)
        assertEquals(false, video.canComment)
        assertEquals(false, video.canEdit)
        assertEquals(false, video.canLike)
        assertEquals(false, video.canRepost)
        assertEquals(false, video.canSubscribe)
        assertEquals(false, video.canAddToFaves)
        assertEquals(false, video.canAttachLink)
        assertEquals(0, video.width)
        assertEquals(0, video.height)
        assertEquals(0L, video.userId)
        assertEquals(false, video.converting)
        assertEquals(false, video.added)
        assertEquals(false, video.isSubscribed)
        assertEquals(false, video.repeat)
        assertEquals(VideoType.VIDEO, video.videoType)
        assertEquals(0L, video.balance)
        assertEquals(VideoLiveStatus.UPCOMING, video.liveStatus)
        assertEquals(false, video.live)
        assertEquals(false, video.upcoming)
        assertEquals(0L, video.spectators)
        assertEquals(VideoLikes(), video.likes)
        assertEquals(VideoReposts(), video.reposts)
        assertEquals(AttachmentType.VIDEO, video.type)
    }
}