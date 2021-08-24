package com.example.domain.utils

sealed class ServiceResult<out T : Any> {
    class Success<out T : Any>(val data: T) : ServiceResult<T>()
    class Failure(val exception: Exception) : ServiceResult<Nothing>()
}
