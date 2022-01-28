package ru.netology.service

import org.junit.Assert.*
import org.junit.Test
import ru.netology.exception.CommentNotFoundException
import ru.netology.exception.InvalidReportReasonException
import ru.netology.exception.PostNotFoundException
import ru.netology.model.comment.Comment
import ru.netology.model.post.Post

internal class WallServiceTest {

    @Test
    fun test_add_addsAndReturnsPostWithIncrementedId() {
        val service = WallService()

        val addedPost1 = service.add(Post())
        val addedPost2 = service.add(Post())
        val addedPost3 = service.add(Post())

        assertEquals(1, addedPost1.id)
        assertEquals(2, addedPost2.id)
        assertEquals(3, addedPost3.id)
    }

    @Test
    fun test_update_returnsTrueIfPostExists() {
        val service = WallService()

        service.add(Post())
        service.add(Post())
        service.add(Post())
        val addedPost = service.add(Post())

        assertTrue(service.update(addedPost))
    }

    @Test
    fun test_update_returnsFalseIfPostDoesNotExist() {
        val service = WallService()

        service.add(Post())
        service.add(Post())
        service.add(Post())

        val notAddedPost = Post()
        assertFalse(service.update(notAddedPost))
    }

    @Test
    fun test_createComment_throwsNoExceptions() {
        val service = WallService()

        val post = service.add(Post())
        val comment = Comment(postId = post.id)

        service.createComment(comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun test_createComment_throwsExceptionIfPostNotFound() {
        val service = WallService()

        service.add(Post())
        val wrongPostId = -1L
        val comment = Comment(postId = wrongPostId)

        service.createComment(comment)
    }

    @Test
    fun test_reportComment_throwsNoExceptions() {
        val service = WallService()

        val post = service.add(Post())
        val commentId = 1L
        val fromId = 5L
        val comment = Comment(postId = post.id, fromId = fromId, id = commentId)

        service.createComment(comment)

        service.reportComment(fromId, commentId, 0)
    }

    @Test(expected = InvalidReportReasonException::class)
    fun test_reportComment_throwsExceptionIfReasonIsWrong() {
        val service = WallService()

        service.reportComment(0L, 0L, -1)
    }

    @Test(expected = CommentNotFoundException::class)
    fun test_reportComment_throwsExceptionIfCommentOwnerIsWrong() {
        val service = WallService()

        val post = service.add(Post())
        val commentId = 1L
        val fromId = 5L
        val comment = Comment(postId = post.id, fromId = fromId, id = commentId)

        service.createComment(comment)

        val wrongFromId = 0L
        service.reportComment(wrongFromId, commentId, 0)
    }

    @Test(expected = CommentNotFoundException::class)
    fun test_reportComment_throwsExceptionIfCommentIdIsWrong() {
        val service = WallService()

        val post = service.add(Post())
        val commentId = 1L
        val fromId = 5L
        val comment = Comment(postId = post.id, fromId = fromId, id = commentId)

        service.createComment(comment)

        val wrongCommentId = 0L
        service.reportComment(fromId, wrongCommentId, 0)
    }
}