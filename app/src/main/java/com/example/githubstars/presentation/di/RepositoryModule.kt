package com.example.githubstars.presentation.di

import com.example.githubstars.data.repository.ResultRepositoryImpl
import com.example.githubstars.data.repository.datasource.ResultRemoteDataSource
import com.example.githubstars.domain.repository.ResultRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        resultRemoteDataSource: ResultRemoteDataSource
    ): ResultRepository {
        return ResultRepositoryImpl(
            resultRemoteDataSource
        )
    }

}