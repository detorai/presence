package org.example.project.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleResponse(
    val id: Int,
    val lessonNumber: Int,
    val audience: String,
    val subject: SubjectResponse,
    val dayOfWeek: Int
)
@Serializable
data class
SubjectResponse(
    val id: Int,
    val name: String
)