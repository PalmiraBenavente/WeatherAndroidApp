package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.Utils.Converters
import com.example.data.database.entities.WeatherInformationDB

@Database(version = 1, entities = [WeatherInformationDB::class], exportSchema = false)
@TypeConverters(Converters::class)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        fun getInstance(context: Context): WeatherDataBase? {
            if (INSTANCE == null) {
                synchronized(WeatherDataBase::class) {
                    INSTANCE = buildRoomDB(context)
                }
            }
            return INSTANCE
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                WeatherDataBase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()

        private var INSTANCE: WeatherDataBase? = null
        private const val DATABASE_NAME = "weather_tandil_database"
    }
}
