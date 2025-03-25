package org.example.project.data.local

interface TokenStorageInterface {
    suspend fun getToken(): String?
    suspend fun setToken(token: String)
    suspend fun deleteToken()
}