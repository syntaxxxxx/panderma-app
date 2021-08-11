package com.example.panderma.core.di

import com.example.panderma.core.data.MainRepositoryImpl
import com.example.panderma.core.data.remote.MainRemoteDataSourceImpl
import com.example.panderma.core.domain.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MainRemoteDataSourceImpl(get())
    }
    single<MainRepository> {
        MainRepositoryImpl(get())
    }
}