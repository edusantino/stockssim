package com.santino.stockssim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.santino.stockssim.adapters.StocksAdapter
import com.santino.stockssim.data.TokenService
import com.santino.stockssim.databinding.FragmentStocksListBinding
import com.santino.stockssim.viewmodel.StocksViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StocksFragment : Fragment() {

    @Inject
    lateinit var token: TokenService

    private val viewModel: StocksViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStocksListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        subscribeUi(binding)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentStocksListBinding) {
        viewModel.stocks.observe(viewLifecycleOwner) {
            val adapter = StocksAdapter(it)
            binding.apply {
                stocksNowRecyclerView.adapter = adapter
                stocksNowRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
            }
        }
    }
}