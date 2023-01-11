package com.example.frontend.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("api/feeds/")
    suspend fun getFeeds():Response<List<Feed>>
}