package ru.netology.notes.service

interface CrudService<T> {

    fun add(entity: T): T
    fun read(id: Long): T
    fun readHidden(id: Long): T
    fun update(entity: T): T
    fun delete(entity: T): T
    fun restore(entity: T): T
    fun readAll(ids: List<Long>): Sequence<T>
}