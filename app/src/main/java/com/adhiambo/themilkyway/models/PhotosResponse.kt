package com.adhiambo.themilkyway.models

import com.google.gson.annotations.SerializedName

data class PhotosResponse(
   @SerializedName("collection")
   var collection: PhotosCollection
)