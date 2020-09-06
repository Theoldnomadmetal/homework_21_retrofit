package com.example.homework_20_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework_20_retrofit.R
import com.example.homework_20_retrofit.data.RetrofitBuilder
import com.example.homework_20_retrofit.data.model.current.CurrentWeather
import com.example.homework_20_retrofit.data.model.current.forecast.ForecastModel
import com.example.homework_20_retrofit.ui.recycler.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecyclerAdapter()
        recycler.adapter = adapter

        RetrofitBuilder.getService()
            ?.getWeather("Bishkek", getString(R.string.api_key),"metric")
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

                    val temp = data?.main?.temp.toString() +"°"
                    temp_num.text = temp

                    val maxTemp = data?.main?.temp_max.toString() +"°"
                    temp_today_number.text = maxTemp

                    val minTemp = data?.main?.temp_min.toString() +"°"
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

        RetrofitBuilder.getService()?.getForecast("Bishkek",getString(R.string.api_key),"metric")
            ?.enqueue(object : Callback<ForecastModel>{
                override fun onFailure(call: Call<ForecastModel>, t: Throwable) {
                    Log.d("hey" , "nope")
                }

                override fun onResponse(
                    call: Call<ForecastModel>,
                    response: Response<ForecastModel>
                ) {
                    if (response.isSuccessful && response.body()!= null){
                        adapter.update(response.body()?.list)
                    }

                }

            })

    }

    }


