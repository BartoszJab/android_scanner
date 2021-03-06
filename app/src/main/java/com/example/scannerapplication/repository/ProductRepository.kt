package com.example.scannerapplication.repository

import com.example.scannerapplication.dao.ProductDao
import com.example.scannerapplication.models.Product
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: Flow<List<Product>> = productDao.getAllProducts()

    fun findByGivenData(data: String): Flow<List<Product>> {
        return productDao.findByGivenData(data)
    }

    suspend fun insert(product: Product) {
        productDao.insertProduct(product)
    }

    suspend fun update(product: Product) {
        productDao.updateProduct(product)
    }

    suspend fun increaseProductCount(barcode: String) {
        productDao.increaseProductCount(barcode)
    }

    suspend fun numberOfProductsHavingBarcode(barcode: String): Int {
        return productDao.numberOfProductsHavingBarcode(barcode)
    }

    suspend fun delete(uid: Int) {
        productDao.delete(uid)
    }
}