package org.example.project.data.remote.login

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.local.TokenStorageInterface
import org.example.project.data.model.login.LoginRequest
import org.example.project.data.model.ResponseState

class LoginRepository(private val loginImpl: LoginImpl, private val tokenStorageInterface: TokenStorageInterface) {
    fun login(loginRequest: LoginRequest): Flow<ResponseState> = flow {
        return@flow try {
            val result = loginImpl.login(loginRequest)
            tokenStorageInterface.setToken(result.token)
            emit(ResponseState.Success(result.user))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.message.toString()))
        }
    }
}