package com.example.weatherandroidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.ListWeather
import com.example.weatherandroidapp.databinding.ItemWeatherInformationBinding

class WeatherAdapter : ListAdapter<ListWeather, ViewHolderWeather>(DiffCallback()) {

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderWeather.from(parent)

    @Override
    override fun onBindViewHolder(holder: ViewHolderWeather, position: Int) {
        holder.bind(getItem(position))
    }
}

class ViewHolderWeather(private val binding: ItemWeatherInformationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(listWeather: ListWeather) {
        binding.itemListWeather = listWeather
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolderWeather {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemWeatherInformationBinding.inflate(layoutInflater, parent, false)
            return ViewHolderWeather(binding)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<ListWeather>() {
    override fun areItemsTheSame(
        oldItem: ListWeather,
        newItem: ListWeather
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ListWeather,
        newItem: ListWeather
    ): Boolean {
        return oldItem.dtTxt == newItem.dtTxt
    }
}
