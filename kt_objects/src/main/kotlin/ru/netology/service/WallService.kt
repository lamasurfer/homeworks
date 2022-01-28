package ru.netology.service

import ru.netology.exception.CommentNotFoundException
import ru.netology.exception.InvalidReportReasonException
import ru.netology.exception.PostNotFoundException
import ru.netology.model.comment.Comment
import ru.netology.model.post.Post
import ru.netology.model.report.CommentReport
import ru.netology.model.report.ReportReason
import java.util.concurrent.atomic.AtomicLong

class WallService {
    private var posts = emptyArray<Post>()
    private val counter = AtomicLong()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<CommentReport>()

    fun add(post: Post): Post {
        posts += post.copy(id = counter.incrementAndGet())
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        return if (index == -1) {
            false
        } else {
            posts[index] = post.copy(ownerId = post.ownerId, date = post.date)
            true
        }
    }

    fun createComment(comment: Comment) {
        posts.asSequence().find { it.id == comment.postId } ?: throw PostNotFoundException()
        comments += comment
    }

    fun reportComment(ownerId: Long, commentId: Long, reason: Int) {
        val reportReason = ReportReason.values().find { it.value == reason } ?: throw InvalidReportReasonException()
        comments.asSequence().find { it.fromId == ownerId && it.id == commentId } ?: throw CommentNotFoundException()
        reports += CommentReport(ownerId, commentId, reportReason)
    }
}