package com.ellycrab.imagesearch.data.repository

import com.ellycrab.imagesearch.data.remote.SearchImgRemoteDatasource
import com.ellycrab.imagesearch.presentation.search.model.toEntity
import com.ellycrab.imagesearch.presentation.repository.SearchImgRepository


/*
SearchImgRepository 인터페이스를 구현한 구현체입니다.
이 클래스는 외부 데이터 소스와 상호 작용하여 이미지 검색
데이터를 가져오고, 그 데이터를 프레젠테이션 레이어에서 필요한
형식으로 변환하여 반환함
getSearchImage메서드는 외부 데이터 소스에서 이미지 검색 데이터
를 가져와서 toEntity()함수를 호출하여 엔티티로 변환 후 반환

 */
class SearchImgRepositoryImpl(
    private val remoteImgDatasource: SearchImgRemoteDatasource,
) : SearchImgRepository {

    override suspend fun getSearchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ) = remoteImgDatasource.getSearchImage(
        query,
        sort,
        page,
        size
    ).toEntity()
}