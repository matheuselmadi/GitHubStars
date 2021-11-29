package com.example.githubstars.presentation.di

import com.example.githubstars.data.api.GitHubService
import com.example.githubstars.data.repository.datasource.ResultRemoteDataSource
import com.example.githubstars.data.repository.datasourceimpl.ResultRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        gitHubService: GitHubService
    ): ResultRemoteDataSource {
        return ResultRemoteDataSourceImpl(gitHubService)
    }

}
