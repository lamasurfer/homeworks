package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test

class RepostsTest {

    @Test
    fun test_reposts_defaults() {
        val reposts = Reposts()
        assertEquals(0L, reposts.count)
        assertEquals(false, reposts.userReposted)
    }
}