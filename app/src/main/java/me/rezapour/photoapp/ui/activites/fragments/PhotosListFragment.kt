package me.rezapour.photoapp.ui.activites.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.rezapour.photoapp.R
import me.rezapour.photoapp.data.network.models.PhotosData
import me.rezapour.photoapp.ui.activites.adapters.PhotosRecyclerviewAdapter


class PhotosListFragment : Fragment() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: PhotosRecyclerviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview = view.findViewById(R.id.recycler_view_photos)
        val listPhoto = ArrayList<PhotosData>()
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        listPhoto.add(PhotosData(12))
        adapter = PhotosRecyclerviewAdapter(listPhoto)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = GridLayoutManager(activity, 3)
    }
}