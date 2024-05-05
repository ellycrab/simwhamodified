package com.ellycrab.imagesearch.presentation.search.model

import java.util.Date



data class SearchImageEntity(
    val meta: MetaEntity?,
    val documents: List<ImageDocumentEntity>?,
)

data class MetaEntity(
    val totalCount: Int?,
    val pageableCount: Int?,
    val isEnd: Boolean?,
)



data class ImageDocumentEntity(
    val collection: String?,
    val thumbnailUrl: String?,
    val imageUrl: String?,
    val width: Int?,
    val height: Int?,
    val displaySitename: String?,
    val docUrl: String?,
    val datetime: Date?,
)
