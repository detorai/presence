package org.example.project.domain.models

import kotlinx.serialization.Serializable

data class Schedule(
    val id: Int,
    val lessonNumber: Int,
    val audience: String,
    val subject: Subject,
    val dayOfWeek: Int,
)
data class Subject(
    val id: Int,
    val name: String
)