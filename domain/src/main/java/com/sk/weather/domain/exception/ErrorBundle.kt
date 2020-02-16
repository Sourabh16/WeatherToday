package com.sk.weather.domain.exception

interface ErrorBundle {
    val exception: Exception

    val errorMessage: String
}