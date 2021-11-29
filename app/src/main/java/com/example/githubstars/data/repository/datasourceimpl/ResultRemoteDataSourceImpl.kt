package com.example.githubstars.data.repository.datasourceimpl

import com.example.githubstars.data.api.GitHubService
import com.example.githubstars.data.model.APIResponse
import com.example.githubstars.data.repository.datasource.ResultRemoteDataSource
import retrofit2.Response

class ResultRemoteDataSourceImpl(
    private val gitHubService: GitHubService
) : ResultRemoteDataSource{
    override suspend fun getRepositories(
        language: String,
        sort: String,
        page: Int
    ): Response<APIResponse> {
        return gitHubService.getRepositories(language, sort, page)
    }
}