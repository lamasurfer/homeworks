package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.model.post.attachment.Attachment
import ru.netology.model.post.donut.Donut
import ru.netology.model.post.source.PostSource

class PostTest {

    @Test
    fun test_post_defaults() {
        val post = Post()
        assertEquals(0L, post.id)
        assertEquals(0L, post.ownerId)
        assertEquals(0L, post.fromId)
        assertEquals(0L, post.createdBy)
        assertEquals(0L, post.date)
        assertEquals("", post.text)
        assertEquals(null, post.replyOwnerId)
        assertEquals(null, post.replyPostId)
        assertEquals(false, post.friendsOnly)
        assertEquals(Comments(), post.comments)
        assertEquals(null, post.copyright)
        assertEquals(Likes(), post.likes)
        assertEquals(Reposts(), post.reposts)
        assertEquals(Views(), post.views)
        assertEquals(PostType.POST, post.postType)
        assertEquals(0L, post.signerId)
        assertEquals(false, post.canPin)
        assertEquals(false, post.canDelete)
        assertEquals(false, post.canEdit)
        assertEquals(false, post.isPinned)
        assertEquals(false, post.markedAsAds)
        assertEquals(false, post.isFavorite)
        assertEquals(Donut(), post.donut)
        assertEquals(0L, post.postponedId)
        assertEquals(null, post.geo)
        assertEquals(PostSource(), post.postSource)
        assertEquals(arrayListOf<Post>(), post.copyHistory)
        assertEquals(arrayListOf<Attachment>(), post.attachments)
    }
}