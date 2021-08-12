package com.example.weatherandroidapp.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding = WeatherGridFragmentBinding.inflate(layoutInflater)
        // TODO("implement view model")
        return binding.root
    }
}
