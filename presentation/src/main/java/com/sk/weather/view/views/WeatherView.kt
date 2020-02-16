package com.sk.weather.view.views

import com.sk.weather.model.CityWeatherModel

interface WeatherView : BaseView {

    fun setCityWeather(cityWeather: CityWeatherModel?)

}