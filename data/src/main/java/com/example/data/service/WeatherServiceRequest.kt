package com.example.data.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class WeatherServiceRequest {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))

    fun <S> createService(serviceClass: Class<S>): S = builder.client(httpClient).build().create(serviceClass)

    companion object {
        private const val BASE_URL: String = "https://api.openweathermap.org/data/2.5/"
    }
}
