package org.example.project.data.local

class AuthManager(private val tokenStorage: TokenStorageInterface) {
    suspend fun login(token: String) {
        tokenStorage.setToken(token)
    }
    suspend fun logout() {
        tokenStorage.deleteToken()
    }
    suspend fun isLoggedIn(): Boolean {
        return tokenStorage.getToken() != null
    }
}