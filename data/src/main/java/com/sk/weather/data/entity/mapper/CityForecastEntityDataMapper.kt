package com.sk.weather.data.entity.mapper

import com.sk.weather.data.entity.CityForecastEntity
import com.sk.weather.domain.model.CityForecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class CityForecastEntityDataMapper @Inject
constructor(private val cityEntityDataMapper: CityEntityDataMapper,
            private val forecastEntityDataMapper: ForecastEntityDataMapper) :
        EntryEntityMapper<CityForecast, CityForecastEntity>() {

    override fun transform(entity: CityForecastEntity?): CityForecast? {
        if (entity != null) {
            val cityForecast = CityForecast()
            cityForecast.city = cityEntityDataMapper.transform(entity.city)
            cityForecast.list = forecastEntityDataMapper.transform(entity.list)
            return cityForecast
        }
        return null
    }
}