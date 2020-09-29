package me.rezapour.photoapp.data.network.models

import com.squareup.moshi.Json

data class PhotosData(
    @field:Json(name = "width") val width: Int,
    @field:Json(name = "height") val height: Int,
    @field:Json(name = "color") val color: String,
    @field:Json(name = "urls") val urls: Urls,
    @field:Json(name = "links") val links: Links
)