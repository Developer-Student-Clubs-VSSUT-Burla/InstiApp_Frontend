package com.example.frontend


import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("api/projects/")
    suspend fun getPosts(): Response<List<ProjectModelItem>>

}
