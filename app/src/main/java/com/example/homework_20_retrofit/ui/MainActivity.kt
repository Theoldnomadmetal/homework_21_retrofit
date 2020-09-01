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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitBuilder.getService()?.getWeather("Bishkek", getString(R.string.api_key))
            ?.enqueue(object : Callback<CurrentWeather> {

                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    if (response.isSuccessful&&response.body()!= null){
                        val data = response.body()
                        tv1.text = data?.main?.temp.toString()
                    }
                }
                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Log.d("test","nope")
                }

            })
    }
}