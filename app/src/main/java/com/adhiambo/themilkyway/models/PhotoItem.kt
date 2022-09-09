package com.adhiambo.themilkyway.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.net.URL

open class PhotoItem {
    @SerializedName("href")
    var imageLinks: String? = null

    @SerializedName("data")
    var photosList = emptyList<Photo>()

    private fun getPhoto(): Photo {
        return this.photosList.first()
    }

    private fun getLink(): String {
        val linksJsonArray = URL(this.imageLinks).readText()
        return Gson().fromJson(linksJsonArray, Array<String>::class.java).toList()[0]
    }

    fun toPhotoWithLink(): PhotoWithLink{
        return PhotoWithLink(
            photo = this.getPhoto(),
            photoLink = this.getLink()
        )
    }
}