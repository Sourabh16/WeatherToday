package com.sk.weather.domain.interactors

import com.sk.weather.domain.executor.PostExecutionThread
import com.sk.weather.domain.executor.ThreadExecutor
import com.sk.weather.domain.model.CityWeather
import com.sk.weather.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject


class GetCityWeatherUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                                postExecutionThread: PostExecutionThread,
                                                private val repository: Repository) :
        UseCase<CityWeather, GetCityWeatherUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<CityWeather> {
        return this.repository.getCityWeather(params.latitude, params.longitude)
    }

    class Params private constructor(val latitude: String, val longitude: String) {
        companion object {

            fun forCityWeather(latitude: String, longitude: String): Params {
                return Params(latitude, longitude)
            }
        }
    }
}