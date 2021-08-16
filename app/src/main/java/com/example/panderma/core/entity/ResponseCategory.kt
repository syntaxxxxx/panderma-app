package com.example.panderma.core.entity

import com.squareup.moshi.Json

data class ResponseCategory(

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val category: List<Category>? = null,

	@Json(name="message")
	val message: String? = null
)

data class Category(

	@Json(name="category_id")
	val categoryId: Int? = null,

	@Json(name="icon")
	val icon: String? = null
)
