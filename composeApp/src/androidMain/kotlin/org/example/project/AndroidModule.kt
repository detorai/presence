package org.example.project

import org.example.project.data.local.AuthManager
import org.example.project.data.local.TokenStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    single<TokenStorage> { AndroidTokenStorage(androidContext()) }
    single { AuthManager(get()) }
}