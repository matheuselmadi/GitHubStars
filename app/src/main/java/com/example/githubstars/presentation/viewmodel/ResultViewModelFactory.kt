package com.example.githubstars.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubstars.data.api.GitHubService
import com.example.githubstars.domain.usecase.GetResultUseCase
import javax.inject.Inject

class ResultViewModelFactory(
    private val app: Application,
    private val resultUseCase: GetResultUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ResultViewModel(
            app,
            resultUseCase
        ) as T
    }
}