package ru.netology.model.report

enum class ReportReason(
    val value: Int,
) {
    // 0
    SPAM(0),

    // 1
    CHILD_PORNOGRAPHY(1),

    // 2
    EXTREMISM(2),

    // 3
    VIOLENCE(3),

    // 4
    DRUG_PROPAGANDA(4),

    // 5
    ADULT_MATERIAL(5),

    // 6
    INSULT_ABUSE(6),

    // 8
    SUICIDE_PROPAGANDA(8),
}