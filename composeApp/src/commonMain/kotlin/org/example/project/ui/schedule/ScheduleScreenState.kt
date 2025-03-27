package org.example.project.ui.schedule

import org.example.project.data.model.schedule.ScheduleResponse
import org.example.project.domain.models.DaysOfWeek
import org.example.project.domain.models.MonthWithWeek
import org.example.project.domain.models.Schedule

data class ScheduleScreenState(
    var error: String? = null,
    var success: Boolean = false,
    var data: MonthWithWeek,
    var schedule: List<Schedule> = emptyList()
)
