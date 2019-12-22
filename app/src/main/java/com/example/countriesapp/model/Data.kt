package com.example.countriesapp.model

import com.squareup.moshi.Json

data class Country(
    @field:Json(name = "name")
    val countryName: String?,
    val capital: String?,
    @field:Json(name = "flagPNG")
    val flag: String
)