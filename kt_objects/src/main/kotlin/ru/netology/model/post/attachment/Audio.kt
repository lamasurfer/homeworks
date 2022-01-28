package ru.netology.model.post.attachment

data class Audio(
    // id
    val id: Long = 0L,
    // owner_id
    val ownerId: Long = 0L,
    // artist
    val artist: String = "",
    // title
    val title: String = "",
    // duration
    val duration: Long = 0L,
    // url
    val url: String = "",
    // lyrics_id*
    val lyricsId: Long = 0L,
    // album_id*
    val albumId: Long = 0L,
    // genre_id
    val genreId: Long = 0L,
    // date
    val date: Long = 0L,
    // no_search
    val noSearch: Boolean = false,
    // is_hq
    val isHq: Boolean = false,
) : Attachment(AttachmentType.AUDIO)