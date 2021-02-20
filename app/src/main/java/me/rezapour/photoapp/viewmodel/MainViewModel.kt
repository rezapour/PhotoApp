package me.rezapour.photoapp.viewmodel

import androidx.lifecycle.ViewModel
import me.rezapour.photoapp.data.network.repository.MainRepository

class MainViewModel(
    val repository: MainRepository
) :
    ViewModel() {


//
//    fun getData() {
//
//        CoroutineScope(IO).launch {
//
//            try {
//                Log.d("PhotoAppTest", "start")
//                val respond = RetrofitBuilder.getPhotos()
//                Log.d("PhotoAppTest", "${respond.code()}")
//                if (respond.isSuccessful && respond.code() == 200)
//                    Log.d("PhotoAppTest", "Success")
//                else
//                    Log.d("PhotoAppTest", "Error")
//            } catch (e: Exception) {
//                Log.d("PhotoAppTest", "error form me: ${e.message}")
//            }
//
//
//        }
//
//    }
}