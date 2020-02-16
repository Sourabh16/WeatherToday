package com.sk.weather.view.activity

import android.os.Bundle
import com.sk.weather.R
import com.sk.weather.internal.di.HasComponent
import com.sk.weather.internal.di.components.DaggerMainComponent
import com.sk.weather.internal.di.components.MainComponent
import com.sk.weather.internal.di.modules.MainModule
import com.sk.weather.view.fragment.ForecastFragment
import com.sk.weather.view.fragment.WeatherFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), HasComponent<MainComponent> {
    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeActivity()
    }

    private fun initializeActivity() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_weather ->
                    replaceFragment(R.id.container, WeatherFragment.newInstance())
                R.id.action_forecast ->
                    replaceFragment(R.id.container, ForecastFragment.newInstance())
            }
            true
        }
        replaceFragment(R.id.container, WeatherFragment.newInstance())
    }

    private val mainComponent: MainComponent get() = DaggerMainComponent.builder()
            .applicationComponent(getApplicationComponent())
            .activityModule(getActivityModule())
            .mainModule(MainModule())
            .build()

    override fun getComponent(): MainComponent {
        return mainComponent
    }
}
