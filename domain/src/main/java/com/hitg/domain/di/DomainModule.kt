package com.hitg.domain.di

import com.hitg.domain.usecases.GetProductsUseCase
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductsUseCase(
            productRepository = get(),
            scheduler = Schedulers.io()
        )
    }
}

val domainModule = listOf(useCaseModule)