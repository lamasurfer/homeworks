package ru.netology.model.post.attachment.photo

data class PhotoSizes(
    // type
    val type: PhotoSizeType = PhotoSizeType.O,
    // url
    val url: String = "",
    // width
    val width: Long = 0L,
    // height
    val height: Long = 0L,
)
