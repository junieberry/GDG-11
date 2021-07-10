package com.example.gdg11_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.databinding.ItemTradeIngBinding
import com.example.gdg11_android.databinding.ItemTradeRequestBinding
import com.example.gdg11_android.databinding.ItemTradeResponceBinding
import com.example.gdg11_android.viewmodel.TradeViewModel

class TradeResponseAdapter(val viewModel : TradeViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class TradeResponseViewHolder(val binding : ItemTradeResponceBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(viewModel : TradeViewModel){
            binding.vm = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTradeResponceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TradeResponseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as TradeResponseViewHolder
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
return 1    }
}