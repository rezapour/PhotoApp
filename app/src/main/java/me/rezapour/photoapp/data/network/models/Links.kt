package me.rezapour.photoapp.data.network.models

import com.squareup.moshi.Json

data class Links(
    @field:Json(name = "download") val download: String

)
