package me.rezapour.photoapp.data.network

import me.rezapour.photoapp.data.network.models.PhotosData
import retrofit2.http.GET
import retrofit2.http.Header

interface RemoteApi {
    @GET("/photos/")
    suspend fun getPhotos(@Header("client_id") token: String): List<PhotosData>
}