package me.rezapour.photoapp.data.network.models

import com.squareup.moshi.Json

data class Urls(
    @field:Json(name = "thumb") val thumb: String,
    @field:Json(name = "small") val small: String,
    @field:Json(name = "full") val full: String,
    @field:Json(name = "regular") val regular: String
)
