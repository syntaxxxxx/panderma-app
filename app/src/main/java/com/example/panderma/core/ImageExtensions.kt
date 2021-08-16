package com.example.panderma.core

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.panderma.R

fun ImageView.loadImage(path: Any) {
    Glide.with(this)
        .load(path)
        .into(this)
}