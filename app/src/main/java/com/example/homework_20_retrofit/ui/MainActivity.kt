package com.example.homework_20_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework_20_retrofit.R
import com.example.homework_20_retrofit.data.RetrofitBuilder
import com.example.homework_20_retrofit.data.model.CurrentWeather
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.time.milliseconds

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitBuilder.getService()
            ?.getWeather("Bishkek", getString(R.string.api_key))
            ?.enqueue(object : Callback<CurrentWeather>{

                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Log.d("asd","Fail")
                }
                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    val data = response.body()

                    val country = data?.sys?.country.toString()
                    location.text = country

                    val temp = data?.main?.temp?.minus(273)?.toInt().toString() +"°"
                    temp_num.text = temp

                    val maxTemp = data?.main?.temp_max?.minus(273)?.toInt().toString() +"°"
                    temp_today_number.text = maxTemp

                    val minTemp = data?.main?.temp_min?.minus(273)?.toInt().toString() +"°"
                    min_number.text = minTemp

                    val wind = data?.wind?.speed.toString() + " m/s"
                    wind_num.text = wind

                    val pressure = data?.main?.pressure.toString() + " mb"
                    pressure_num.text = pressure

                    val humidity = data?.main?.humidity.toString() + "%"
                    humidity_num.text = humidity

                    val cloudiness = data?.clouds?.all.toString() + "%"
                    cloudiness_num.text = cloudiness

                }
            })

    }

    }


