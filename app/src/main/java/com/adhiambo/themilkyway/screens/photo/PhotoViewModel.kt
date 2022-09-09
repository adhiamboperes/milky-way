package com.adhiambo.themilkyway.screens.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhiambo.themilkyway.models.PhotoWithLink
import com.adhiambo.themilkyway.usecases.GetPhotosUseCase
import io.reactivex.rxjava3.schedulers.Schedulers

class PhotoViewModel : ViewModel() {

    private val getPhotosUseCase = GetPhotosUseCase()

    val photosList = MutableLiveData<List<PhotoWithLink>>()
    val isSuccess = MutableLiveData<Boolean>()

    fun getPhotos() {
        getPhotosUseCase.execute()
            .subscribeOn(Schedulers.io())
            .subscribe({
                isSuccess.postValue(true)
                photosList.postValue(it)
            }, {
                isSuccess.postValue(false)
            })
    }
}