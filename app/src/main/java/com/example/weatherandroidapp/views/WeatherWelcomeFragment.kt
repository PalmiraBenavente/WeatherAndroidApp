package com.example.weatherandroidapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.weatherandroidapp.databinding.FragmentWeatherWelcomeBinding
import com.example.weatherandroidapp.utils.Event
import com.example.weatherandroidapp.utils.NavigationEvent
import com.example.weatherandroidapp.viewmodels.WeatherWelcomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherWelcomeFragment : Fragment() {

    private val viewModel by viewModel<WeatherWelcomeViewModel>()
    private lateinit var binding: FragmentWeatherWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherWelcomeBinding.inflate(layoutInflater)
        viewModel.mutableLiveDataToDetails.observe(
            this.viewLifecycleOwner,
            Observer { updateUI(it) })
        binding.buttonMainSelectWeather.setOnClickListener { viewModel.buttonOkPressed() }
        return binding.root
    }

    private fun updateUI(navigationEvent: Event<NavigationEvent>?) {
        when (navigationEvent?.getContentIfNotHandled()) {
            NavigationEvent.NAVIGATE_TO_WEATHER_DETAILS -> {
                view?.findNavController()?.navigate(WeatherWelcomeFragmentDirections.actionWeatherMainFragmentToWeatherDetailsFragment())
            }
        }
    }
}
