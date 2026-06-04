package com.example.domain.exception

sealed class HandledException(exceptionMessage : String) : Exception(exceptionMessage) {

    class NetworkError(message: String = "Network Error") : HandledException(message)

    class UnknownError(message: String = "Unknown Error") : HandledException(message)
}