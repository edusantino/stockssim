package com.santino.stockssim.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.santino.stockssim.R
import com.santino.stockssim.data.Company

class StocksAdapter(private val dataSet: List<Company>) :
    RecyclerView.Adapter<StocksAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val compTitle: TextView = view.findViewById(R.id.compTitleNameTextView)
        val compCode: TextView = view.findViewById(R.id.compCodeTextView)
        val imgUrl: ImageView = view.findViewById(R.id.compLogoImageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_companies, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.compTitle.text = dataSet[position].name
        viewHolder.compCode.text = dataSet[position].companyId

        Glide.with(viewHolder.imgUrl.context)
            .load(dataSet[position].imageUrl)
            .circleCrop()
            .centerCrop()
            .into(viewHolder.imgUrl)
    }

    override fun getItemCount() = dataSet.size
}