package com.example.weatherandroidapp.utils

import android.app.Application
import com.example.weatherandroidapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)
            androidLogger(Level.DEBUG)
            modules(listOf(viewModelsModule))
        }
    }
}
