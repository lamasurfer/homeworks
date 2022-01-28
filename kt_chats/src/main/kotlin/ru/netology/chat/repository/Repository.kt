package ru.netology.chat.repository

interface Repository<T, ID> {

    fun count(): Long

    fun save(entity: T): T

    fun findById(id: ID): T?

    fun delete(entity: T): Boolean

    fun deleteById(id: ID): T?

    fun findAll(): Sequence<T>

    fun findAllByIds(ids: List<ID>): Sequence<T>

    fun existsById(id: ID): Boolean

    fun deleteAll()
}