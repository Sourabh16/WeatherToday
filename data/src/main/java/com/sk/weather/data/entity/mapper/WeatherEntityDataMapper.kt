package com.sk.weather.data.entity.mapper

import com.sk.weather.data.entity.WeatherEntity
import com.sk.weather.domain.model.Weather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class WeatherEntityDataMapper @Inject constructor() :
        EntryEntityMapper<Weather, WeatherEntity>() {

    override fun transform(entity: WeatherEntity?): Weather? {
        if (entity != null) {
            val weather = Weather()
            weather.id = entity.id
            weather.main = entity.main
            weather.description = entity.description
            weather.icon = entity.icon
            return weather
        }
        return null
    }
}