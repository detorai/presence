package org.example.project.data.remote.login

import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.POST
import org.example.project.data.model.login.LoginResponse
import org.example.project.data.model.login.LoginRequest

interface LoginInterface {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}