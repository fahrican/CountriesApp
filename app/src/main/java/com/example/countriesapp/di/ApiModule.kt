package com.example.countriesapp.di

import com.example.countriesapp.model.CountriesApi
import com.example.countriesapp.model.CountriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://raw.githubusercontent.com"

    @Provides
    fun providesCountriesApi(): CountriesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // transfers data from the backend to Kotlin objects
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // makes Country class a Observable variable, so other variables can subscribe to it
            .build()
            .create(CountriesApi::class.java)
    }

    @Provides
    fun providesCountriesService(): CountriesService {
        return CountriesService()
    }
}