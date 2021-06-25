package com.example.wheatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wheatherapp.model.current.WeatherData
import com.example.wheatherapp.network.ApiCallback
import com.example.wheatherapp.repository.MainRepository

class MainViewModel : ViewModel() {
    private val mainRepository = MainRepository()

    val weatherData = MutableLiveData<WeatherData>()

    fun getData(city: String) {
        mainRepository.getDataCurrent(city, object : ApiCallback<WeatherData> {
            override fun onError(error: String?) {
                Log.e("response", "ERROR")
            }

            override fun onSuccess(data: WeatherData?) {
                weatherData.value = data
            }
        })
    }
}