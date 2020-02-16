package com.sk.weather.model.mapper

import java.util.*

abstract class EntryModelMapper<ViewModel, Model> {

    abstract fun transform(model: Model?): ViewModel?

    fun transform(collection: Collection<Model>?): ArrayList<ViewModel> {
        val list = ArrayList<ViewModel>()
        var model: ViewModel?
        for (entity in collection!!) {
            model = transform(entity)
            if (model != null) {
                list.add(model)
            }
        }
        return list
    }
}