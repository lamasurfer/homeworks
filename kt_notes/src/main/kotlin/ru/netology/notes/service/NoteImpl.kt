package ru.netology.notes.service

import ru.netology.notes.exception.NotesException
import ru.netology.notes.model.Note
import ru.netology.notes.repository.Repository
import java.util.concurrent.atomic.AtomicLong

class NoteImpl(
    private val repository: Repository<Note>,
) : CrudService<Note> {

    private val counter = AtomicLong()

    override fun add(entity: Note): Note {
        return repository.save(entity.copy(id = counter.getAndIncrement()))
    }

    override fun read(id: Long): Note {
        return readHidden(id).takeUnless { it.isRemoved } ?: throw NotesException("Note is removed!")
    }

    override fun readHidden(id: Long): Note {
        return repository.findById(id) ?: throw NotesException("Note not found!")
    }

    override fun update(entity: Note): Note {
        return repository.save(entity)
    }

    override fun delete(entity: Note): Note {
        return repository.save(entity.copy(isRemoved = true))
    }

    override fun restore(entity: Note): Note {
        return repository.save(entity.copy(isRemoved = false))
    }

    override fun readAll(ids: List<Long>): Sequence<Note> {
        return repository.findAllByIds(ids).filter { !it.isRemoved }
    }
}