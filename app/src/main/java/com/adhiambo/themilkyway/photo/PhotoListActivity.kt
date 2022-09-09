package com.adhiambo.themilkyway.photo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.adhiambo.themilkyway.R

class PhotoListActivity : AppCompatActivity() {
    private lateinit var photosViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        photosViewModel = ViewModelProvider(this)[PhotoViewModel::class.java]

    }
}