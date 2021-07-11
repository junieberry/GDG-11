package com.example.gdg11_android.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gdg11_android.R

object BindingAdapter {
    @BindingAdapter("bindingAdapter")
    fun bindingAdapter(recyclerView: RecyclerView, adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>){
        val layoutManager= LinearLayoutManager(recyclerView.context)
        layoutManager.orientation= RecyclerView.VERTICAL
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
    }
    @JvmStatic
    @BindingAdapter("ImageUrl")
    fun loadImage(imageView: ImageView, url: String?){
        if(!url.isNullOrEmpty()) {
            Glide.with(imageView.context)
                .load("$url")
                .error(R.drawable.examplecoffee).into(imageView)
        }
    }
}