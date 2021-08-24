package com.example.weatherandroidapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherandroidapp.contracts.MainContract
import com.example.weatherandroidapp.utils.Event
import com.example.weatherandroidapp.utils.NavigationEvent

class WeatherWelcomeViewModel : ViewModel(), MainContract.ViewModel {

    private val mutableLiveDataToDetails: MutableLiveData<Event<NavigationEvent>> by lazy { MutableLiveData() }

    fun getLiveDataToDetails() = this.mutableLiveDataToDetails

    override fun buttonOkPressed() {
        mutableLiveDataToDetails.value = Event(NavigationEvent.NAVIGATE_TO_WEATHER_DETAILS)
    }
}
