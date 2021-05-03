package me.rezapour.photoapp.business.model


data class PhotosData(
    val id: String,
    val websiteID: String,
    val width: Int,
    val height: Int,
    val color: String,
    val urlFull: String,
    val urlReqular: String,
    val urlSmall: String,
    val urlThumb: String
)