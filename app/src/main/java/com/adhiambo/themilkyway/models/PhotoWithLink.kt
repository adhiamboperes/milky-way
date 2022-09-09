package com.adhiambo.themilkyway.models

import java.util.*

data class PhotoWithLink(
    var id: UUID? = null,
    var photo: Photo? = null,
    var photoLink: String? = null
)