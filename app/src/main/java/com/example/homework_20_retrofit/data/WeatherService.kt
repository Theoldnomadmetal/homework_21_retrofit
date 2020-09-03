package com.example.homework_20_retrofit.data

import com.example.homework_20_retrofit.data.model.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("data/2.5/weather")
    fun getWeather(@Query("q") city:String,
                   @Query("appId")appId :String ): Call<CurrentWeather>

}
