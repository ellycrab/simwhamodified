package com.ellycrab.imagesearch.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date


/*
-SearchImageResponse: 애플리케이션이
처리하는 원시 데이터 구조를 나타낸다.
이 파일에는 외부 소스로부터 받은 데이터의 구조를 직접적으로
반영하는 클래스들이 포함되어 있다.

 */
data class SearchImageResponse(
    @SerializedName("meta") val meta: MetaResponse?,
    @SerializedName("documents") val documents: List<ImageDocumentResponse>?,
)

data class MetaResponse(
    @SerializedName("total_count") val totalCount: Int?,
    @SerializedName("pageable_count") val pageableCount: Int?,
    @SerializedName("is_end") val isEnd: Boolean?,
)

data class ImageDocumentResponse(
    @SerializedName("collection") val collection: String?,
    @SerializedName("thumbnail_url") val thumbnailUrl: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("display_sitename") val displaySitename: String?,
    @SerializedName("doc_url") val docUrl: String?,
    @SerializedName("datetime") val datetime: Date?,
)
