package com.example.weatherandroidapp.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.domain.entities.ResponseWeatherInfo
import com.example.weatherandroidapp.R
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveDataWeatherInfo().observe(viewLifecycleOwner, Observer { updateUINotification(it) })
    }

    private fun updateUINotification(it: ResponseWeatherInfo?) {
            Toast.makeText(context, getString(R.string.toast_show_ok_service, it?.list?.first()?.mainResponse?.temperature.toString()), Toast.LENGTH_SHORT).show()
    }
}
