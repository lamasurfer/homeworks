package ru.netology.model.report

data class CommentReport(
    // owner_id
    val ownerId: Long = 0,
    // comment_id
    val commentId: Long = 0,
    // reason
    val reason: ReportReason = ReportReason.SPAM,
)
