package com.sk.weather.internal.di.components

import android.app.Activity
import com.sk.weather.internal.di.modules.ActivityModule
import com.sk.weather.internal.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): Activity
}