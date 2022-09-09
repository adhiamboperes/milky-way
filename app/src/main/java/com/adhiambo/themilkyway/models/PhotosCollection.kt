package com.adhiambo.themilkyway.models

import com.google.gson.annotations.SerializedName

data class PhotosCollection(
    @SerializedName("items")
    var items: List<PhotoItem>
)
