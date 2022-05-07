package com.santino.stockssim.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.santino.stockssim.data.StocksRepository
import com.santino.stockssim.data.Company
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StocksViewModel @Inject internal constructor(
    stocksRepository: StocksRepository
) : ViewModel() {
    val stocks: LiveData<List<Company>> = stocksRepository.getStocks().asLiveData()
}