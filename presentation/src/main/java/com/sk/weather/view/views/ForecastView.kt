package com.sk.weather.view.views

import com.sk.weather.model.CityForecastModel

interface ForecastView : BaseView {

    fun setCityForecast(cityForecast: CityForecastModel?)

}