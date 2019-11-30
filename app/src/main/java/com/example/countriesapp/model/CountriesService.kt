package com.example.countriesapp.model

import com.example.countriesapp.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api: CountriesApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> { // Single emits one variable then closes
        return api.getCountries()
    }
}