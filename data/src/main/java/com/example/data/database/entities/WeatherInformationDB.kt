package com.example.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.Utils.ConstantUtils

@Entity
data class WeatherInformationDB(
    @PrimaryKey@ColumnInfo(name = "cod") val cod: String = ConstantUtils.DEFAULT_STRING,
    @ColumnInfo(name = "message") val message: Int? = ConstantUtils.DEFAULT_INT,
    @ColumnInfo(name = "cnt") val cnt: Int? = ConstantUtils.DEFAULT_INT,
    @ColumnInfo(name = "list") val listWeather: List<ListDB>? = emptyList(),
)
