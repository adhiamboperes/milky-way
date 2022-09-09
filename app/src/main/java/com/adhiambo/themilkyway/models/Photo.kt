package com.adhiambo.themilkyway.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("nasa_id")
    var nasaId: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("center")
    var center: String? = null,
    @SerializedName("date_created")
    var date: String? = null,
    @SerializedName("description")
    var description: String? = null
)