package com.example.countriesapp.di

import com.example.countriesapp.model.CountriesService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)
}