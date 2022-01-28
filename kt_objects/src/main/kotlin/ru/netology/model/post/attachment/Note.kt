package ru.netology.model.post.attachment

data class Note(
    // id
    val id: Long = 0L,
    // owner_id
    val ownerId: Long = 0L,
    // title
    val title: String = "",
    // text
    val text: String = "",
    // date
    val date: Long = 0L,
    // comments
    val comments: Long = 0L,
    // read_comments
    val readComments: Long = 0L,
    // view_url
    val viewUrl: String = "",
    // privacy_view
    val privacyView: List<String> = arrayListOf(),
    // privacy_comment
    val privacyComment: List<String> = arrayListOf(),
    // can_comment
    val canComment: Boolean = false,
    // text_wiki
    val textWiki: String = "",
) : Attachment(AttachmentType.NOTE)
