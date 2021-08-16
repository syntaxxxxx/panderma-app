package com.example.panderma.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.panderma.core.entity.Category
import com.example.panderma.core.loadImage
import com.example.panderma.databinding.CategoryItemBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class CategoryItem(private val category: Category): AbstractBindingItem<CategoryItemBinding>( ){

    override val type: Int
        get() = hashCode()

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): CategoryItemBinding {
        return CategoryItemBinding.inflate(inflater, parent, false)
    }

    override fun bindView(binding: CategoryItemBinding, payloads: List<Any>) {
        binding.run {
//            titleTextView.text = category.
            categoryImageView.loadImage(category.icon!!)
        }
    }
}