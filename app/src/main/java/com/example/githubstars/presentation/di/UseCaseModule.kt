package com.example.githubstars.presentation.di

import com.example.githubstars.domain.repository.ResultRepository
import com.example.githubstars.domain.usecase.GetResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetResultUseCase(resultRepository: ResultRepository): GetResultUseCase{
        return GetResultUseCase(resultRepository)
    }

}