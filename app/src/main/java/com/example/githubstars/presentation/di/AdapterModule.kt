package com.example.githubstars.presentation.di

import com.example.githubstars.presentation.adapter.ResultAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun providesResultAdapter():ResultAdapter{
        return ResultAdapter()
    }
}