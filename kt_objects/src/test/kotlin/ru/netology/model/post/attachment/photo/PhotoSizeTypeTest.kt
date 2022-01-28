package ru.netology.model.post.attachment.photo

import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoSizeTypeTest {

    @Test
    fun test_photoSizeType_getValue_expected() {
        val photoSizeType = PhotoSizeType.values()
        photoSizeType.forEach {
            when (it) {
                PhotoSizeType.S -> assertEquals("s", PhotoSizeType.S.value)
                PhotoSizeType.M -> assertEquals("m", PhotoSizeType.M.value)
                PhotoSizeType.X -> assertEquals("x", PhotoSizeType.X.value)
                PhotoSizeType.O -> assertEquals("o", PhotoSizeType.O.value)
                PhotoSizeType.P -> assertEquals("p", PhotoSizeType.P.value)
                PhotoSizeType.Q -> assertEquals("q", PhotoSizeType.Q.value)
                PhotoSizeType.R -> assertEquals("r", PhotoSizeType.R.value)
                PhotoSizeType.Y -> assertEquals("y", PhotoSizeType.Y.value)
                PhotoSizeType.Z -> assertEquals("z", PhotoSizeType.Z.value)
                PhotoSizeType.W -> assertEquals("w", PhotoSizeType.W.value)
            }
        }
    }
}