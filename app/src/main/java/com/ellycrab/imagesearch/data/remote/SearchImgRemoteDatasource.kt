package com.ellycrab.imagesearch.data.remote

import com.ellycrab.imagesearch.data.model.SearchImageResponse
import retrofit2.http.GET
import retrofit2.http.Query


/*
-외부 데이터 소스와 통신하기 위한 Retrofit 인터페이스
이 인터페이스에는 이미지 검색과 관련된 데이터를
가져오는 메서드가 정의됨
-Retrofit의 어노테이션과 쿼리 매개변수를 사용하여
http get 요청을 정의함
 */
interface SearchImgRemoteDatasource {

    @GET("/v2/search/image")
    suspend fun getSearchImage(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): SearchImageResponse
}