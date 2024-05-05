package com.ellycrab.imagesearch.presentation.search.model

import com.ellycrab.imagesearch.data.model.ImageDocumentResponse
import com.ellycrab.imagesearch.data.model.MetaResponse
import com.ellycrab.imagesearch.data.model.SearchImageResponse

/*
어댑터 또는 매퍼 레이어는 애플리케이션의 여러 레이어 간에 데이터를 변환하는 역할을 한다.
여기가 데이터 모델과 프리젠테이션 계층 데이터 클래스 사이의 격차를 해소하는 곳
 */

fun SearchImageResponse.toEntity() = SearchImageEntity(
    meta = meta?.toEntity(),
    documents = documents?.map {
        it.toEntity()
    }
)

fun MetaResponse.toEntity() = MetaEntity(
    totalCount = totalCount,
    pageableCount = pageableCount,
    isEnd = isEnd,
)

fun ImageDocumentResponse.toEntity() = ImageDocumentEntity(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime,
)
