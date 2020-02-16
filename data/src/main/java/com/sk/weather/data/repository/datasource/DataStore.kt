package com.sk.weather.data.repository.datasource

import com.sk.weather.data.entity.CityForecastEntity
import com.sk.weather.data.entity.CityWeatherEntity
import io.reactivex.Observable

interface DataStore {
    fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity>

    fun getCityForecast(latitude: String, longitude: String): Observable<CityForecastEntity>
}