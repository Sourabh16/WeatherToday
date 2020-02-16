package com.sk.weather.internal.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.sk.weather.AndroidApplication
import com.sk.weather.Constants
import com.sk.weather.UIThread
import com.sk.weather.data.executor.JobExecutor
import com.sk.weather.data.repository.DataRepository
import com.sk.weather.domain.executor.PostExecutionThread
import com.sk.weather.domain.executor.ThreadExecutor
import com.sk.weather.domain.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val androidApplication: AndroidApplication) {

    @Provides
    @Singleton
    fun application(): AndroidApplication {
        return androidApplication
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return androidApplication
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return androidApplication.getSharedPreferences(Constants.SHARE_PREF, Context.MODE_APPEND)
    }

    @Provides
    @Singleton
    fun provideRepository(dataRepository: DataRepository): Repository {
        return dataRepository
    }

}
