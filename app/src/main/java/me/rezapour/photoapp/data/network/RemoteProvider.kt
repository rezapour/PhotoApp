package me.rezapour.photoapp.data.network

import me.rezapour.photoapp.asset.Constans
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RemoteProvider {

    companion object {
        private fun initRetrofit(): RemoteApi = Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(initMoshi())
            .client(initOkHttpClint())
            .build().create(RemoteApi::class.java)


        private fun initMoshi() = MoshiConverterFactory.create()

        private fun initOkHttpClint() = OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .writeTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(logger())
            .build()

        private fun logger() = HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BASIC
        }
    }
}