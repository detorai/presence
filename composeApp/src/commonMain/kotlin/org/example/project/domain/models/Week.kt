package org.example.project.domain.models

import kotlinx.datetime.LocalDate

data class Week(
    val startDate: LocalDate,
    val endDate: LocalDate
)

data class GroupMonth(
    val monthYear: String,
    val weeks: List<Week>
)
