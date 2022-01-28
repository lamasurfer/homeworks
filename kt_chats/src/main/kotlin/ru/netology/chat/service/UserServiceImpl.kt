package ru.netology.chat.service

import ru.netology.chat.exception.ChatServiceException
import ru.netology.chat.model.ChatUser
import ru.netology.chat.repository.MapRepoImpl
import java.util.concurrent.atomic.AtomicLong

class UserServiceImpl(
    private val repository: MapRepoImpl<ChatUser>,
) : UserService {

    private val counter = AtomicLong()

    override fun addUser(nickname: String): ChatUser {
        return repository.save(
            ChatUser(
                id = counter.getAndIncrement(),
                nickname = nickname
            )
        )
    }

    override fun getUser(userId: Long): ChatUser {
        return repository.findById(userId) ?: throw ChatServiceException("User not found!")
    }

    override fun updateUser(user: ChatUser): ChatUser {
        return repository.save(user)
    }

    override fun deleteUser(user: ChatUser): Boolean {
        return repository.delete(user)
    }
}