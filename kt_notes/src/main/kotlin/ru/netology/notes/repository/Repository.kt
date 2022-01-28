package ru.netology.notes.repository

interface Repository<T> {

    fun count(): Long

    fun save(entity: T): T

    fun findById(id: Long): T?

    fun delete(entity: T): Boolean

    fun deleteById(id: Long): T?

    fun findAll(): Sequence<T>

    fun findAllByIds(ids: List<Long>): Sequence<T>

    fun existsById(id: Long): Boolean

    fun deleteAll()
}