package com.example.weatherandroidapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherandroidapp.WeatherAdapter
import com.example.weatherandroidapp.databinding.WeatherGridFragmentBinding
import com.example.weatherandroidapp.viewmodels.WeatherGridViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherGridFragment : Fragment() {

    private val viewModel by viewModel<WeatherGridViewModel>()
    private lateinit var binding: WeatherGridFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WeatherGridFragmentBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWeather()
        binding.recyclerViewFragment.adapter = WeatherAdapter()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.weatherInfoLiveData.observe(::getLifecycle) { weatherInformation ->
            viewModel.updateWeatherList(weatherInformation)
        }
    }
}
