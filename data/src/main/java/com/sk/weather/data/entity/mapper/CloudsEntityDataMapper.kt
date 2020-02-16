package com.sk.weather.data.entity.mapper

import com.sk.weather.data.entity.CloudsEntity
import com.sk.weather.domain.model.Clouds
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class CloudsEntityDataMapper @Inject constructor() : EntryEntityMapper<Clouds, CloudsEntity>() {

    override fun transform(entity: CloudsEntity?): Clouds? {
        if (entity != null) {
            val clouds = Clouds()
            clouds.all = entity.all
            return clouds
        }
        return null
    }
}