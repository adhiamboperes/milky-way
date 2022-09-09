package com.adhiambo.themilkyway.sources

import com.adhiambo.themilkyway.common.RestInterface
import com.adhiambo.themilkyway.config.RestClient
import com.adhiambo.themilkyway.models.PhotoItem
import io.reactivex.rxjava3.core.Single

class PhotosNetworkSource {
    private val restInterface = RestClient.client.create(RestInterface::class.java)

    fun getPhotos(): Single<List<PhotoItem>> {
        return Single.fromCallable {
            val response = restInterface.searchPhotos().execute()

            if (!response.isSuccessful) {
                throw Exception()
            }
            response.body()?.collection?.items

        }
    }
}