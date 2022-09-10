package com.adhiambo.themilkyway.sources

import com.adhiambo.themilkyway.common.RestInterface
import com.adhiambo.themilkyway.config.MilkyWayException
import com.adhiambo.themilkyway.config.RestClient
import com.adhiambo.themilkyway.models.PhotoItem
import io.reactivex.rxjava3.core.Single

class PhotosNetworkSource {
    private val restInterface = RestClient.client.create(RestInterface::class.java)

    fun getPhotos(): Single<List<PhotoItem>> {
        return Single.fromCallable {
            val response = restInterface.searchPhotos().execute()

            if (!response.isSuccessful) {
                throw MilkyWayException(msg = "Api call returned an error $response")
            }
            response.body()?.collection?.items
        }
    }
}