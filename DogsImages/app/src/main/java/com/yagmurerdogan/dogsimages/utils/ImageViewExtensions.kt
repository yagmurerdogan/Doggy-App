package com.yagmurerdogan.dogsimages.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(imageUrl: String, context: Context) {

    Glide.with(context)
        .load(imageUrl)
        .into(this)

    this.visibility = View.VISIBLE
}