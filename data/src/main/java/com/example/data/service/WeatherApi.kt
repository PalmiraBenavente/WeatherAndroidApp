package com.example.data.service

import com.example.data.service.responses.ResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast?")
    fun callWeatherInfo(
        @Query("q") city: String,
        @Query("appid") apiId: String,
        @Query("units") units: String
    ): Call<ResponseApi>
}
