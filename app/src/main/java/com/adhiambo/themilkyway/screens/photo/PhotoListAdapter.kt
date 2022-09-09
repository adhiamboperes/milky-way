package com.adhiambo.themilkyway.screens.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.adhiambo.themilkyway.R
import com.adhiambo.themilkyway.common.UiUtils.getMediumDate
import com.adhiambo.themilkyway.models.PhotoWithLink

class PhotoListAdapter(
    private val photos: List<PhotoWithLink>,
    private val onClickListener: PhotoClickListener
) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.photoTitle?.text = photos[position].photo?.title
        holder.photoCenter?.text = photos[position].photo?.center
        holder.photoDate?.text = photos[position].photo?.date?.getMediumDate()
        val photoUrl = photos[position].photoLink
        holder.photoView?.load(photoUrl)
    }

    override fun getItemCount() = photos.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var photoTitle: TextView? = null
        var photoCenter: TextView? = null
        var photoDate: TextView? = null
        var photoView: ImageView? = null

        init {
            photoTitle = view.findViewById(R.id.item_photo_title)
            photoCenter = view.findViewById(R.id.item_photo_center)
            photoDate = view.findViewById(R.id.item_photo_date)
            photoView = view.findViewById(R.id.item_photo)

            view.setOnClickListener {
                onClickListener.onPhotoClick(adapterPosition)
            }
        }
    }

    interface PhotoClickListener {
        fun onPhotoClick(itemPosition: Int)
    }
}