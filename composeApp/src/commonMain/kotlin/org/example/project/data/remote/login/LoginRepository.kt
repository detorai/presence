package org.example.project.data.remote.login

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.local.AuthManager
import org.example.project.data.model.ResponseState
import org.example.project.data.model.login.LoginRequest

class LoginRepository(private val loginImpl: LoginImpl, private val authManager: AuthManager) {
    fun login(loginRequest: LoginRequest): Flow<ResponseState> = flow {
        return@flow try {
            val result = loginImpl.login(loginRequest)
            authManager.setToken(result.token)
            emit(ResponseState.Success(result.user))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.message.toString()))
        }
    }
    fun checkStatus(): Flow<ResponseState> = flow {
        return@flow try {
            val result = authManager.getToken()
            emit (ResponseState.Success(result))
        } catch (e: Exception) {
            emit (ResponseState.Error(e.message.toString()))
        }
    }
    fun logout(): Flow<ResponseState> = flow {
        return@flow try {
            val result = authManager.deleteToken()
            emit(ResponseState.Success(result))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.message.toString()))
        }
    }
}