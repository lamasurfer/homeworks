package ru.netology.model.post.attachment

import ru.netology.model.post.attachment.video.*

data class Video(
    // id
    val id: Long = 0,
    // owner_id
    val ownerId: Long = 0,
    // title
    val title: String = "",
    // description
    val description: String = "",
    // duration
    val duration: Long = 0,
    // image
    val image: List<VideoImage> = arrayListOf(),
    // first_frame
    val firstFrame: List<VideoImage> = arrayListOf(),
    // date
    val date: Long = 0,
    // adding_date
    val addingDate: Long = 0,
    // views
    val views: Long = 0,
    // local_views
    val localViews: Long = 0,
    // comments
    val comments: Long = 0,
    // player
    val player: String = "",
    // platform
    val platform: String = "",
    // can_add
    val canAdd: Boolean = false,
    // is_private
    val isPrivate: Boolean = false,
    // access_key
    val accessKey: String = "",
    // processing
    val processing: Boolean = false,
    // is_favorite
    val isFavorite: Boolean = false,
    // can_comment
    val canComment: Boolean = false,
    // can_edit
    val canEdit: Boolean = false,
    // can_like
    val canLike: Boolean = false,
    // can_repost
    val canRepost: Boolean = false,
    // can_subscribe
    val canSubscribe: Boolean = false,
    // can_add_to_faves
    val canAddToFaves: Boolean = false,
    // can_attach_link
    val canAttachLink: Boolean = false,
    // width
    val width: Int = 0,
    // height
    val height: Int = 0,
    // user_id*
    val userId: Long = 0,
    // converting
    val converting: Boolean = false,
    // added
    val added: Boolean = false,
    // is_subscribed
    val isSubscribed: Boolean = false,
    // repeat
    val repeat: Boolean = false,
    // type
    val videoType: VideoType = VideoType.VIDEO,
    // balance
    val balance: Long = 0,
    // live_status
    val liveStatus: VideoLiveStatus = VideoLiveStatus.UPCOMING,
    // live
    val live: Boolean = false,
    // upcoming
    val upcoming: Boolean = false,
    // spectators
    val spectators: Long = 0,
    // likes
    val likes: VideoLikes = VideoLikes(),
    // reposts
    val reposts: VideoReposts = VideoReposts(),
) : Attachment(AttachmentType.VIDEO)
