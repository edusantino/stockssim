package com.santino.stockssim.data

import com.santino.stockssim.data.StocksDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StocksRepository @Inject constructor(private val stocksDao: StocksDao) {
    fun getStocks() = stocksDao.getStocks()
}