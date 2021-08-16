package com.example.panderma.core.entity

import com.squareup.moshi.Json

data class ResponseDonorDetails(

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val donorDetails: DonorDetails? = null,

	@Json(name="message")
	val message: String? = null
)

data class DonorDetails(

	@Json(name="total_need")
	val totalNeed: Any? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="category_name")
	val categoryName: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="cover")
	val cover: String? = null,

	@Json(name="deadline_date")
	val deadlineDate: String? = null,

	@Json(name="full_name")
	val fullName: String? = null,

	@Json(name="category_id")
	val categoryId: Int? = null,

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="user_id")
	val userId: Int? = null,

	@Json(name="donor_id")
	val donorId: Int? = null,

	@Json(name="deadline")
	val deadline: String? = null
)
