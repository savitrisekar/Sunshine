package com.example.wheatherapp.model.forecast

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("timezone")
    val timezone: Int
)
