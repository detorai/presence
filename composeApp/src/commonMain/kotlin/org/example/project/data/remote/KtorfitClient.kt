package org.example.project.data.remote

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.data.remote.login.LoginInterface

object KtorfitClient {
    val ktorClient = HttpClient() {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true;
                    ignoreUnknownKeys = true
                }
            )
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }
    val client = Ktorfit.Builder()
        .baseUrl("http://192.168.3.217:8080/")
        .httpClient(ktorClient)
        .build()
    val loginInstance: LoginInterface = client.create()
}