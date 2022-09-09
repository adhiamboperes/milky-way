package com.adhiambo.themilkyway.screens.photo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adhiambo.themilkyway.R
import com.adhiambo.themilkyway.models.PhotoWithLink

class PhotoListActivity : AppCompatActivity() {
    private lateinit var photosRecyclerView: RecyclerView
    private lateinit var photosViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        photosViewModel = ViewModelProvider(this)[PhotoViewModel::class.java]

        initializeObservers()
    }

    private fun initializeObservers() {
        photosViewModel.getPhotos()
        photosViewModel.photosList.observe(this) {
            showPhotos(it)
        }

        photosViewModel.isSuccess.observe(this) {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }
    }

    private fun showPhotos(photosList: List<PhotoWithLink>) {
        photosRecyclerView = findViewById(R.id.photo_list)
        photosRecyclerView.apply {
            adapter = PhotoListAdapter(photos = photosList,
                onClickListener = object : PhotoListAdapter.PhotoClickListener {
                    override fun onPhotoClick(itemPosition: Int) {
                        val photoWithLink = photosList[itemPosition]
                        val intent = Intent(
                            this@PhotoListActivity,
                            PhotoDescriptionActivity::class.java
                        )
                        intent.putExtra("photoLink", photoWithLink.photoLink)
                        intent.putExtra("photoTitle", photoWithLink.photo?.title)
                        intent.putExtra("photoCenter", photoWithLink.photo?.center)
                        intent.putExtra("photoDate", photoWithLink.photo?.date)
                        intent.putExtra("photoDescription", photoWithLink.photo?.description)
                        startActivity(intent)
                    }
                }
            )
            layoutManager = LinearLayoutManager(this@PhotoListActivity)
        }
    }
}