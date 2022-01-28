package ru.netology.model.report

import org.junit.Assert.assertEquals
import org.junit.Test

class CommentReportTest {

    @Test
    fun test_commentReport_defaults() {
        val report = CommentReport()
        assertEquals(0L, report.ownerId)
        assertEquals(0L, report.commentId)
        assertEquals(ReportReason.SPAM, report.reason)
    }
}