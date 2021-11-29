package com.example.githubstars.data.api

import com.example.githubstars.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q")
        language:String,
        @Query("sort")
        sort:String,
        @Query("page")
        page:Int
    ): Response<APIResponse>
}

