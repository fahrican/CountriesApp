package com.example.countriesapp.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String?,
    val capital: String?,
    @SerializedName("flagPNG")
    val flag: String
)