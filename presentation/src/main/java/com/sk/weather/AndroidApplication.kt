package com.sk.weather

import android.app.Application
import android.content.Context
import com.sk.weather.internal.di.components.ApplicationComponent
import com.sk.weather.internal.di.components.DaggerApplicationComponent
import com.sk.weather.internal.di.modules.ApplicationModule

class AndroidApplication : Application() {

    val applicationComponent: ApplicationComponent
        get() = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }

    companion object {

        operator fun get(context: Context): AndroidApplication {
            return context.applicationContext as AndroidApplication
        }
    }

}
