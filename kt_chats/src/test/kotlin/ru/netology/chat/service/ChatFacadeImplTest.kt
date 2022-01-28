package ru.netology.chat.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test
import ru.netology.chat.exception.ChatServiceException
import ru.netology.chat.model.*
import java.time.LocalDateTime

class ChatFacadeImplTest {

    private val users = mockk<UserService>(relaxed = true)
    private val chats = mockk<ChatService>(relaxed = true)
    private val messages = mockk<MessageService>(relaxed = true)

    private val facade = ChatFacadeImpl(users, chats, messages)

    @Test
    fun test_getUnreadChatsCount_expected() {
        val user = ChatUser(0L, "user1")

        val emptyChat = emptySequence<DirectChat>()

        every { users.getUser(user.id) } returns user
        every { chats.getChats(user) } returns emptyChat

        assertEquals(0, facade.getUnreadChatsCount(user.id))

        val emptyChatMessages = sequenceOf(
            DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf())
        )

        every { chats.getChats(user) } returns emptyChatMessages
        assertEquals(0, facade.getUnreadChatsCount(user.id))

        val date = LocalDateTime.now()
        val msg = "message"

        val first = sequenceOf(
            DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf()),
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 0L, 1L, false, date, msg)
                )
            )
        )

        every { chats.getChats(user) } returns first
        assertEquals(1, facade.getUnreadChatsCount(user.id))

        val second = sequenceOf(
            DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf()),
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 0L, 1L, false, date, msg),
                    ChatMessage(1L, 0L, 1L, true, date, msg),
                    ChatMessage(2L, 1L, 0L, false, date, msg),
                    ChatMessage(3L, 1L, 0L, true, date, msg),
                )
            ),
        )

        every { chats.getChats(user) } returns second
        assertEquals(1, facade.getUnreadChatsCount(user.id))

        val third = sequenceOf(
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 0L, 1L, true, date, msg),
                )
            ),
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 0L, 1L, true, date, msg),
                )
            ),
        )

        every { chats.getChats(user) } returns third
        assertEquals(0, facade.getUnreadChatsCount(user.id))

        val fourth = sequenceOf(
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 1L, 2L, false, date, msg),
                )
            ),
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 1L, 2L, false, date, msg),
                )
            ),
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 1L, 2L, true, date, msg),
                )
            ),
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L,
                listOf(
                    ChatMessage(0L, 1L, 2L, true, date, msg),
                )
            ),
        )

        every { chats.getChats(user) } returns fourth
        assertEquals(0, facade.getUnreadChatsCount(user.id))
    }

    @Test
    fun test_getUnreadChatsCount_expected_exception() {
        val wrong = Long.MAX_VALUE

        every { users.getUser(wrong) }.throws(ChatServiceException("User not found!"))
        try {
            facade.getUnreadChatsCount(wrong)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun test_getChats_expected() {
        val user = ChatUser(0L, "user1")

        // no chats
        val emptyChat = emptySequence<DirectChat>()

        every { users.getUser(user.id) } returns user
        every { chats.getChats(user) } returns emptyChat

        assertEquals("нет сообщений", facade.getChats(user.id))

        // chat but no messages
        val chatSequence1 = sequenceOf(DirectChat(id = 0L, senderId = 0L, receiverId = 1L, emptyList()))

        every { chats.getChats(user) } returns chatSequence1
        assertEquals("нет сообщений", facade.getChats(user.id))

        // chat with messages
        val message = ChatMessage(id = 0L, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val chatWithMessage = DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf(message, message))
        val chatSequence2 = sequenceOf(
            DirectChat(id = 1L, senderId = 0L, receiverId = 1L, emptyList()),
            chatWithMessage,
        )

        every { chats.getChats(user) } returns chatSequence2
        val expected2 = listOf(chatWithMessage).joinToString()
        assertEquals(expected2, facade.getChats(user.id))

        // all with messages
        val chatSequence3 = sequenceOf(
            chatWithMessage,
            chatWithMessage,
        )

        every { chats.getChats(user) } returns chatSequence3
        val expected3 = listOf(chatWithMessage, chatWithMessage).joinToString()
        assertEquals(expected3, facade.getChats(user.id))
    }

    @Test
    fun test_getChats_expected_exception() {
        val wrong = Long.MAX_VALUE

        every { users.getUser(wrong) }.throws(ChatServiceException("User not found!"))
        try {
            facade.getChats(wrong)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun test_getChatsList_expected() {
        val user = ChatUser(0L, "user1")

        // no chats
        val emptyChat = emptySequence<DirectChat>()

        every { users.getUser(user.id) } returns user
        every { chats.getChats(user) } returns emptyChat

        assertEquals(emptyList<Chat>(), facade.getChatsList(user.id))

        // with chats but no messages
        val chatSequence1 = sequenceOf(DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf()))

        every { chats.getChats(user) } returns chatSequence1
        assertEquals(emptyList<Chat>(), facade.getChatsList(user.id))

        // with chats with messages
        val message = ChatMessage(id = 0L, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val chatWithMessage = DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf(message))
        val chatSequence2 = sequenceOf(
            DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf()),
            chatWithMessage)

        every { chats.getChats(user) } returns chatSequence2
        assertEquals(listOf(chatWithMessage), facade.getChatsList(user.id))
    }

    @Test
    fun test_getChatsList_expected_exception() {
        val wrong = Long.MAX_VALUE

        every { users.getUser(wrong) }.throws(ChatServiceException("User not found!"))
        try {
            facade.getChatsList(wrong)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun getMessages() {

        val user = ChatUser(0L, "user1")

        // no messages
        val emptyChat = DirectChat(0L, user.id, 1L, listOf())

        every { users.getUser(user.id) } returns user
        every { chats.getChatByUserAndById(user, emptyChat.id) } returns emptyChat

        assertEquals(emptyList<Message>(), facade.getMessages(user.id, emptyChat.id, 0L, 1))

        // wrong message
        val date = LocalDateTime.now()
        val text = "message"
        val message = ChatMessage(0L, user.id, 1L, date = date, text = text)
        val chat1 = DirectChat(0L, user.id, 1L, listOf(message))

        val wrongId = Long.MAX_VALUE
        every { chats.getChatByUserAndById(user, chat1.id) } returns chat1
        assertEquals(emptyList<Message>(), facade.getMessages(user.id, chat1.id, wrongId, 1))

        // normal messages
        val message1 = ChatMessage(0L, user.id, 1L, date = date, text = text)
        val message2 = ChatMessage(1L, user.id, 1L, date = date, text = text)
        val message3 = ChatMessage(2L, user.id, 1L, date = date, text = text)
        val chat2 = DirectChat(0L, user.id, 1L, listOf(message1, message2, message3))

        val expectedMessage2 = message2.copy(read = true)
        val expectedMessage3 = message3.copy(read = true)
        val expectedList = listOf(expectedMessage2, expectedMessage3)

        every { chats.getChatByUserAndById(user, chat1.id) } returns chat2
        every { messages.readMessage(message1) } returns message1
        every { messages.readMessage(message2) } returns expectedMessage2
        every { messages.readMessage(message3) } returns expectedMessage3
        assertEquals(expectedList, facade.getMessages(user.id, chat1.id, message2.id, 2))
        verify { chats.updateChat(chat2, expectedList) }
    }

    @Test
    fun getMessages_expected_userException() {
        val wrongId = Long.MAX_VALUE
        val chatId = 0L
        val lastMessageId = 0L
        val count = 1

        every { users.getUser(wrongId) }.throws(ChatServiceException("User not found!"))
        try {
            facade.getMessages(wrongId, chatId, lastMessageId, count)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun getMessages_expected_chatException() {
        val user = ChatUser(0L, "user1")
        val wrongId = Long.MAX_VALUE
        val lastMessageId = 0L
        val count = 1

        every { users.getUser(wrongId) } returns user
        every { chats.getChatByUserAndById(user, wrongId) }.throws(ChatServiceException("Chat not found!"))
        try {
            facade.getMessages(user.id, wrongId, lastMessageId, count)
        } catch (e: ChatServiceException) {
            assertEquals("Chat not found!", e.message)
        }
    }

    @Test
    fun test_createMessages_expected_onSuccess() {
        val user1 = ChatUser(0L, "user1")
        val user2 = ChatUser(0L, "user1")
        val date = LocalDateTime.now()
        val text = "message"
        val chat = DirectChat(0L, user1.id, user2.id)
        val message = ChatMessage(0L, user1.id, user2.id, date = date, text = text)

        every { users.getUser(user1.id) } returns user1
        every { users.getUser(user2.id) } returns user2
        every { chats.getChat(user1, user2) } returns chat
        every { messages.createMessage(user1, user2, date, text) } returns message
        every { chats.updateChat(chat, listOf(message)) } returns chat.copy(messages = chat.messages + message)

        assertEquals(message, facade.createMessage(user1.id, user2.id, date, text))
    }

    @Test
    fun test_createMessages_expected_onFailure() {
        val user1 = ChatUser(0L, "user1")
        val user2 = ChatUser(0L, "user1")
        val date = LocalDateTime.now()
        val text = "message"
        val chat = DirectChat(0L, user1.id, user2.id)
        val message = ChatMessage(0L, user1.id, user2.id, date = date, text = text)

        every { users.getUser(user1.id) } returns user1
        every { users.getUser(user2.id) } returns user2
        every { chats.getChat(user1, user2) }.throws(ChatServiceException("Chat not found!"))
        every { messages.createMessage(user1, user2, date, text) } returns message
        every { chats.createChat(user1, user2, message) } returns chat.copy(messages = chat.messages + message)

        assertEquals(message, facade.createMessage(user1.id, user2.id, date, text))
    }

    @Test
    fun test_createMessages_expected_exceptions() {
        val user1 = ChatUser(0L, "user1")
        val user2 = ChatUser(0L, "user1")
        val wrongId = Long.MAX_VALUE
        val date = LocalDateTime.now()
        val text = "message"

        every { users.getUser(wrongId) }.throws(ChatServiceException("User not found!"))
        every { users.getUser(user1.id) } returns user1
        every { users.getUser(user2.id) } returns user2

        try {
            facade.createMessage(wrongId, user2.id, date, text)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
        try {
            facade.createMessage(user1.id, wrongId, date, text)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun test_deleteMessage_expected() {
        val user = ChatUser(0L, "user")
        val messageId = 0L

        // no chats
        val sequence = emptySequence<DirectChat>()

        every { users.getUser(user.id) } returns user
        every { chats.getChats(user) } returns sequence

        assertFalse(facade.deleteMessage(user.id, messageId))

        // empty messages

        val chat = DirectChat(0L, user.id, 1L)
        val sequence1 = sequenceOf(chat)

        every { chats.getChats(user) } returns sequence1

        assertFalse(facade.deleteMessage(user.id, messageId))

        // wrong message id
        val wrongMessage = ChatMessage(id = Long.MAX_VALUE, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val chat2 = DirectChat(0L, user.id, 1L, listOf(wrongMessage))
        val sequence2 = sequenceOf(chat2)

        every { chats.getChats(user) } returns sequence2

        assertFalse(facade.deleteMessage(user.id, messageId))

        // ok but not last message id - deletes only message
        val message1 = ChatMessage(messageId, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val message2 = ChatMessage(1L, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val chat3 = DirectChat(0L, user.id, 1L, listOf(message1, message2))
        val sequence3 = sequenceOf(chat3)

        every { chats.getChats(user) } returns sequence3

        assertTrue(facade.deleteMessage(user.id, messageId))

        verify { chats.updateChat(chat3, listOf(message1, message2) - message1) }

        // ok and last message id - deletes chat
        val message4 = ChatMessage(messageId, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val chat4 = DirectChat(0L, user.id, 1L, listOf(message4))
        val sequence4 = sequenceOf(chat4)

        every { chats.getChats(user) } returns sequence4

        assertTrue(facade.deleteMessage(user.id, messageId))

        verify { chats.deleteChat(chat4) }
    }

    @Test
    fun test_deleteMessage_expected_userException() {
        val wrongId = Long.MAX_VALUE
        val messageId = 0L

        every { users.getUser(wrongId) }.throws(ChatServiceException("User not found!"))
        try {
            facade.deleteMessage(wrongId, messageId)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun test_deleteChat_expected() {
        val user = ChatUser(0L, "user")
        val chat = DirectChat(0L, user.id, 1L)
        val chatId = 0L

        every { users.getUser(user.id) } returns user
        every { chats.getChatByUserAndById(user, chatId) } returns chat
        every { chats.deleteChat(chat) } returns true
        assertTrue(facade.deleteChat(user.id, chatId))

        every { chats.deleteChat(chat) } returns false
        assertFalse(facade.deleteChat(user.id, chatId))
    }

    @Test
    fun test_deleteChat_expected_userException() {
        val wrongId = Long.MAX_VALUE
        val chatId = 0L

        every { users.getUser(wrongId) }.throws(ChatServiceException("User not found!"))
        try {
            facade.deleteChat(wrongId, chatId)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun test_deleteChat_expected_chatException() {
        val user = ChatUser(0L, "user")
        val chatId = 0L

        every { users.getUser(user.id) } returns user
        every { chats.getChatByUserAndById(user, chatId) }.throws(ChatServiceException("Wrong chat id!"))
        try {
            facade.deleteChat(user.id, chatId)
        } catch (e: ChatServiceException) {
            assertEquals("Wrong chat id!", e.message)
        }
    }

    @Test
    fun test_editMessage_expected() {
        val user = ChatUser(0L, "user")
        val chatId = 0L
        val messageId = 0L
        val date = LocalDateTime.now()
        val text = "message"

        val message = ChatMessage(id = messageId, user.id, 1L, date = LocalDateTime.now(), text = "message")
        val chat = DirectChat(id = 0L, senderId = 0L, receiverId = 1L, listOf(message))

        val wrongMessageId = Long.MAX_VALUE

        every { users.getUser(user.id) } returns user
        every { chats.getChatByUserAndById(user, chatId) } returns chat

        assertFalse(facade.editMessage(user.id, chatId, wrongMessageId, date, text))

        assertTrue(facade.editMessage(user.id, chatId, messageId, date, text))
        verify { messages.editMessage(message, date, text) }
    }

    @Test
    fun test_editMessage_expected_userException() {
        val user = ChatUser(0L, "user")
        val chatId = 0L
        val messageId = 0L
        val date = LocalDateTime.now()
        val text = "message"

        every { users.getUser(user.id) }.throws(ChatServiceException("User not found!"))
        try {
            facade.editMessage(user.id, chatId, messageId, date, text)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }

    }

    @Test
    fun test_editMessage_expected_chatException() {
        val user = ChatUser(0L, "user")
        val chatId = 0L
        val messageId = 0L
        val date = LocalDateTime.now()
        val text = "message"

        every { users.getUser(user.id) } returns user
        every { chats.getChatByUserAndById(user, chatId) }.throws(ChatServiceException("Wrong chat id!"))
        try {
            facade.editMessage(user.id, chatId, messageId, date, text)
        } catch (e: ChatServiceException) {
            assertEquals("Wrong chat id!", e.message)
        }
    }
}