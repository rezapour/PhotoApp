package me.rezapour.photoapp.data.network.api

import me.rezapour.photoapp.data.network.models.UnSplashSearchResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/photos/")
    suspend fun getPhotos(@Query("client_id") token: String): Response<List<UnSplashSearchResult>>
}