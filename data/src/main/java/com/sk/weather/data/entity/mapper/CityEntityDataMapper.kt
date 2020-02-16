package com.sk.weather.data.entity.mapper

import com.sk.weather.data.entity.CityEntity
import com.sk.weather.domain.model.City
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class CityEntityDataMapper @Inject
constructor(private val coordinatesEntityDataMapper: CoordinatesEntityDataMapper) :
        EntryEntityMapper<City, CityEntity>() {

    override fun transform(entity: CityEntity?): City? {
        if (entity != null) {
            val city = City()
            city.id = entity.id
            city.name = entity.name
            city.coord = coordinatesEntityDataMapper.transform(entity.coord)
            city.country = entity.country
            return city
        }
        return null
    }
}