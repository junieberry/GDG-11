package com.example.gdg11_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.databinding.ItemTradeIngBinding
import com.example.gdg11_android.databinding.ItemTradeRequestBinding
import com.example.gdg11_android.databinding.ItemTradeResponceBinding
import com.example.gdg11_android.viewmodel.TradeViewModel

class TradeIngAdapter(val viewModel : TradeViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class TradeIngViewHolder(val binding : ItemTradeIngBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(viewModel : TradeViewModel){
            binding.vm = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTradeIngBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TradeIngViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as TradeIngViewHolder
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return 1
    }
}