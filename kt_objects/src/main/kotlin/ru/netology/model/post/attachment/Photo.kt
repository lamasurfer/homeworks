package ru.netology.model.post.attachment

import ru.netology.model.post.attachment.photo.PhotoSizes

data class Photo(
    // id
    val id: Long = 0L,
    // album_id
    val albumId: Long = 0L,
    // owner_id
    val ownerId: Long = 0L,
    // user_id
    val userId: Long = 0L,
    // text
    val text: String = "",
    // date
    val date: Long = 0L,
    // sizes
    val sizes: List<PhotoSizes> = arrayListOf(),
    // width*
    val width: Long = 0L,
    // height*
    val height: Long = 0L,
) : Attachment(AttachmentType.PHOTO)
