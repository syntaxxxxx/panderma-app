package com.example.panderma

import android.app.Application
import com.example.panderma.core.di.networkModule
import com.example.panderma.core.di.repositoryModule
import com.example.panderma.core.di.viewModelModule
import org.koin.core.context.startKoin

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}