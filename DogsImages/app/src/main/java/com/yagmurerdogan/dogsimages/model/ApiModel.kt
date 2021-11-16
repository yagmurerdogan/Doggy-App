package com.yagmurerdogan.dogsimages.model

import com.google.gson.annotations.SerializedName

data class ApiModel(
    @SerializedName("message")
    val url: String,
    val status: String
)