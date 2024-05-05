package com.ellycrab.imagesearch.presentation.search.repository

import com.ellycrab.imagesearch.presentation.search.model.SearchImageEntity

/*
이 인터페이스는 데이터 레이어와의 통신을 추상화하고,
프레젠테이션 레이어에서 필요한 형식으로 데이터 제공
 */

/*
주 역할
1. 프레젠테이션 레이어에 대한 추상화
:이 인터페이스는 프레젠테이션 레이어에서 필요한
데이터를 가져오기 위한 메서드를 정의합니다.
이것은 데이터 레이어의 구체적인 구현과 프레젠테이션
레이어 간의 결합을 느슨하게 만듭니다.
2. 비즈니스 로직과 데이터 소스의 분리:
Repository 인터페이스는 비즈니스 로직에서
데이터 소스에 대한 의존성을 분리합니다.
이것은 프레젠테이션 레이어가 데이터 소스에 직접
액세스하지 않고, Repository를 통해 데이터에 액세스 할 수
있도록 합니다.
3. 동기 및 비동기 작업 지원:Repository의 메서드는
일반적으로 suspend 함수로 정의되어 있으며,
비동기적으로 데이터를 가져올 수 있다.
이는 메인스레드를 차단하지 않고 데이터를
가져올 수 있게 한다.
4. 엔터티 제공: 이는 프레젠테이션에서 사용되는
데이터의 형식을 나타낸다.
 */
interface SearchImgRepository {
    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchImageEntity
}