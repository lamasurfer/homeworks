package ru.netology.model.post.attachment.photo

import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoSizesTest {

    @Test
    fun test_photoSizes_defaults() {
        val photoSizes = PhotoSizes()
        assertEquals(PhotoSizeType.O, photoSizes.type)
        assertEquals("", photoSizes.url)
        assertEquals(0L, photoSizes.width)
        assertEquals(0L, photoSizes.height)
    }
}