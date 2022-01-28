package ru.netology.model.report

import org.junit.Assert.assertEquals
import org.junit.Test

class ReportReasonTest {

    @Test
    fun test_reportReasonTest_getValue_expected() {
        val reportReasons = ReportReason.values()
        reportReasons.forEach {
            when (it) {
                ReportReason.SPAM -> assertEquals(0, ReportReason.SPAM.value)
                ReportReason.CHILD_PORNOGRAPHY -> assertEquals(1, ReportReason.CHILD_PORNOGRAPHY.value)
                ReportReason.EXTREMISM -> assertEquals(2, ReportReason.EXTREMISM.value)
                ReportReason.VIOLENCE -> assertEquals(3, ReportReason.VIOLENCE.value)
                ReportReason.DRUG_PROPAGANDA -> assertEquals(4, ReportReason.DRUG_PROPAGANDA.value)
                ReportReason.ADULT_MATERIAL -> assertEquals(5, ReportReason.ADULT_MATERIAL.value)
                ReportReason.INSULT_ABUSE -> assertEquals(6, ReportReason.INSULT_ABUSE.value)
                ReportReason.SUICIDE_PROPAGANDA -> assertEquals(8, ReportReason.SUICIDE_PROPAGANDA.value)
            }
        }
    }
}