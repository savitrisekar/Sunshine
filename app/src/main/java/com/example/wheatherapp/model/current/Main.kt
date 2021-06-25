package com.example.wheatherapp.model.current

import com.google.gson.annotations.SerializedName

data class Main(
    val humidity: Int,
    @SerializedName("temp")
    val temperature: Double
)