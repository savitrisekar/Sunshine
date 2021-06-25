package com.example.wheatherapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheatherapp.R
import com.example.wheatherapp.model.forecast.ForecastData
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastAdapter(private val mContext: Context, private val items: List<ForecastData>) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val data = items[position]
        holder.ivWeather
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivWeather: ImageView
        var tvDate: TextView
        var tvWeather: TextView
        var tvWeatherDsc: TextView
        var tvTemp: TextView

        init {
            ivWeather = view.iv_weather_dsc
            tvDate = view.tv_date
            tvWeather = view.tv_weather
            tvWeatherDsc = view.tv_weather_dsc
            tvTemp = view.tv_temp
        }

    }

}