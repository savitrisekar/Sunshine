package com.example.wheatherapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.wheatherapp.model.current.WeatherData
import com.example.wheatherapp.network.ApiService
import com.example.wheatherapp.network.ApiCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val UNITS = "metric"
        const val API_KEY = "69135546828ada76b54fe3f6e48c5498"
    }

    var weatherData = MutableLiveData<WeatherData>()

    private var retrofit: Retrofit
    private var apiService: ApiService

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getDataCurrent(city: String, callback: ApiCallback<WeatherData>) {
        apiService.getCurrentWeather(city, UNITS, API_KEY).enqueue(object : Callback<WeatherData> {
            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                callback.onError("Error")
            }

            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                    weatherData.value = response.body()
                }
            }

        })
    }
}