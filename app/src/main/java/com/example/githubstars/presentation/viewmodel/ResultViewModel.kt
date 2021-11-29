package com.example.githubstars.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.*
import androidx.paging.*
import com.example.githubstars.data.api.GitHubService
import com.example.githubstars.data.model.APIResponse
import com.example.githubstars.data.model.Item
import com.example.githubstars.data.util.Resource
import com.example.githubstars.domain.usecase.GetResultUseCase
import com.example.githubstars.presentation.viewmodel.paging.ItemPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class ResultViewModel(
    private val app:Application,
    private val getResultUseCase: GetResultUseCase
): AndroidViewModel(app) {
    fun getListData(): Flow<PagingData<Item>> {
        return Pager (config = PagingConfig(pageSize = 30, maxSize = 200),
            pagingSourceFactory = {ItemPagingSource(getResultUseCase)}).flow.cachedIn(viewModelScope)
    }
}