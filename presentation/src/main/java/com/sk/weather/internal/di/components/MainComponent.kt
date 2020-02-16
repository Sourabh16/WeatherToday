package com.sk.weather.internal.di.components

import com.sk.weather.internal.di.modules.ActivityModule
import com.sk.weather.internal.di.modules.MainModule
import com.sk.weather.internal.di.scope.PerFragment
import com.sk.weather.view.activity.MainActivity
import com.sk.weather.view.fragment.ForecastFragment
import com.sk.weather.view.fragment.WeatherFragment
import dagger.Component

@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class, MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(weatherFragment: WeatherFragment)

    fun inject(forecastFragment: ForecastFragment)

}