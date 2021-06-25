package com.example.wheatherapp.model.current

import com.google.gson.annotations.SerializedName

data class WeatherData(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    @SerializedName("visibility")
    val visibility: Int
)