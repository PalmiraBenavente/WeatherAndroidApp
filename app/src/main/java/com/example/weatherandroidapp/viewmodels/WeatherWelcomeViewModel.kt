package com.example.weatherandroidapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherandroidapp.contracts.MainContract
import com.example.weatherandroidapp.utils.Event
import com.example.weatherandroidapp.utils.NavigationEvent

class WeatherWelcomeViewModel : ViewModel(), MainContract.ViewModel {

    val mutableLiveDataToDetails: MutableLiveData<Event<NavigationEvent>> = MutableLiveData()

    override fun buttonOkPressed() {
        mutableLiveDataToDetails.value = Event(NavigationEvent.NAVIGATE_TO_WEATHER_DETAILS)
    }
}
