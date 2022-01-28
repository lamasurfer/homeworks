package ru.netology.exception

import org.junit.Assert.assertEquals
import org.junit.Test

class InvalidReportReasonExceptionTest {

    @Test
    fun test_invalidReportReasonException_defaults() {
        val e = InvalidReportReasonException()
        assertEquals("Report reason is invalid!", e.message)
    }
}