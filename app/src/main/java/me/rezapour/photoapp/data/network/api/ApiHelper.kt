package me.rezapour.photoapp.data.network.api

import me.rezapour.photoapp.data.network.models.PhotosData
import retrofit2.Response

interface ApiHelper {
    suspend fun getPhotos(token: String): Response<List<PhotosData>>
}