package com.example.githubstars.domain.usecase

import com.example.githubstars.data.model.APIResponse
import com.example.githubstars.data.util.Resource
import com.example.githubstars.domain.repository.ResultRepository

class GetResultUseCase (private val resultRepository: ResultRepository){
    suspend fun execute(language : String, sort: String, page : Int): Resource<APIResponse> {
        return resultRepository.getRepositories(language, sort, page)
    }
}