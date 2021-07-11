package com.example.gdg11_android.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BindingAdapter {
    @BindingAdapter("bindingAdapter")
    fun bindingAdapter(recyclerView: RecyclerView, adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>){
        val layoutManager= LinearLayoutManager(recyclerView.context)
        layoutManager.orientation= RecyclerView.VERTICAL
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
    }
}