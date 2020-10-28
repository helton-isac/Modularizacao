package com.hitg.data.local.datasource

import com.hitg.data.local.database.ProductsDao
import com.hitg.data.local.mapper.ProductCacheMapper
import com.hitg.domain.entity.Product
import io.reactivex.Single

class ProductCacheDataSourceImpl(
    private val productDao: ProductsDao
) : ProductCacheDataSource {

    override fun getProducts(): Single<List<Product>> {
        return productDao.getProducts().map { ProductCacheMapper.map(it) }
    }

    override fun insertData(products: List<Product>) {

        productDao.insertAll(ProductCacheMapper.mapProductToProductCache(products))
    }

    override fun updateData(products: List<Product>) {

        productDao.updateData(ProductCacheMapper.mapProductToProductCache(products))
    }
}