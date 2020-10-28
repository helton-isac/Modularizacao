package com.hitg.data.remote.mapper

import com.hitg.data.remote.model.ProductPayload
import com.hitg.domain.entity.Product

object ProductPayloadMapper {
    fun map(products: List<ProductPayload>) = products.map { map(it) }
    private fun map(productPayload: ProductPayload) = Product(
        name = productPayload.name,
        imageURL = productPayload.imageURL,
        description = productPayload.description
    )
}