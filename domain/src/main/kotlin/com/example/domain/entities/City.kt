package com.example.domain.entities

import com.example.domain.utils.COUNTRY
import com.example.domain.utils.DEFAULT_ID
import com.example.domain.utils.NAME
import com.example.domain.utils.ZERO

data class City(
    val id: Int = DEFAULT_ID,
    val name: String = NAME,
    val coord: Coordinates? = Coordinates(),
    val country: String = COUNTRY,
    val population: Int = ZERO,
    val timezone: Int = ZERO,
    val sunrise: Int = ZERO,
    val sunset: Int = ZERO
)
