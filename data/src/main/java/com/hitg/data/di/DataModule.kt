package com.hitg.data.di

import com.hitg.data.repository.ProductRepositoryImpl
import com.hitg.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ProductRepository> {
        ProductRepositoryImpl(
            productsCacheDataSource = get(),
            productRemoteDataSource = get()
        )
    }

}
val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)