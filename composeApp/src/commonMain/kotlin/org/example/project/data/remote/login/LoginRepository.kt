package org.example.project.data.remote.login

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.model.LoginRequest
import org.example.project.data.model.ResponseState

class LoginRepository(private val loginImpl: LoginImpl) {
    fun login(loginRequest: LoginRequest): Flow<ResponseState> = flow {
        return@flow try {
            val result = loginImpl.login(loginRequest)
            emit(ResponseState.Success(result.token))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.message.toString()))
        }
    }
}