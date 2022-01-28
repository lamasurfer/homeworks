package ru.netology.chat.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ChatUserTest {

    @Test
    fun test_user_defaults() {
        val id = 0L
        val nickname = "nickname"
        val user = ChatUser(
            id = id,
            nickname = nickname,
        )
        assertEquals(id, user.id)
        assertEquals(nickname, user.nickname)
    }
}