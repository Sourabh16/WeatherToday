package com.sk.weather.data.entity.mapper

import com.sk.weather.data.entity.MainEntity
import com.sk.weather.domain.model.Main
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class MainEntityDataMapper @Inject constructor() : EntryEntityMapper<Main, MainEntity>() {

    override fun transform(entity: MainEntity?): Main? {
        if (entity != null) {
            val main = Main()
            main.temp = entity.temp
            main.pressure = entity.pressure
            main.humidity = entity.humidity
            main.temp_min = entity.temp_min
            main.temp_max = entity.temp_max
            return main
        }
        return null
    }
}