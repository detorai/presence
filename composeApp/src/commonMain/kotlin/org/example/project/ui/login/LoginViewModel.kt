package org.example.project.ui.login

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.model.LoginRequest
import org.example.project.data.model.ResponseState
import org.example.project.data.remote.login.LoginImpl
import org.example.project.data.remote.login.LoginRepository

class LoginViewModel(private val loginImpl: LoginImpl): ScreenModel {
    val state = MutableStateFlow(LoginScreenState())
    val repository = LoginRepository(loginImpl)

    fun resetError(){
        state.update{
            it.copy(
                error = null
            )
        }
    }
    fun onLogin(login: String){
        state.update {
            it.copy(
                login = login
            )
        }
    }
    fun onPassword(password: String){
        state.update {
            it.copy(
                password = password
            )
        }
    }
    fun onCheck(){
        state.update {
            it.copy(
                check = !it.check
            )
        }
    }

    fun login(login: String, password: String) {
        val loginRequest = LoginRequest(login, password)
        screenModelScope.launch {
            val result = repository.login(loginRequest)
            result.collect{response ->
                when (response) {
                    is ResponseState.Success<*> -> {
                        state.update {
                            it.copy(
                                success = true,
                                error = response.data.toString()
                            )
                        }
                    }
                    is ResponseState.Error -> {
                        state.update {
                            it.copy(
                                error = response.error
                            )
                        }
                    }
            }
            }
        }
    }
}