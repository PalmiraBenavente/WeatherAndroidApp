package com.example.weatherandroidapp.views

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
import com.example.weatherandroidapp.utils.Data
import com.example.weatherandroidapp.utils.Event
import com.example.weatherandroidapp.utils.Status
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
        viewModel.getGridStateLiveData().observe(viewLifecycleOwner, Observer { updateUI(it) })
        viewModel.getWeatherInfo()
    }

    private fun updateUI(data: Event<Data<ResponseWeatherInfo>>) {
        with(data.peekContent()) {
            when (data.peekContent().status) {
                Status.UPLOADED_DATA -> {
                        Toast.makeText(context, getString(R.string.toast_show_ok_service,
                            this.data?.city?.name,
                            this.data?.list?.get(0)?.mainResponse?.temperature.toString()),
                            Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                        Toast.makeText(context, this.error.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
