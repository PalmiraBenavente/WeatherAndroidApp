package com.example.weatherandroidapp.di

import com.example.weatherandroidapp.viewmodels.WeatherGridViewModel
import com.example.weatherandroidapp.viewmodels.WeatherWelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { WeatherWelcomeViewModel() }
    viewModel { WeatherGridViewModel(get()) }
}
