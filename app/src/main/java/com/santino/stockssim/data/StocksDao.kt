package com.santino.stockssim.data

import androidx.room.*
import com.santino.stockssim.data.Company
import kotlinx.coroutines.flow.Flow

@Dao
interface StocksDao {
    @Query("SELECT * FROM companies")
    fun getStocks(): Flow<List<Company>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(companies: List<Company>)
}