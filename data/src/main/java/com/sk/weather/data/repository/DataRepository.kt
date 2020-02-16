package com.sk.weather.data.repository

import com.sk.weather.data.entity.mapper.CityForecastEntityDataMapper
import com.sk.weather.data.entity.mapper.CityWeatherEntityDataMapper
import com.sk.weather.data.repository.datasource.DataFactory
import com.sk.weather.domain.model.CityForecast
import com.sk.weather.domain.model.CityWeather
import com.sk.weather.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class DataRepository
@Inject constructor(private val dataFactory: DataFactory,
                    private val cityWeatherEntityDataMapper: CityWeatherEntityDataMapper,
                    private val cityForecastEntityDataMapper: CityForecastEntityDataMapper) :
        Repository {

    override fun getCityWeather(latitude: String, longitude: String): Observable<CityWeather> {
        return dataFactory.createCloudDataStore()
                .getCityWeather(latitude, longitude)
                .map { cityWeatherEntityDataMapper.transform(it) }
    }

    override fun getCityForecast(latitude: String, longitude: String): Observable<CityForecast> {
        return dataFactory.createCloudDataStore()
                .getCityForecast(latitude, longitude)
                .map { cityForecastEntityDataMapper.transform(it) }
    }
}