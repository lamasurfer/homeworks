package ru.netology.chat.repository

import ru.netology.chat.model.BaseEntity
import java.util.concurrent.ConcurrentHashMap

class MapRepoImpl<T : BaseEntity> : Repository<T, Long> {

    private val storage = ConcurrentHashMap<Long, T>()

    override fun count(): Long = storage.values.size.toLong()

    override fun save(entity: T): T {
        storage[entity.id] = entity
        return entity
    }

    override fun findById(id: Long): T? = storage[id]

    override fun delete(entity: T) = storage.remove(entity.id, entity)

    override fun deleteById(id: Long): T? = storage.remove(id)

    override fun findAll(): Sequence<T> = storage.values.asSequence()

    override fun findAllByIds(ids: List<Long>): Sequence<T> = ids.mapNotNull { storage[it] }.asSequence()

    override fun existsById(id: Long): Boolean = storage.containsKey(id)

    override fun deleteAll() = storage.clear()
}