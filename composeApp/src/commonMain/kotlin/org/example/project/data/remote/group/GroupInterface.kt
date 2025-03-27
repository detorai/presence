package org.example.project.data.remote.group

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import org.example.project.data.model.group.GroupResponse
import org.example.project.data.model.schedule.ScheduleResponse

interface GroupInterface {
    @GET("api/v1/group/{id}/students")
    suspend fun getGroupStudents(@Path id: Int): GroupResponse
}