package com.example.homework_20_retrofit.data.model.current.forecast

data class ForecastModel(
    val cod : String,
    val message : Int,
    val cnt : Int,
    val city : CityModel,
    val list : List<ForecastItem>
)