package me.rezapour.photoapp.data.network.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import me.rezapour.photoapp.asset.Constans
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    private fun initRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constans.BASE_URL)
        .addConverterFactory(moshiConverterFactory())
        .client(initOkHttpClint())
        .build()

    private fun moshiConverterFactory() = MoshiConverterFactory
        .create(initMoshi())

    private fun initMoshi() = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private fun initOkHttpClint() = OkHttpClient.Builder()
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .writeTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(logger())
        .build()

    private fun logger() = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BASIC
    }

    fun getApiServiceInstace(): ApiService {
        return initRetrofit().create(ApiService::class.java)
    }

}
