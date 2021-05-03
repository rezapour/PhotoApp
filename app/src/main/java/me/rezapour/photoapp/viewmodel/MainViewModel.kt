package me.rezapour.photoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.rezapour.photoapp.BuildConfig
import me.rezapour.photoapp.business.model.PhotosData
import me.rezapour.photoapp.data.network.models.UnSplashSearchResult
import me.rezapour.photoapp.data.network.repository.MainRepository

class MainViewModel(
    val repository: MainRepository
) :
    ViewModel() {

    val photosData: MutableLiveData<List<PhotosData>> by lazy {
        MutableLiveData<List<PhotosData>>()
    }

    init {
        getData()
    }

    private fun getData() {
        Log.d("PhotoAppTest", "1111")
        viewModelScope.launch {
            try {
                val respond = repository.getPhotos(BuildConfig.UNSPLASH_TOKEN)
//                Log.d("PhotoAppTest", "${respond.code()}")
                Log.d("PhotoAppTest", "2222")
                if (respond.code() == 200) {
                    photosData.postValue(webMaper(respond.body()))
                } else
                    Log.d("PhotoAppTest", "Error")
            } catch (e: Exception) {
                Log.d("PhotoAppTest", "error form me: ${e.message}")
            }


        }

    }

    //Todo("Search about best way to mao to list and best place for it") and check null
    private fun webMaper(list: List<UnSplashSearchResult>?): List<PhotosData> {
        val photosList = ArrayList<PhotosData>()

        if (list != null) {
            for (item: UnSplashSearchResult in list) {
                photosList.add(
                    PhotosData(
                        "",
                        item.id,
                        item.width,
                        item.height,
                        item.color,
                        item.urls.full,
                        item.urls.regular,
                        item.urls.small,
                        item.urls.thumb

                    )
                )
            }
        }
        Log.d("PhotoAppTest", photosList.size.toString())
        return photosList
    }

    fun getPhotots(): MutableLiveData<List<PhotosData>> {
        return photosData
    }


}