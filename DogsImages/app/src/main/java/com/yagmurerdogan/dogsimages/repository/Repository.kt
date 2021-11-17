package com.yagmurerdogan.dogsimages.repository

import com.yagmurerdogan.dogsimages.api.RetrofitInstance
import com.yagmurerdogan.dogsimages.model.ApiModel
import retrofit2.Response


class Repository {

    suspend fun getRandomDogImage() : Response<ApiModel> {
        return RetrofitInstance.api.getRandomDog()
    }
}