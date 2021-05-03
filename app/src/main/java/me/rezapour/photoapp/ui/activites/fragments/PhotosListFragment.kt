package me.rezapour.photoapp.ui.activites.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.rezapour.photoapp.R
import me.rezapour.photoapp.business.model.PhotosData
import me.rezapour.photoapp.data.network.api.ApiHelperImpl
import me.rezapour.photoapp.data.network.api.RetrofitBuilder
import me.rezapour.photoapp.data.network.repository.MainRepository
import me.rezapour.photoapp.ui.activites.adapters.PhotosRecyclerviewAdapter
import me.rezapour.photoapp.viewmodel.MainViewModel
import me.rezapour.photoapp.viewmodel.MainViewModelFactory


class PhotosListFragment : Fragment() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: PhotosRecyclerviewAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var photoList: ArrayList<PhotosData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos_list, container, false)
    }

    //TODO(best way to define recycler view)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview = view.findViewById(R.id.recycler_view_photos)
        viewModel = ViewModelProvider(
            this, MainViewModelFactory(
                MainRepository(
                    ApiHelperImpl(
                        RetrofitBuilder.getApiServiceInstace()
                    )
                )
            )
        ).get(MainViewModel::class.java)
        photoList = ArrayList<PhotosData>()
        adapter = PhotosRecyclerviewAdapter(photoList)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = GridLayoutManager(activity, 3)
        setPhotos()
    }

    private fun setPhotos() {

        viewModel.getPhotots().observe(viewLifecycleOwner, {
            photoList.addAll(it)
            adapter.notifyItemInserted(0)

        })
    }

}