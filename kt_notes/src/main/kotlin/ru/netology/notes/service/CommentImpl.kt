package ru.netology.notes.service

import ru.netology.notes.exception.NotesException
import ru.netology.notes.model.Comment
import ru.netology.notes.repository.Repository
import java.util.concurrent.atomic.AtomicLong

class CommentImpl(
    private val repository: Repository<Comment>,
) : CrudService<Comment> {

    private val counter = AtomicLong()

    override fun add(entity: Comment): Comment {
        return repository.save(entity.copy(id = counter.getAndIncrement()))
    }

    override fun read(id: Long): Comment {
        return readHidden(id).takeUnless { it.isRemoved } ?: throw NotesException("Comment is removed!")
    }

    override fun readHidden(id: Long): Comment {
        return repository.findById(id) ?: throw NotesException("Comment not found!")
    }

    override fun update(entity: Comment): Comment {
        return repository.save(entity)
    }

    override fun delete(entity: Comment): Comment {
        return repository.save(entity.copy(isRemoved = true))
    }

    override fun restore(entity: Comment): Comment {
        return repository.save(entity.copy(isRemoved = false))
    }

    override fun readAll(ids: List<Long>): Sequence<Comment> {
        return repository.findAllByIds(ids).filter { !it.isRemoved }
    }
}