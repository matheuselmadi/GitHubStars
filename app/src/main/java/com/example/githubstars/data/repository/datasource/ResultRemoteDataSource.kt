package com.example.githubstars.data.repository.datasource

import com.example.githubstars.data.model.APIResponse
import retrofit2.Response

interface ResultRemoteDataSource {
    suspend fun getRepositories( language:String, sort:String, page:Int): Response<APIResponse>
}