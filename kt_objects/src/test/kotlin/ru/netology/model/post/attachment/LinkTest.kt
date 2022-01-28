package ru.netology.model.post.attachment

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.model.post.attachment.link.Button
import ru.netology.model.post.attachment.link.LinkProduct

class LinkTest {

    @Test
    fun test_link_defaults() {
        val link = Link()
        assertEquals("", link.url)
        assertEquals("", link.title)
        assertEquals("", link.caption)
        assertEquals("", link.description)
        assertEquals(Photo(), link.photo)
        assertEquals(LinkProduct(), link.linkProduct)
        assertEquals(Button(), link.button)
        assertEquals("", link.previewUrl)
        assertEquals(AttachmentType.LINK, link.type)
    }
}