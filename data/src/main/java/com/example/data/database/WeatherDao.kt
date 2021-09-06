package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entities.WeatherInformationDB
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherInformation(responseWeatherInfoDB: WeatherInformationDB)

    @Query("SELECT * FROM WeatherInformationDB LIMIT 1")
    fun getWeather(): Flow<WeatherInformationDB>
}
