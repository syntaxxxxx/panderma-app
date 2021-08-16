package com.example.panderma.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.panderma.core.entity.DataItem
import com.example.panderma.core.loadImage
import com.example.panderma.databinding.ItemListBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class DonorItem(private val donorItem: DataItem): AbstractBindingItem<ItemListBinding>() {

    override val type: Int
        get() = hashCode()

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemListBinding {
        return ItemListBinding.inflate(inflater, parent, false)
    }

    override fun bindView(binding: ItemListBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)
        binding.run {
            imageCalonPendonorTextview.loadImage(donorItem.cover!!)
        }
    }
}