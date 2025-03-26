package org.example.project.data.remote.schedule

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import org.example.project.data.model.schedule.ScheduleResponse

interface ScheduleInterface {
    @GET("api/v1/group/{id}/schedule")
    suspend fun getSchedule(@Path id: Int): ScheduleResponse
}