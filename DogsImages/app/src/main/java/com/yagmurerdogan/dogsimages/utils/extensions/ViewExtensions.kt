package com.yagmurerdogan.dogsimages.utils.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(imageUrl: String, context: Context) {

    Glide.with(context)
        .load(imageUrl)
        .into(this)

}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}