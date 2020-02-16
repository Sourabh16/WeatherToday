package com.sk.weather.view.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.sk.weather.R
import com.sk.weather.internal.di.components.MainComponent
import com.sk.weather.model.CityForecastModel
import com.sk.weather.presenter.ForecastPresenter
import com.sk.weather.view.adapter.ForecastAdapter
import com.sk.weather.view.component.ItemDecoration
import com.sk.weather.view.views.ForecastView
import kotlinx.android.synthetic.main.fragment_forecast.*
import java.util.*
import javax.inject.Inject

class ForecastFragment : BaseFragment(), ForecastView {

    @Inject lateinit var forecastPresenter: ForecastPresenter

    override fun getLayoutResource(): Int {
        return R.layout.fragment_forecast
    }

    companion object {
        fun newInstance(): ForecastFragment {
            return ForecastFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        forecastPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        forecastPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        forecastPresenter.view = this
    }

    override fun setCityForecast(cityForecast: CityForecastModel?) {
        var recycler = forecastRecycler
        val forecastAdapter = ForecastAdapter(ArrayList(cityForecast?.list))
        recycler.adapter = forecastAdapter
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.addItemDecoration(ItemDecoration(context, LinearLayoutManager.VERTICAL))
        progress_bar.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}