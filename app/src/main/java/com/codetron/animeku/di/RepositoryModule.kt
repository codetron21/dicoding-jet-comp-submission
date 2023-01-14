package com.codetron.animeku.di

import com.codetron.animeku.data.repository.DataRepository
import com.codetron.animeku.data.repository.IDataRepository
import org.koin.dsl.module

object RepositoryModule {
    fun getModules() = listOf(dataModule)

    private val dataModule = module {
        single<IDataRepository> { DataRepository(get()) }
    }

}