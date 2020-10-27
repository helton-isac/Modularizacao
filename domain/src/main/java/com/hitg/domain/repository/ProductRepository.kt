package com.hitg.domain.repository

import com.hitg.domain.entity.Product
import io.reactivex.Single

interface ProductRepository {
    fun getProducts(forceUpdate: Boolean): Single<List<Product>>
}