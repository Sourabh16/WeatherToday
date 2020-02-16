package com.sk.weather.data.repository.datasource

import com.sk.weather.data.net.RestApi
import javax.inject.Inject

class DataFactory @Inject constructor(private val restApi: RestApi) {

    fun createCloudDataStore(): CloudDataStore {
        return CloudDataStore(restApi)
    }
}