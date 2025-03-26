package org.example.project.data.remote.schedule

import org.example.project.data.model.schedule.ScheduleResponse

class ScheduleImpl(private val scheduleInterface: ScheduleInterface) {
    suspend fun getSchedule(group_id: Int): ScheduleResponse = scheduleInterface.getSchedule(group_id)
}