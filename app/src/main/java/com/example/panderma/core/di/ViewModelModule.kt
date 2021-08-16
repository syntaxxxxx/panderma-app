package com.example.panderma.core.di

import com.example.panderma.presentation.home.HomeViewModel
import com.example.panderma.presentation.home.list.ListDonorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ListDonorViewModel(get()) }
}