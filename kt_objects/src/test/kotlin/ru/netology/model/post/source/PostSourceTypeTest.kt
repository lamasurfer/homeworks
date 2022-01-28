package ru.netology.model.post.source

import org.junit.Assert.assertEquals
import org.junit.Test

class PostSourceTypeTest {

    @Test
    fun test_sourceType_getValue_expected() {
        val sourceTypes = PostSourceType.values()
        sourceTypes.forEach {
            when (it) {
                PostSourceType.VK -> assertEquals("vk", PostSourceType.VK.value)
                PostSourceType.WIDGET -> assertEquals("widget", PostSourceType.WIDGET.value)
                PostSourceType.API -> assertEquals("api", PostSourceType.API.value)
                PostSourceType.RSS -> assertEquals("rss", PostSourceType.RSS.value)
                PostSourceType.SMS -> assertEquals("sms", PostSourceType.SMS.value)
            }
        }
    }
}