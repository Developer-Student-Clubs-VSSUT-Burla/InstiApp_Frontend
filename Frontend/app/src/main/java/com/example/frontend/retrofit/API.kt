package com.example.frontend.retrofit

import com.example.frontend.EventModelItem
import com.example.frontend.ProjectModelItem
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("api/feeds/")
    suspend fun getFeeds():Response<List<Feed>>

    @GET("api/projects/")
    suspend fun getPosts(): Response<List<ProjectModelItem>>

    @GET("api/events/")
    suspend fun getEvents(): Response<List<EventModelItem>>


}