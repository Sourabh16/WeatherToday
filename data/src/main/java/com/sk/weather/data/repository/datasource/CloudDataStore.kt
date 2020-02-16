package com.sk.weather.data.repository.datasource

import com.sk.weather.data.entity.CityForecastEntity
import com.sk.weather.data.entity.CityWeatherEntity
import com.sk.weather.data.net.RestApi
import io.reactivex.Observable

class CloudDataStore(private val restApi: RestApi) : DataStore {

    override fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity> {
        return restApi.getCityWeather(latitude, longitude)
    }

    override fun getCityForecast(latitude: String, longitude: String): Observable<CityForecastEntity> {
        return restApi.getCityForecast(latitude, longitude)
    }
}