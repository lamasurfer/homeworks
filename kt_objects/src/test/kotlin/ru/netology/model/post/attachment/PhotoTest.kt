package ru.netology.model.post.attachment

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.model.post.attachment.photo.PhotoSizes

class PhotoTest {

    @Test
    fun test_photo_defaults() {
        val photo = Photo()
        assertEquals(0L, photo.id)
        assertEquals(0L, photo.albumId)
        assertEquals(0L, photo.ownerId)
        assertEquals(0L, photo.userId)
        assertEquals("", photo.text)
        assertEquals(0L, photo.date)
        assertEquals(arrayListOf<PhotoSizes>(), photo.sizes)
        assertEquals(0L, photo.width)
        assertEquals(0L, photo.height)
        assertEquals(AttachmentType.PHOTO, photo.type)
    }
}