package org.example.project.di

import org.example.project.data.local.AuthManager
import org.example.project.data.local.TokenStorageInterface
import org.example.project.data.remote.KtorfitClient
import org.example.project.data.remote.login.LoginImpl
import org.example.project.data.remote.login.LoginInterface
import org.example.project.data.remote.login.LoginRepository
import org.example.project.ui.login.LoginViewModel
import org.example.project.ui.schedule.ScheduleViewModel
import org.koin.dsl.module

val appModule = module {
    single<TokenStorageInterface> { error("TokenStorage must be overridden in platform modules") }
    single<LoginInterface> { KtorfitClient.loginInstance }
    single { LoginImpl(get()) }
    single { AuthManager(get()) }
    single { LoginRepository(get(), get()) }
    factory { LoginViewModel(get(), get()) }
    factory { ScheduleViewModel() }

}