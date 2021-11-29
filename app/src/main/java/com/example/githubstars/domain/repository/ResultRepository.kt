package com.example.githubstars.domain.repository

import androidx.paging.PagingData
import com.example.githubstars.data.model.APIResponse
import com.example.githubstars.data.model.Item
import com.example.githubstars.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface ResultRepository {
    suspend fun getRepositories(language: String, sort: String, page: Int): Resource<APIResponse>

}