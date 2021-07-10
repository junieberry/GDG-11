package com.example.gdg11_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.databinding.ItemMainfeedBinding
import com.example.gdg11_android.databinding.MainFeedBinding
import com.example.gdg11_android.viewmodel.MainFeedViewModel

class MainFeedAdapter(val viewModel : MainFeedViewModel, val feed : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MainFeedViewHolder(val binding : ItemMainfeedBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun mainFeedBind(viewModel: MainFeedViewModel){
            binding.vm = viewModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMainfeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MainFeedViewHolder
        holder.mainFeedBind(viewModel)
    }

    override fun getItemCount(): Int {
        return feed
    }
}