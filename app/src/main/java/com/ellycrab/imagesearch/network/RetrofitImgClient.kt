package com.ellycrab.imagesearch.network

import com.ellycrab.imagesearch.data.remote.SearchImgRemoteDatasource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitImgClient {

    private const val BASE_URL = "https://dapi.kakao.com"

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor("33f58a29004a5deccc24da94cfef4b1e"))
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val search: SearchImgRemoteDatasource by lazy {
        retrofit.create(SearchImgRemoteDatasource::class.java)
    }
}