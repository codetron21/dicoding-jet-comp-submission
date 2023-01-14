package com.codetron.animeku.di

import com.codetron.animeku.viewmodel.detail.DetailViewModel
import com.codetron.animeku.viewmodel.home.HomeViewModel
import com.codetron.animeku.viewmodel.search.SearchViewModel
import com.codetron.animeku.viewmodel.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    fun getModules() = listOf(viewModelModule)

    private val viewModelModule = module {
        viewModel { SplashViewModel() }
        viewModel { HomeViewModel(get()) }
        viewModel { SearchViewModel(get()) }
        viewModel { DetailViewModel(get()) }
    }

}