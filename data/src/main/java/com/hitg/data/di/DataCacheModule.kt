package com.hitg.data.di

import com.hitg.data.local.database.ProductsDataBase
import com.hitg.data.local.datasource.ProductCacheDataSource
import com.hitg.data.local.datasource.ProductCacheDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {
    single { ProductsDataBase.createDataBase(androidContext()) }
    factory<ProductCacheDataSource> {
        ProductCacheDataSourceImpl(
            productDao =
            get()
        )
    }
}