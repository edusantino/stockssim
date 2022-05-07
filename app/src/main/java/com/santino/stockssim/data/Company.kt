package com.santino.stockssim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
data class Company(
    @PrimaryKey @ColumnInfo(name = "id") val companyId: String,
    val name: String,
    val description: String,
    val initValue: Float,
    val imageUrl: String
)