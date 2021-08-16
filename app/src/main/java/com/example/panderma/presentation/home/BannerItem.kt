package com.example.panderma.presentation.home

import com.example.panderma.databinding.BannerItemBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.panderma.core.entity.Banner
import com.example.panderma.core.loadImage

class BannerItem(private val banner: Banner) : AbstractBindingItem<BannerItemBinding>() {

    override val type: Int
        get() = hashCode()

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): BannerItemBinding {
        return BannerItemBinding.inflate(inflater, parent, false)
    }

    override fun bindView(binding: BannerItemBinding, payloads: List<Any>) {
        binding.run {
            bannerImageView.loadImage(banner.image!!)
        }
    }
}


