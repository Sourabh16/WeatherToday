package com.sk.weather.domain.repository

import com.sk.weather.domain.model.CityForecast
import com.sk.weather.domain.model.CityWeather
import io.reactivex.Observable

interface Repository {

    fun getCityWeather(latitude: String, longitude: String): Observable<CityWeather>

    fun getCityForecast(latitude: String, longitude: String): Observable<CityForecast>
}
