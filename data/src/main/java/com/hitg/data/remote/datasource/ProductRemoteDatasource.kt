package com.hitg.data.remote.datasource

import com.hitg.domain.entity.Product
import io.reactivex.Single

interface ProductRemoteDataSource {
    fun getProducts(): Single<List<Product>>
}