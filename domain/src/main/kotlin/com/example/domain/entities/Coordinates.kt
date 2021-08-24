package com.example.domain.entities

import com.example.domain.utils.DEFAULT_COORD

data class Coordinates(
    val lat: Double = DEFAULT_COORD,
    val lon: Double = DEFAULT_COORD
)
