package me.rezapour.photoapp.data.network.api

import me.rezapour.photoapp.data.network.models.UnSplashSearchResult
import retrofit2.Response

class ApiHelperImpl(val apiService: ApiService) : ApiHelper {

    override suspend fun getPhotos(token: String): Response<List<UnSplashSearchResult>> {
        return apiService.getPhotos(token)
    }
}