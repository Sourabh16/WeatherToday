package com.sk.weather.presenter

import com.sk.weather.Constants.DEFAULT_LATITUDE
import com.sk.weather.Constants.DEFAULT_LONGITUDE
import com.sk.weather.domain.interactors.DefaultObserver
import com.sk.weather.domain.interactors.GetCityForecastUseCase
import com.sk.weather.domain.model.CityForecast
import com.sk.weather.internal.di.scope.PerFragment
import com.sk.weather.model.mapper.CityForecastModelDataMapper
import com.sk.weather.view.views.ForecastView
import javax.inject.Inject

@PerFragment
class ForecastPresenter @Inject constructor(
        private val getCityForecastUseCase: GetCityForecastUseCase,
        private val cityForecastModelDataMapper: CityForecastModelDataMapper) : BasePresenter {

    var view: ForecastView? = null

    override fun resume() {
        getCityForecastUseCase.execute(CityForecastObserver(),
                GetCityForecastUseCase.Params.forCityWeather(DEFAULT_LATITUDE, DEFAULT_LONGITUDE))
    }

    override fun pause() {
    }

    override fun destroy() {
        getCityForecastUseCase.dispose()
        view = null
    }

    private inner class CityForecastObserver : DefaultObserver<CityForecast>() {
        override fun onError(exception: Throwable) {
            super.onError(exception)
            view?.error(exception.message!!)
        }

        override fun onNext(cityForecast: CityForecast) {
            super.onNext(cityForecast)
            view?.setCityForecast(cityForecastModelDataMapper.transform(cityForecast))
        }
    }
}