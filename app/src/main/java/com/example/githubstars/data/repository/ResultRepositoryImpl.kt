package com.example.githubstars.data.repository

import android.util.Log
import com.example.githubstars.data.model.APIResponse
import com.example.githubstars.data.repository.datasource.ResultRemoteDataSource
import com.example.githubstars.data.util.Resource
import com.example.githubstars.domain.repository.ResultRepository
import retrofit2.Response

class ResultRepositoryImpl(
   private val resultRemoteDataSource: ResultRemoteDataSource
): ResultRepository {
   override suspend fun getRepositories(
      language: String,
      sort: String,
      page: Int
   ): Resource<APIResponse> {
      val a = resultRemoteDataSource.getRepositories(language, sort, page)
      Log.i("MYTAG","kkkkkkkkkk"+ a.body())
      return responseToResource(a)
   }

    fun responseToResource(response: Response<APIResponse>):Resource<APIResponse>{


      if(response.isSuccessful){
         response.body()?.let {result->
            Log.i("MYTAG", response.message())
            return Resource.Success(result)
         }
      }
      Log.i("MYTAG", response.message())
      return Resource.Error(response.message())
   }

}