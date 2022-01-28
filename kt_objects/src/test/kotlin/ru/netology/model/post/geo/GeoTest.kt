package ru.netology.model.post.geo

import org.junit.Assert.assertEquals
import org.junit.Test

class GeoTest {

    @Test
    fun test_comments_defaults() {
        val geo = Geo()
        assertEquals("", geo.type)
        assertEquals("", geo.coordinates)
        assertEquals(null, geo.place)
    }
}