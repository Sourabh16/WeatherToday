package com.sk.weather.data.net

import com.sk.weather.data.entity.CityForecastEntity
import com.sk.weather.data.entity.CityWeatherEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("weather")
    fun getCityWeather(@Query("lat") latitude: String, @Query("lon") longitude: String,
                       @Query("units") units: String, @Query("APPID") appId: String):
            Observable<CityWeatherEntity>

    @GET("forecast")
    fun getCityForecast(@Query("lat") latitude: String, @Query("lon") longitude: String,
                        @Query("units") units: String, @Query("APPID") appId: String):
            Observable<CityForecastEntity>
}