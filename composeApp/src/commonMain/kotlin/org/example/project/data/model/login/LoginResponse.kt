package org.example.project.data.model.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val user: UserResponse,
    val token: String
)

@Serializable
data class UserResponse(
    val uuid: String,
    val email: String,
    val number: String,
    val fio: String,
    val role: RoleResponse
)

@Serializable
data class RoleResponse(
    val id: Int,
    val name: String
)