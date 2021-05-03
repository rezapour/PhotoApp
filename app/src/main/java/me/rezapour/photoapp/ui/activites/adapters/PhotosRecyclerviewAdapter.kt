package me.rezapour.photoapp.ui.activites.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.rezapour.photoapp.R
import me.rezapour.photoapp.business.model.PhotosData

class PhotosRecyclerviewAdapter(val photosList: List<PhotosData>) :
    RecyclerView.Adapter<PhotosRecyclerviewAdapter.PhotoViewHolder>() {


    class PhotoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageview_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.single_photo_layouy, parent, false)
        return PhotoViewHolder(view)
    }

    //Todo what should i do with contex bestWay you think
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        Log.d("morezatest", "start")
        Glide.with(holder.view).load(photosList.get(position).urlThumb).into(holder.imageView)
    }

    override fun getItemCount(): Int = photosList.size


}