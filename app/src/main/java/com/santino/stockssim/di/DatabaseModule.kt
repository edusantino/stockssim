package com.santino.stockssim.di

import android.content.Context
import com.santino.stockssim.data.StocksDao
import com.santino.stockssim.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providesStocksDao(appDatabase: AppDatabase): StocksDao {
        return appDatabase.stocksDao()
    }
}