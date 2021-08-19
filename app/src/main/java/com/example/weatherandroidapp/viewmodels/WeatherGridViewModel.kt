package com.example.weatherandroidapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.usecase.UseCaseInterfaceGetCity
import com.example.domain.utils.ServiceResult
import com.example.weatherandroidapp.contracts.WeatherGridContract
import com.example.weatherandroidapp.utils.Data
import com.example.weatherandroidapp.utils.Event
import com.example.weatherandroidapp.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherGridViewModel(
    private val useCaseWeatherCity: UseCaseInterfaceGetCity
) : ViewModel(), WeatherGridContract.ViewModel {
    private val mutableGridState: MutableLiveData<Event<Data<ResponseWeatherInfo>>> by lazy { MutableLiveData() }

    fun getGridStateLiveData() = this.mutableGridState

    override fun getWeatherInfo() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) { useCaseWeatherCity.invoke() }.let {
                when (it) {
                    is ServiceResult.Success -> { mutableGridState.postValue(Event(Data(status = Status.UPLOADED_DATA, data = it.data))) }
                    is ServiceResult.Failure -> { mutableGridState.postValue(Event(Data(status = Status.ERROR, error = it.exception))) }
                }
            }
        }
    }
}
