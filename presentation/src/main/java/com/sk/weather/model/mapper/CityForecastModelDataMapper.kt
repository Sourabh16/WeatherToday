package com.sk.weather.model.mapper

import com.sk.weather.domain.model.CityForecast
import com.sk.weather.model.CityForecastModel
import javax.inject.Inject

class CityForecastModelDataMapper @Inject constructor(
        private val cityModelDataMapper: CityModelDataMapper,
        private val forecastModelDataMapper: ForecastModelDataMapper) :
        EntryModelMapper<CityForecastModel, CityForecast>() {

    override fun transform(model: CityForecast?): CityForecastModel? {
        if (model != null) {
            val cityForecast = CityForecastModel()
            cityForecast.city = cityModelDataMapper.transform(model.city)
            cityForecast.list = forecastModelDataMapper.transform(model.list)
            return cityForecast
        }
        return null
    }
}