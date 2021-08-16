package com.example.panderma.core.entity

import com.squareup.moshi.Json

data class ResponseDonor(

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val donor: Donor? = null,

	@Json(name="message")
	val message: String? = null
)

data class Donor(

	@Json(name="first_page_url")
	val firstPageUrl: String? = null,

	@Json(name="path")
	val path: String? = null,

	@Json(name="per_page")
	val perPage: Int? = null,

	@Json(name="data")
	val data: List<DataItem?>? = null,

	@Json(name="next_page_url")
	val nextPageUrl: Any? = null,

	@Json(name="from")
	val from: Int? = null,

	@Json(name="to")
	val to: Int? = null,

	@Json(name="prev_page_url")
	val prevPageUrl: Any? = null,

	@Json(name="current_page")
	val currentPage: Int? = null
)

data class DataItem(

	@Json(name="cover")
	val cover: String? = null,

	@Json(name="deadline_date")
	val deadlineDate: String? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="full_name")
	val fullName: String? = null,

	@Json(name="category_id")
	val categoryId: Int? = null,

	@Json(name="donor_id")
	val donorId: Int? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="deadline")
	val deadline: String? = null,

	@Json(name="type")
	val type: String? = null
)
