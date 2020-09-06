package com.example.homework_20_retrofit.data.model.current.forecast

data class ForecastMain(
    val temp : Double,
    val feels_like : Double,
    val temp_min : Double,
    val temp_max : Double,
    val pressure : Int,
    val sea_level : Int,
    val gmd_level : Int,
    val humidity : Int,
    val temp_kf : Double

)