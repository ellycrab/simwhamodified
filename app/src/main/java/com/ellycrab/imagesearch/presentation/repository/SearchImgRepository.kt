package com.ellycrab.imagesearch.presentation.repository

import com.ellycrab.imagesearch.presentation.search.model.SearchImageEntity

interface SearchImgRepository {
    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchImageEntity
}