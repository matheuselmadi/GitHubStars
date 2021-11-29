package com.example.githubstars.presentation.di

import android.app.Application
import com.example.githubstars.data.api.GitHubService
import com.example.githubstars.domain.usecase.GetResultUseCase
import com.example.githubstars.presentation.viewmodel.ResultViewModelFactory
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideResultViewModelFactory(
        application: Application,
        getResultUseCase: GetResultUseCase
    ): ResultViewModelFactory{
        return ResultViewModelFactory(
            application,
            getResultUseCase
        )
    }
}