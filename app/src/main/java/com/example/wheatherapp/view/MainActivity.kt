package com.example.wheatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.wheatherapp.R
import com.example.wheatherapp.model.current.WeatherData
import com.example.wheatherapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getData(edt_search.text.toString())

        initView()
        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel.weatherData.observe(this, { initData(it) })
    }

    private fun initView() {
        ibtn_search.setOnClickListener() {
            mainViewModel.getData(edt_search.text.toString())
        }
    }

    private fun initData(weatherData: WeatherData) {
        val icon = "http://openweathermap.org/img/wn/${weatherData.weather[0].icon}@2x.png"

        Glide.with(this)
            .load(icon)
            .override(80, 80)
            .into(iv_weather)

        tv_weather.text = weatherData.weather[0].main
        tv_weather_dsc.text = weatherData.weather[0].description
        tv_temp.text = weatherData.main.temperature.toString()
        tv_humidity.text = weatherData.main.humidity.toString()
        tv_visibility.text = weatherData.visibility.toString()
        tv_wind.text = weatherData.wind.speed.toString()
    }
}