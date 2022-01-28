package ru.netology.model.post

import ru.netology.model.post.attachment.Attachment
import ru.netology.model.post.donut.Donut
import ru.netology.model.post.geo.Geo
import ru.netology.model.post.source.PostSource

data class Post(
    // id
    val id: Long = 0L,
    // owner_id
    val ownerId: Long = 0L,
    // from_id
    val fromId: Long = 0L,
    // created_by
    val createdBy: Long = 0L,
    // date
    val date: Long = 0L,
    // text
    val text: String = "",
    // reply_owner_id
    val replyOwnerId: Long? = null,
    // reply_post_id
    val replyPostId: Long? = null,
    // friends_only
    val friendsOnly: Boolean = false,
    // comments
    val comments: Comments = Comments(),
    // copyright
    val copyright: Copyright? = null,
    // likes
    val likes: Likes = Likes(),
    // reposts
    val reposts: Reposts = Reposts(),
    // views
    val views: Views = Views(),
    // post_type
    val postType: PostType = PostType.POST,
    // signer_id
    val signerId: Long = 0L,
    // can_pin
    val canPin: Boolean = false,
    // can_delete
    val canDelete: Boolean = false,
    // can_edit
    val canEdit: Boolean = false,
    // is_pinned
    val isPinned: Boolean = false,
    // marked_as_ads
    val markedAsAds: Boolean = false,
    // is_favorite
    val isFavorite: Boolean = false,
    // donut
    val donut: Donut = Donut(),
    // postponed_id
    val postponedId: Long = 0L,
    // geo
    val geo: Geo? = null,
    // post_source
    val postSource: PostSource = PostSource(),
    // copy_history
    val copyHistory: List<Post> = arrayListOf(),
    // attachments
    val attachments: List<Attachment> = arrayListOf(),
)


