package org.example.project.data.remote.schedule

import org.example.project.data.model.schedule.ScheduleResponse

class ScheduleImpl(private val scheduleInterface: ScheduleInterface) {
    suspend fun getSchedule(groupId: Int): ScheduleResponse = scheduleInterface.getSchedule(groupId)
}