package com.example.panderma.core.entity

import com.squareup.moshi.Json

data class ResponseBanner(

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val banner: List<Banner>? = null,

	@Json(name="message")
	val message: String? = null
)

data class Banner(

	@Json(name="image")
	val image: String? = null,

	@Json(name="banner_id")
	val bannerId: Int? = null
)
