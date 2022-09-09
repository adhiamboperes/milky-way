package com.adhiambo.themilkyway.usecases

import com.adhiambo.themilkyway.models.PhotoWithLink
import com.adhiambo.themilkyway.repositories.PhotosRepository
import io.reactivex.rxjava3.core.Single

class GetPhotosUseCase {
    private val photosRepository = PhotosRepository()

    fun execute(): Single<List<PhotoWithLink>> {
        return photosRepository.getPhotos().map {
            val photosList = mutableListOf<PhotoWithLink>()
            it.forEach { photoItem ->
                photosList.add(photoItem.toPhotoWithLink())
            }
            photosList
        }
    }
}