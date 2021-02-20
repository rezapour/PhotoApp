package me.rezapour.photoapp.data.network.api

import me.rezapour.photoapp.data.network.models.PhotosData
import retrofit2.Response

class ApiHelperImpl(val apiService: ApiService) : ApiHelper {

    override suspend fun getPhotos(token: String): Response<List<PhotosData>> {
        return apiService.getPhotos(token)
    }
}