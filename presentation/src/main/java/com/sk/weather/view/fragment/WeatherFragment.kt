package com.sk.weather.view.fragment

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.sk.weather.Constants.SYMBOL_C
import com.sk.weather.R
import com.sk.weather.internal.di.components.MainComponent
import com.sk.weather.model.CityWeatherModel
import com.sk.weather.presenter.WeatherPresenter
import com.sk.weather.view.utils.WeatherUtils
import com.sk.weather.view.views.WeatherView
import kotlinx.android.synthetic.main.fragment_weather.*
import javax.inject.Inject

class WeatherFragment : BaseFragment(), WeatherView {

    @Inject lateinit var weatherPresenter: WeatherPresenter

    override fun getLayoutResource(): Int {
        return R.layout.fragment_weather
    }

    companion object {
        fun newInstance(): WeatherFragment {
            return WeatherFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        weatherPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        weatherPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        weatherPresenter.view = this
    }

    override fun setCityWeather(cityWeather: CityWeatherModel?) {
        progress_bar.visibility = GONE
        weatherLayout.visibility = VISIBLE
        iconWeather.setImageDrawable(context.resources.getDrawable(
                WeatherUtils.getIconWeather(cityWeather?.weather?.id?.toInt()!!)))
        cityText.text = cityWeather?.name
        tempText.text = (cityWeather?.main?.temp.toString() + SYMBOL_C)
        maxTempText.text = (cityWeather?.main?.temp_max.toString() + SYMBOL_C)
        minTempText.text = (cityWeather?.main?.temp_min.toString() + SYMBOL_C)
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}
