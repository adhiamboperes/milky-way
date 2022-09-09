package com.adhiambo.themilkyway.repositories

import com.adhiambo.themilkyway.models.PhotoItem
import com.adhiambo.themilkyway.sources.PhotosNetworkSource
import io.reactivex.rxjava3.core.Single

class PhotosRepository {
    private val photoNetworkSource = PhotosNetworkSource()

    fun getPhotos(): Single<List<PhotoItem>> {
        return photoNetworkSource.getPhotos()}

    }