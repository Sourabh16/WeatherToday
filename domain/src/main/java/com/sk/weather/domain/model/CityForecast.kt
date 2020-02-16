package com.sk.weather.domain.model

open class CityForecast {

    open var city: City? = null
    open var list: Collection<Forecast>? = null

}