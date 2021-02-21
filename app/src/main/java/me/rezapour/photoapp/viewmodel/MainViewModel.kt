package me.rezapour.photoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.rezapour.photoapp.asset.Constans
import me.rezapour.photoapp.data.network.models.PhotosData
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

        viewModelScope.launch {
            try {
                val respond = repository.getPhotos(Constans.token)
                Log.d("PhotoAppTest", "${respond.code()}")
                if (respond.isSuccessful && respond.code() == 200)
                    photosData.postValue(respond.body())
                else
                    Log.d("PhotoAppTest", "Error")
            } catch (e: Exception) {
                Log.d("PhotoAppTest", "error form me: ${e.message}")
            }


        }

    }

    fun getPhotots(): MutableLiveData<List<PhotosData>> {
        return photosData
    }

}