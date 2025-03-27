package org.example.project.data.model.group

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import org.example.project.data.model.login.UserResponse

@Serializable
data class GroupResponse(
    val group: List<StudentDto>
)

@Serializable
data class StudentDto(
    val studentId: Int,
    val uuid: String,
    val email: String,
    val number: String,
    val fio: String,
    val enrollDate: LocalDate,
    val expulsionDate: LocalDate? = null,
)