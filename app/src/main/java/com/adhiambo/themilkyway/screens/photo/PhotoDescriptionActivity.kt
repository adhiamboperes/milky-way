package com.adhiambo.themilkyway.screens.photo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.adhiambo.themilkyway.R
import com.adhiambo.themilkyway.common.UiUtils.getMediumDate

class PhotoDescriptionActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var centerTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var descriptionTextView: TextView

    private lateinit var photoLink: String
    private lateinit var photoTitle: String
    private lateinit var photoCenter: String
    private lateinit var photoDate: String
    private lateinit var photoDescription: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_description)


        getIntentExtras()

        initializeViews()
    }

    private fun getIntentExtras() {
        photoLink = intent.getStringExtra("photoLink").toString()
        photoTitle = intent.getStringExtra("photoTitle").toString()
        photoCenter = intent.getStringExtra("photoCenter").toString()
        photoDate = intent.getStringExtra("photoDate").toString()
        photoDescription = intent.getStringExtra("photoDescription").toString()
    }

    private fun initializeViews() {
        imageView = findViewById(R.id.photo_view)
        descriptionTextView = findViewById(R.id.photo_description)
        titleTextView = findViewById(R.id.photo_title)
        centerTextView = findViewById(R.id.photo_center)
        dateTextView = findViewById(R.id.photo_date)

        imageView.load(photoLink)
        titleTextView.text = photoTitle
        centerTextView.text = photoCenter
        dateTextView.text = photoDate.getMediumDate()
        descriptionTextView.text = photoDescription
    }
}