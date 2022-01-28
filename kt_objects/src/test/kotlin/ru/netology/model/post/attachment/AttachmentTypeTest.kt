package ru.netology.model.post.attachment

import org.junit.Assert.assertEquals
import org.junit.Test

class AttachmentTypeTest {

    @Test
    fun test_attachmentType_getValue_expected() {
        val attachmentType = AttachmentType.values()
        attachmentType.forEach {
            when (it) {
                AttachmentType.PHOTO -> assertEquals("photo", AttachmentType.PHOTO.value)
                AttachmentType.AUDIO -> assertEquals("audio", AttachmentType.AUDIO.value)
                AttachmentType.VIDEO -> assertEquals("video", AttachmentType.VIDEO.value)
                AttachmentType.LINK -> assertEquals("link", AttachmentType.LINK.value)
                AttachmentType.NOTE -> assertEquals("note", AttachmentType.NOTE.value)
            }
        }
    }
}