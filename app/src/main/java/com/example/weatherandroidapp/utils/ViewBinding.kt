package com.example.weatherandroidapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:items")
fun <T> RecyclerView.setItems(items: List<T>?) {
    items?.let {
        (this.adapter as? ListAdapter<T, *>)?.submitList(items)
    }
}
