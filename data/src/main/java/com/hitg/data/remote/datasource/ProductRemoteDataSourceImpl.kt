package com.hitg.data.remote.datasource

import com.hitg.data.remote.api.ProductAPI
import com.hitg.data.remote.mapper.ProductPayloadMapper
import com.hitg.domain.entity.Product
import io.reactivex.Single

class ProductRemoteDataSourceImpl(private val productAPI: ProductAPI) :
    ProductRemoteDataSource {
    override fun getProducts(): Single<List<Product>> {
        return productAPI.getProducts().map { ProductPayloadMapper.map(it) }
    }
}