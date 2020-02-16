package com.sk.weather.internal.di.components

import android.content.Context
import com.sk.weather.AndroidApplication
import com.sk.weather.domain.executor.PostExecutionThread
import com.sk.weather.domain.executor.ThreadExecutor
import com.sk.weather.domain.repository.Repository
import com.sk.weather.internal.di.modules.ApplicationModule
import com.sk.weather.navigation.Navigator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(androidApplication: AndroidApplication)

    val androidApplication: AndroidApplication

    fun context(): Context

    fun navigator(): Navigator

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun Repository(): Repository
}