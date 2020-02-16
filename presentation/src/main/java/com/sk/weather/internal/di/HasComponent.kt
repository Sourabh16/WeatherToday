package com.sk.weather.internal.di

interface HasComponent<C> {
    fun getComponent(): C
}