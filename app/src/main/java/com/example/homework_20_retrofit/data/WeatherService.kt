package com.example.homework_20_retrofit.data

import com.example.homework_20_retrofit.data.model.current.CurrentWeather
import com.example.homework_20_retrofit.data.model.current.forecast.ForecastModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("data/2.5/weather")
    fun getWeather(@Query("q") city:String,
                   @Query("appId")appId :String,
                   @Query("units")units : String): Call<CurrentWeather>

    @GET("http://api.openweathermap.org/data/2.5/forecast")

    fun getForecast(@Query("q")city: String,
                    @Query("appid")appId: String,
                    @Query("units")units : String):Call<ForecastModel>




    //?q={city%20name},{state%20code}&cnt={cnt}%20&appid={your%20api%20key}

}
