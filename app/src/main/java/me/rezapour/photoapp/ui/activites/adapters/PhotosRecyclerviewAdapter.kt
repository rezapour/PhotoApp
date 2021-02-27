package me.rezapour.photoapp.ui.activites.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import me.rezapour.photoapp.R
import me.rezapour.photoapp.data.network.models.PhotosData

class PhotosRecyclerviewAdapter(val photosList: List<PhotosData>) :
    RecyclerView.Adapter<PhotosRecyclerviewAdapter.PhotoViewHolder>() {


    class PhotoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView

        init {
            imageView = view.findViewById(R.id.imageview_photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.single_photo_layouy, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = photosList.size


}