package com.example.gdg11_android.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.databinding.ItemTradeIngBinding
import com.example.gdg11_android.databinding.ItemTradeRequestBinding
import com.example.gdg11_android.databinding.ItemTradeResponceBinding
import com.example.gdg11_android.viewmodel.TradeViewModel

class TradeRequestAdapter(val viewModel : TradeViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class TradeRequestViewHolder(val binding : ItemTradeRequestBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(viewModel : TradeViewModel){
            binding.vm = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTradeRequestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TradeRequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as TradeRequestViewHolder
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return 1
    }
}