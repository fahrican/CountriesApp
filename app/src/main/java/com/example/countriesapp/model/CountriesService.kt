package com.example.countriesapp.model

import com.example.countriesapp.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

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