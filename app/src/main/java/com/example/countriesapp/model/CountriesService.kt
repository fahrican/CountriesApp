package com.example.countriesapp.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    private val BASE_URL = "https://raw.githubusercontent.com"
    private val api: CountriesApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // transfers data from the backend to Kotlin objects
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // makes Country class a Observable variable, so other variables can subscribe to it
            .build()
            .create(CountriesApi::class.java)
    }

    fun getCountries(): Single<List<Country>> { // Single emits one variable then closes
        return api.getCountries()
    }
}