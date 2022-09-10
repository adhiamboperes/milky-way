package com.adhiambo.themilkyway.screens.photo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adhiambo.themilkyway.R
import com.adhiambo.themilkyway.models.PhotoWithLink

class PhotoListActivity : AppCompatActivity() {
    private lateinit var photosRecyclerView: RecyclerView
    private lateinit var photosProgressbar: ProgressBar
    private lateinit var photosErrorText: TextView

    private lateinit var photosViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        photosViewModel = ViewModelProvider(this)[PhotoViewModel::class.java]

        initializeViews()
        initializeObservers()
    }

    private fun initializeObservers() {
        photosViewModel.getPhotos()
        photosViewModel.photosList.observe(this) {
            showPhotos(it)
        }

        photosViewModel.isSuccess.observe(this) { success ->
            photosProgressbar.visibility = View.GONE

            if (!success) {
                photosErrorText.visibility = View.VISIBLE
                photosErrorText.text = getString(R.string.error_failed_to_load_photos)
            } else {
                photosErrorText.visibility = View.GONE
            }
        }
    }

    private fun showPhotos(photosList: List<PhotoWithLink>) {
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

    private fun initializeViews() {
        photosRecyclerView = findViewById(R.id.photo_list)
        photosProgressbar = findViewById(R.id.photo_list_progressbar)
        photosErrorText = findViewById(R.id.photo_list_error_text)
    }
}