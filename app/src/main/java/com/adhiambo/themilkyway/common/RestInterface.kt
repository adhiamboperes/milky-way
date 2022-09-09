package com.adhiambo.themilkyway.common

import com.adhiambo.themilkyway.models.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET

interface RestInterface {
    @GET("search?q=milky%20way&media_type=image&year_start=2017&year_end=2017")
    fun searchPhotos(): Call<PhotosResponse>
    //TODO add pagination @Query("page") page: Int

}