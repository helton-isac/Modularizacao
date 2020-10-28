package com.hitg.data.local.datasource

import com.hitg.domain.entity.Product
import io.reactivex.Single

interface ProductCacheDataSource {

    fun getProducts(): Single<List<Product>>

    fun insertData(products: List<Product>)

    fun updateData(products: List<Product>)

}