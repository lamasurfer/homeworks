package ru.netology.model.post.attachment

import ru.netology.model.post.attachment.link.Button
import ru.netology.model.post.attachment.link.LinkProduct

data class Link(
    // url
    val url: String = "",
    // title
    val title: String = "",
    // caption*
    val caption: String = "",
    // description
    val description: String = "",
    // photo*
    val photo: Photo = Photo(),
    // product*
    val linkProduct: LinkProduct = LinkProduct(),
    // button*
    val button: Button = Button(),
    // preview_url
    val previewUrl: String = "",
) : Attachment(AttachmentType.LINK)
