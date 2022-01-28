package ru.netology.model.post.geo

import org.junit.Assert.assertEquals
import org.junit.Test

class PlaceTest {

    @Test
    fun test_comments_defaults() {
        val place = Place()
        assertEquals(0L, place.id)
        assertEquals("", place.title)
        assertEquals(0L, place.latitude)
        assertEquals(0L, place.longitude)
        assertEquals(0L, place.created)
        assertEquals("", place.icon)
        assertEquals(0L, place.checkins)
        assertEquals(0L, place.updated)
        assertEquals(0L, place.type)
        assertEquals(0L, place.country)
        assertEquals(0L, place.city)
        assertEquals("", place.address)
    }
}