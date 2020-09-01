package com.example.homework_20_retrofit.data

import com.example.homework_20_retrofit.data.model.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("data/2.5/weather")
    fun getWeather(@Query("q") city:String,@Query("appid")appId :String ): Call<CurrentWeather>

}



//?q=Bishkek&appid=b11dc0a5c791b9901aa35dd046338dda