package me.rezapour.photoapp.data.network.repository

import me.rezapour.photoapp.data.network.api.ApiHelper
import me.rezapour.photoapp.data.network.models.PhotosData
import retrofit2.Response

class MainRepository(val apiHelper: ApiHelper) {
    suspend fun getPhotos(token: String): Response<List<PhotosData>> {
        return apiHelper.getPhotos(token)
    }
}