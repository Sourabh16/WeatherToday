package com.sk.weather.data.entity.mapper

import com.sk.weather.data.entity.SysEntity
import com.sk.weather.domain.model.Sys
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class SysEntityDataMapper @Inject constructor() : EntryEntityMapper<Sys, SysEntity>() {

    override fun transform(entity: SysEntity?): Sys? {
        if (entity != null) {
            val sys = Sys()
            sys.type = entity.type
            sys.id = entity.id
            sys.message = entity.message
            sys.country = entity.country
            sys.sunrise = entity.sunrise
            sys.sunset = entity.sunset
            return sys
        }
        return null
    }
}