package org.example.project.data.model

sealed class ResponseState{
    class Error(val error: String): ResponseState()
    class Success<T>(val data: T): ResponseState()
}
