package org.example.project.di

import org.example.project.data.remote.KtorfitClient
import org.example.project.data.remote.login.LoginImpl
import org.example.project.data.remote.login.LoginInterface
import org.example.project.data.remote.login.LoginRepository
import org.example.project.data.remote.schedule.ScheduleImpl
import org.example.project.data.remote.schedule.ScheduleInterface
import org.example.project.data.remote.schedule.ScheduleRepository
import org.example.project.ui.login.LoginViewModel
import org.example.project.ui.schedule.ScheduleViewModel
import org.koin.dsl.module

val appModule = module {
    single<LoginInterface> { KtorfitClient.loginInstance }
    single { LoginImpl(get()) }
    single { LoginRepository(get(), get()) }
    factory { LoginViewModel(get()) }

    single<ScheduleInterface> { KtorfitClient.scheduleInstance }
    single { ScheduleImpl(get()) }
    single { ScheduleRepository(get()) }
    factory { ScheduleViewModel(get()) }
}