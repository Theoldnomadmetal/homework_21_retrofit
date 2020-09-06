package com.example.homework_20_retrofit.data.model.current.forecast

data class ForecastItem(
    val dt : Int,
    val visibility : Int,
    val pop : Double,
    val dt_txt : String,
    val main : ForecastMain
)