package com.example.wheatherapp.model.forecast

import com.example.wheatherapp.model.current.WeatherData
import com.google.gson.annotations.SerializedName

data class ForecastData(
    @SerializedName("city")
    val city: City,
    val list: ArrayList<WeatherData>
)