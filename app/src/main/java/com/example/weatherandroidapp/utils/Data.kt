package com.example.weatherandroidapp.utils

data class Data<ResponseWeather>(
    var status: Status,
    var data: ResponseWeather? = null,
    var error: Exception? = null,
)

enum class Status {
    UPLOADED_DATA, ERROR
}
