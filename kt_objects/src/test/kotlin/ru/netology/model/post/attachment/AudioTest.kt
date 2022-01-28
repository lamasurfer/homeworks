package ru.netology.model.post.attachment

import org.junit.Assert.assertEquals
import org.junit.Test

class AudioTest {

    @Test
    fun test_audio_defaults() {
        val audio = Audio()
        assertEquals(0L, audio.id)
        assertEquals(0L, audio.ownerId)
        assertEquals(0L, audio.albumId)
        assertEquals("", audio.artist)
        assertEquals("", audio.title)
        assertEquals(0L, audio.duration)
        assertEquals("", audio.url)
        assertEquals(0L, audio.lyricsId)
        assertEquals(0L, audio.albumId)
        assertEquals(0L, audio.genreId)
        assertEquals(0L, audio.date)
        assertEquals(false, audio.noSearch)
        assertEquals(false, audio.isHq)
        assertEquals(AttachmentType.AUDIO, audio.type)
    }
}