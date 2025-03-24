package org.example.project.data.remote.login

import org.example.project.data.model.login.LoginResponse
import org.example.project.data.model.login.LoginRequest

class LoginImpl(private val loginInterface: LoginInterface) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse = loginInterface.login(loginRequest)
}