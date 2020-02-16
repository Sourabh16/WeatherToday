package com.sk.weather.model.mapper

import com.sk.weather.domain.model.Clouds
import com.sk.weather.model.CloudsModel
import javax.inject.Inject

class CloudsModelDataMapper @Inject constructor() : EntryModelMapper<CloudsModel, Clouds>() {

    override fun transform(model: Clouds?): CloudsModel? {
        if (model != null) {
            val cloudsModel = CloudsModel()
            cloudsModel.all = model.all
            return cloudsModel
        }
        return null
    }
}