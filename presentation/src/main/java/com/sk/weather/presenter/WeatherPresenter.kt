package com.sk.weather.presenter

import com.sk.weather.Constants.DEFAULT_LATITUDE
import com.sk.weather.Constants.DEFAULT_LONGITUDE
import com.sk.weather.domain.interactors.DefaultObserver
import com.sk.weather.domain.interactors.GetCityWeatherUseCase
import com.sk.weather.domain.model.CityWeather
import com.sk.weather.internal.di.scope.PerFragment
import com.sk.weather.model.mapper.CityWeatherModelDataMapper
import com.sk.weather.view.views.WeatherView
import javax.inject.Inject


@PerFragment
class WeatherPresenter @Inject constructor(
        private val getCityWeatherUseCase: GetCityWeatherUseCase,
        private val cityWeatherModelDataMapper: CityWeatherModelDataMapper) : BasePresenter {

    var view: WeatherView? = null

    override fun resume() {
        getCityWeatherUseCase.execute(CityWeatherObserver(),
                GetCityWeatherUseCase.Params.forCityWeather(DEFAULT_LATITUDE, DEFAULT_LONGITUDE))
    }

    override fun pause() {
    }

    override fun destroy() {
        getCityWeatherUseCase.dispose()
        view = null
    }

    private inner class CityWeatherObserver : DefaultObserver<CityWeather>() {

        override fun onError(e: Throwable) {
            super.onError(e)
            view?.error(e.message!!)
        }

        override fun onNext(cityWeather: CityWeather) {
            super.onNext(cityWeather)
            view?.setCityWeather(cityWeatherModelDataMapper.transform(cityWeather))
        }
    }

}