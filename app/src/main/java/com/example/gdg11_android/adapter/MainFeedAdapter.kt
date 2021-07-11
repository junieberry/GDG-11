package com.example.gdg11_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.databinding.ItemMainfeedBinding
import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.viewmodel.MainFeedViewModel


class MainFeedAdapter(val viewModel : MainFeedViewModel,val size : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MainFeedViewHolder(val binding : ItemMainfeedBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun mainFeedBind(viewModel: MainFeedViewModel,position: Int){
            binding.vm = viewModel
            binding.position = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMainfeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MainFeedViewHolder
        holder.mainFeedBind(viewModel, position)
    }

    override fun getItemCount(): Int {
        return size
    }
}