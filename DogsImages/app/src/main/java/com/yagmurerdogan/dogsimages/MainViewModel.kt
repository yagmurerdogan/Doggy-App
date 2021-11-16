package com.yagmurerdogan.dogsimages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yagmurerdogan.dogsimages.model.ApiModel
import com.yagmurerdogan.dogsimages.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    val myResponse: MutableLiveData<Response<ApiModel>> = MutableLiveData()

    fun getDogImage() {
        viewModelScope.launch {
            val response: Response<ApiModel> = repository.getRandomDogImage()
            myResponse.value = response
        }
    }
}