package com.sk.weather.model.mapper

import com.sk.weather.domain.model.Coordinates
import com.sk.weather.model.CoordinatesModel
import javax.inject.Inject

class CoordinatesModelDataMapper @Inject constructor() :
        EntryModelMapper<CoordinatesModel, Coordinates>() {

    override fun transform(model: Coordinates?): CoordinatesModel? {
        if (model != null) {
            val coordinatesModel = CoordinatesModel()
            coordinatesModel.lon = model.lon
            coordinatesModel.lat = model.lat
            return coordinatesModel
        }
        return null
    }
}

